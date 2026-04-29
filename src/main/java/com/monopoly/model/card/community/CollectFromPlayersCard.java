package com.monopoly.model.card.community;

import java.util.List;

import com.monopoly.model.card.CommunityChestCard;
import com.monopoly.model.player.Player;
import com.monopoly.context.GameContext;

public class CollectFromPlayersCard extends CommunityChestCard {
    private int amount;

    public CollectFromPlayersCard(String description, int amount){
        super(description);
        this.amount = amount;
    }

    @Override
    public void apply(Player player, GameContext context){
        List<Player> others = context.getOtherPlayers(player);
        for(Player other : others){
           if(other.deductBalance(amount)){
               player.addBalance(amount);
               System.out.println(other.getName() + " paid $" + amount + " to " + player.getName());
           }
        }
    }
}
