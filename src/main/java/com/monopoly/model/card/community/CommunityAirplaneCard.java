package com.monopoly.model.card.community;

import com.monopoly.context.GameContext;
import com.monopoly.model.card.CommunityChestCard;
import com.monopoly.model.player.Player;

public class CommunityAirplaneCard extends CommunityChestCard {

    public CommunityAirplaneCard(String description){
        super(description);
    }

    @Override
    public void apply(Player player, GameContext context) {
        context.triggerAirplaneChoice(player); //Có thể hỏi player chọn 1 ô muốn đến
    }
}
