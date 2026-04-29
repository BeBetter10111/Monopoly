package com.monopoly.model.card.community;

import com.monopoly.context.GameContext;
import com.monopoly.model.card.CommunityChestCard;
import com.monopoly.model.player.Player;

public class SchoolFeeCard extends CommunityChestCard {
    private int feeAmount;
    public SchoolFeeCard(String description, int feeAmount){
        super(description);
        this.feeAmount = feeAmount;
    }

    @Override
    public void apply(Player player, GameContext context) {
        player.deductBalance(feeAmount);
    }
}
