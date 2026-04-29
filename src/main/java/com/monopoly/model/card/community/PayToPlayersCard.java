package com.monopoly.model.card.community;

import java.util.List;

import com.monopoly.model.card.CommunityChestCard;
import com.monopoly.model.player.Player;
import com.monopoly.context.GameContext;

public class PayToPlayersCard extends CommunityChestCard {
    private int amount;

    public PayToPlayersCard(String description, int amount){
        super(description);
        this.amount = amount;
    }

    @Override
    public void apply(Player player, GameContext context){
        List<Player> others = context.getOtherPlayers(player);
        for(Player other : others){
            if(player.deductBalance(amount)){
                other.addBalance(amount);
                System.out.println(player.getName() + " paid $" + amount + " to " + other.getName());
            }
        }
    }
}
