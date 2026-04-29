package com.monopoly.model.card.chance;

import com.monopoly.model.card.ChanceCard;
import com.monopoly.model.player.Player;
import com.monopoly.context.GameContext;

public class RepairCard extends ChanceCard {
        private int costPerHouse;
        private int costPerHotel;

        public RepairCard(String description, int costPerHouse, int costPerHotel){
            super(description);
            this.costPerHouse = costPerHouse;
            this.costPerHotel = costPerHotel;
        }
        @Override
        public void apply(Player player, GameContext context){
            int houses = context.getHousesOwnedBy(player);
            int hotels = context.getHotelsOwnedBy(player);

            // Logic tính tiền để chi trả nếu có nhà hoặc khách sạn
            if(houses == 0 && hotels == 0){
                System.out.println(player.getName() + " has no houses or hotels.No repair fee.");
                return; // Ngay lập tức kết thúc phương thức này
            }

            int total = (houses * costPerHouse) + (hotels * costPerHotel);
            player.deductBalance(total);
            System.out.println(player.getName() + " paid $" + total + " for repairing.");
        }

}
