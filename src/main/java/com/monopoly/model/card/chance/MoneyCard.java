package com.monopoly.model.card.chance;

import com.monopoly.model.card.ChanceCard;
import com.monopoly.model.player.Player;
import com.monopoly.context.GameContext;

public class MoneyCard extends ChanceCard{
    private int amount;

    public MoneyCard(String description, int amount){
        super(description);
        this.amount = amount;
    }

    @Override
    public void apply(Player player, GameContext context){
        if(amount >= 0){
            player.addBalance(amount);
        }else{
            player.deductBalance(amount);
        }
    }
}