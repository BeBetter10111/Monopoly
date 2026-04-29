package com.monopoly.model.card.community;

import com.monopoly.context.GameContext;
import com.monopoly.model.card.CommunityChestCard;
import com.monopoly.model.player.Player;

public class BankMoneyCard extends CommunityChestCard {
    private int amount;
    public BankMoneyCard(String description, int amount){
        super(description);
        this.amount = amount;
    }

    @Override
    public void apply(Player player, GameContext context){
        if(amount >= 0){
            player.addBalance(amount);
        }
    }
}
