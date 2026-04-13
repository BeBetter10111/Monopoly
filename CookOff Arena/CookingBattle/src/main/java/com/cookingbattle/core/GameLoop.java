package com.cookingbattle.core;

import com.cookingbattle.battle.BattleSession;
import com.cookingbattle.battle.judge.CompositeJudge;
import com.cookingbattle.battle.judge.IJudge;
import com.cookingbattle.battle.judge.ScoreJudge;
import com.cookingbattle.battle.judge.TimeJudge;
import com.cookingbattle.domain.MatchResult;
import com.cookingbattle.domain.Recipe;
import com.cookingbattle.infrastructure.RecipeLoader;
import com.cookingbattle.player.AIPlayer;
import com.cookingbattle.player.HumanPlayer;
import com.cookingbattle.player.IPlayer;
import com.cookingbattle.player.ai.EasyStrategy;
import com.cookingbattle.player.ai.HardStrategy;
import com.cookingbattle.player.ai.IAIStrategy;
import com.cookingbattle.ui.BattleUI;
import com.cookingbattle.ui.MenuUI;

import java.util.List;
import java.util.Scanner;

public class GameLoop {
    private final MenuUI menuUI;
    private final BattleUI battleUI;
    private final BattleSession battleSession;
    private final RecipeLoader recipeLoader;
    private final EventBus eventBus;
    private final Scanner scanner;

    public GameLoop(MenuUI menuUI, BattleUI battleUI, BattleSession battleSession, RecipeLoader recipeLoader, Scanner scanner) {
        this.menuUI = menuUI;
        this.battleUI = battleUI;
        this.battleSession = battleSession;
        this.recipeLoader = recipeLoader;
        this.scanner = scanner;
        this.eventBus = new EventBus();
        this.eventBus.subscribe(System.out::println);
    }

    public void start() {
        boolean playAgain;
        do {
            runMatch();
            playAgain = menuUI.askReplay();
        } while (playAgain);
    }

    private void runMatch() {
        List<Recipe> recipes = recipeLoader.loadRecipes();
        int mode = menuUI.selectMode();
        int rounds = menuUI.selectRounds();
        IJudge judge = buildJudge(menuUI.selectJudgeMode());

        IPlayer p1 = new HumanPlayer(menuUI.askPlayerName("Player 1 name: "), scanner);
        IPlayer p2 = createSecondPlayer(mode);

        for (int round = 1; round <= rounds; round++) {
            Recipe chosen = chooseRecipeForRound(recipes, p2, round);
            battleUI.renderDuel(round, rounds, chosen);
            MatchResult result = battleSession.startRound(p1, p2, chosen, judge);
            battleUI.showScore(result);
        }

        battleUI.showFinalScoreboard(p1.getName(), p1.getScore(), p2.getName(), p2.getScore());
        String winner = p1.getScore() >= p2.getScore() ? p1.getName() : p2.getName();
        eventBus.emit("Game finished. Winner: " + winner);
    }

    private IPlayer createSecondPlayer(int mode) {
        if (mode == 1) {
            int diff = menuUI.selectAiDifficulty();
            IAIStrategy strategy = diff == 2 ? new HardStrategy(3) : new EasyStrategy();
            return new AIPlayer("ChefBot", strategy);
        }
        return new HumanPlayer(menuUI.askPlayerName("Player 2 name: "), scanner);
    }

    private Recipe chooseRecipeForRound(List<Recipe> recipes, IPlayer p2, int round) {
        if (p2 instanceof AIPlayer aiPlayer) {
            return chooseForAi(recipes, aiPlayer);
        }
        return recipes.get((round - 1) % recipes.size());
    }

    private IJudge buildJudge(int judgeMode) {
        if (judgeMode == 2) {
            return new TimeJudge();
        }
        if (judgeMode == 3) {
            return new CompositeJudge(List.of(new ScoreJudge(), new TimeJudge()));
        }
        return new ScoreJudge();
    }

    private Recipe chooseForAi(List<Recipe> recipes, AIPlayer aiPlayer) {
        return aiPlayer.decideRecipe(recipes);
    }
}
