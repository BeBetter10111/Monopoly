package com.monopoly.model.card.community;

import com.monopoly.context.GameContext;
import com.monopoly.model.card.CommunityChestCard;
import com.monopoly.model.player.Player;

public class TaxCard extends CommunityChestCard {
    private int taxAmount;

    public TaxCard(String description, int taxAmount){
        super(description);
        this.taxAmount = taxAmount;
    }

    @Override
    public void apply(Player player, GameContext context){
        player.deductBalance(taxAmount);
    }
}
