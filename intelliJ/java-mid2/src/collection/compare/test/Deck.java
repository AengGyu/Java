package collection.compare.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck(){
        initCard();
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }

    private void initCard() {
        for (int i = 1; i <= 13; i++) {
            cards.add(new Card(i, Suit.SPADE));
            cards.add(new Card(i, Suit.HEART));
            cards.add(new Card(i, Suit.DIAMOND));
            cards.add(new Card(i, Suit.CLUB));
        }
    }

    public Card drawCard(){
        return cards.removeFirst();
    }
}
