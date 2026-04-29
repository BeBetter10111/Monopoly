package com.monopoly.model.card;

import com.monopoly.model.card.chance.*;
import com.monopoly.model.card.community.*;
import java.util.ArrayList;
import java.util.List;

public class CardFactory {
    public static CardDeck createChanceDeck(){
        List<ICard> cards = new ArrayList<>();

        //Di chuyển
        cards.add(new MoveCard("Advance to Go. Collect $200.", 0, true));
        cards.add(new MoveCard("Advance to the Railroad.", 5, true));
        cards.add(new MoveCard("Advance 3 spaces.", 3, false));
        cards.add(new MoveCard("Go back 3 spaces.", -3, false));

        //Tài chính
        cards.add(new MoneyCard("Bank pays you dividend of $50.", 50));
        cards.add(new MoneyCard("Collect $200 salary.", 200));
        cards.add(new MoneyCard("Pay poor tax of $15.", -15));
        cards.add(new MoneyCard("Pay speeding fine of $15.", -15));

        //Sửa chửa nhà/khách sạn
        cards.add(new RepairCard("Make general repairs. Both house and hotel are $25 .", 25, 25));

        //Vào tù
        cards.add(new GoToJailCard("Directly allocated to jail!"));

        //Ra tù
        cards.add(new JailFreeCard("get liberation for getting out of jail."));

        //Máy bay
        cards.add(new AirplaneCard("Take a flight to any title on the board!"));

        // Custom rule - chỉ định người khác
        cards.add(new TargetPlayerCard("Choose any player to send to Jail!"));
        cards.add(new TargetPlayerCard("Choose any player to move forward or backward!"));
        cards.add(new TargetPlayerCard("Freeze any player for 1 turn!"));
        cards.add(new TargetPlayerCard("Downgrade any house of another player by 1 level!"));

        return new CardDeck(cards);
    }

    public static CardDeck createCommunityChestDeck(){
        List<ICard> cards = new ArrayList<>();

        cards.add(new BankMoneyCard("Bank error in you favor. Collect $20.", 200));
        cards.add(new BankMoneyCard("Income tax refund. Collect $20.", 20));
        cards.add(new BankMoneyCard("You have won second prize in a beauty contest. Collect $10.", 10));

        // Trả tiền cho ngân hàng
        cards.add(new BankMoneyCard("Pay hospital fees of $100.", -100));

        //Thuế
        cards.add(new TaxCard("Pay your taxes of $75.", 75));

        // Học phí
        cards.add(new SchoolFeeCard("School fees due. Pay $50.", 50));

        //Thu/ Trả tiền cho những người chơi khác
        cards.add(new CollectFromPlayersCard("It is your birthday! Collect $10 from each player.", 10));
        cards.add(new PayToPlayersCard("You are assessed for street repairs. Pay each player $40", 40));

        //Vé ra tù
        cards.add(new CommunityJailFreeCard("Get Out of Jail Free!!!"));

        //vé máy bay
        cards.add(new CommunityAirplaneCard("Take a flight to any tile on the board!"));

        return new CardDeck(cards);
    }
}
