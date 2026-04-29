package com.monopoly.model.card.chance;

import com.monopoly.model.card.ChanceCard;
import com.monopoly.context.GameContext;
import com.monopoly.model.player.Player;

public class TargetPlayerCard extends ChanceCard {
    public TargetPlayerCard(String description) {
        super(description);
    }

    @Override
    public void apply(Player player, GameContext context) {
        // UI/GameController will prompt current player to choose a target
        context.triggerTargetPlayerChoice(player);
    }
}
