package main.java.cooking.player;
import main.java.cooking.domain.Dish;
import main.java.cooking.domain.Recipe;
import main.java.cooking.ai.IAIStrategy;
import java.util.Scanner;
public class AIPlayer implements IPlayer {
    private String name;
    private int score;
    private IAISTrategy strategy;
    public AIPlayer(String name, IAIStrategy strategy){
        this.name = name;
        this.score = 0;
        this.strategy = strategy;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public int getScore(){
        return score;
    }

    @Override
    public void addScore(int points){
        this.score += points;
    }
    @Override
    public  void resetScore(){
        this.score = 0;
    }

    @Override
    public Dish cook(Recipe recipe){
        return null;
    }
    public void setStrategy(){
        this.strategy = strategy;
    }
}
