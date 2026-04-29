package com.monopoly.model.card.chance;

import com.monopoly.model.card.ChanceCard;
import com.monopoly.context.GameContext;
import com.monopoly.model.player.Player;

public class AirplaneCard extends ChanceCard {

    public AirplaneCard(String description){
        super(description);
    }

    @Override
    public void apply(Player player, GameContext context) {
        context.triggerAirplaneChoice(player); //Có thể hỏi player chọn 1 ô muốn đến
    }
}
