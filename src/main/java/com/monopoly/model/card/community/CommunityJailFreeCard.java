package com.monopoly.model.card.community;

import com.monopoly.model.card.CommunityChestCard;
import com.monopoly.model.player.Player;
import com.monopoly.context.GameContext;

public class CommunityJailFreeCard extends CommunityChestCard {
    public CommunityJailFreeCard(String description){
        super(description);
    }

    public void apply(Player player, GameContext context){
        player.addJaillFreeCard();
    }
}
