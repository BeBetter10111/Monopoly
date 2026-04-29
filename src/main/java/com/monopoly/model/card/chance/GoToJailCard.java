package com.monopoly.model.card.chance;

import com.monopoly.model.card.ChanceCard;
import com.monopoly.model.player.Player;
import com.monopoly.context.GameContext;

public class GoToJailCard extends ChanceCard{
    public GoToJailCard(String description){
        super(description);
    }

    @Override
    public void apply(Player player, GameContext context){
        player.goToJail();
    }
}
