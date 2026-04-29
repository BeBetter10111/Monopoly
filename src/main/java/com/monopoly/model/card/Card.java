package com.monopoly.model.card;

import com.monopoly.model.player.Player;
import com.monopoly.context.GameContext;

public abstract class Card implements ICard {
    protected String description;

    public Card(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract void apply(Player player, GameContext context);
}