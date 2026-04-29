package com.monopoly.model.player;
import com.monopoly.model.tile.PropertyTile;
import com.monopoly.model.interfaces.IBuyStrategy;
public class AIPlayer extends Player {
    private IBuyStrategy buyStrategy;
    public AIPlayer(String name, int  initialBalance, IBuyStrategy buyStrategy) {
        super(name, initialBalance);
        this.buyStrategy = buyStrategy;
    }

    @Override
    public void takeTurn(int  dice1, int dice2) {
        move(dice1 + dice2);
    }

    @Override
    public void onLandDecision(PropertyTile property, boolean wantToBuy) {
        boolean shouldBuy = buyStrategy.shouldBuy(property, this.balance);
        if (shouldBuy) {
            boolean success = deductBalance(property.getPrice());
            if (success) {
                System.out.println(name + "bought " + property.getName() + "success");
            }
            else {
                System.out.println(name + "did not buy");
            }
        }
    }
}
