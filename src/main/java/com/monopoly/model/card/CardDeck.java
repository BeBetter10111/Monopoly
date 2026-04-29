package com.monopoly.model.card;

import com.monopoly.model.card.Card;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections; // Dùng để lấy method shuffle ( trộn )
import java.util.Deque; // Dùng để duyệt 2 chiều
import java.util.List;

public class CardDeck {
    private Deque<ICard> cards; // Bộ bài đang dùng
    private List<ICard> allCards; // Lưu lại nguyên bộ bài gốc để dùng refill

    public CardDeck(List<ICard> cards){
        this.allCards = new ArrayList<>(cards); // Sao chép List gốc vào
        this.cards = new ArrayDeque<>(cards); // Tạo Deque dựa trên cái List đươc đưa vào

    }
    public ICard draw(){ // Rút bài
        if(cards.isEmpty()){
            refill(); // Hết bài thì xào lại
        }
        return cards.poll(); // Bốc lá đầu rồi xóa lá đó
    }

    /*
    Lưu ý phải đổi Deque -> List để có thể dùng được shuffle vì Collections.shuffle chỉ hoạt động trực tiếp với List mà thôi
     */
    public void shuffle(){ // Xào bài
        List<ICard> list = new ArrayList<>(cards);
        Collections.shuffle(list); // Xáo randomly
        cards = new ArrayDeque<>(list); // Đổi lại thành Deque
    }

    public void refill(){
        cards = new ArrayDeque<>(allCards); //Copy bài gốc vào lại
        shuffle();
    }

    public int size(){
        return cards.size();
    }
}
