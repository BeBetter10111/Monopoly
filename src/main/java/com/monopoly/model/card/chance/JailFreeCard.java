package com.monopoly.model.card.chance;

import com.monopoly.model.card.ChanceCard;
import com.monopoly.model.player.Player;
import com.monopoly.context.GameContext;

public class JailFreeCard extends ChanceCard {
    public JailFreeCard(String description){
        super(description);
    }

    public void apply(Player player, GameContext context){
        player.addJaillFreeCard();
    }
}
