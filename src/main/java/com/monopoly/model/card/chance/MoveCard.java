package com.monopoly.model.card.chance;

import com.monopoly.model.card.ChanceCard;
import com.monopoly.model.player.Player;
import com.monopoly.context.GameContext;

public class MoveCard extends ChanceCard {
    private int value;
    private boolean absolute; // Đại diện cho bến tàu/GO

    public MoveCard(String description, int value, boolean absolute){
        super(description);
        this.value = value;
        this.absolute = absolute;
    }

    @Override
    public void apply(Player player, GameContext context){
        if(absolute){
            int oldPos = player.getPosition();
            player.setPosition(value);

            if(value < oldPos){
                player.addBalance(200);
                }
            }else{
            player.move(value); // trong phương thức(method) move() ở player đã có sẵn logic +200 khi di chuển bằng step rồi
        }
    }
}
