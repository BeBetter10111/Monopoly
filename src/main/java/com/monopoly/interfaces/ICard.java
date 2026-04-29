package com.monopoly.model.card;

import com.monopoly.context.GameContext;
import com.monopoly.model.player.Player;

public interface ICard {
    void apply(Player player, GameContext context);
    String getDescription();
}
