package design.deckCards;

import java.util.ArrayList;

public class Hand<T extends Card> {

    protected ArrayList<T> cards = new ArrayList<T>();

    public int score() {
        int score = 0;
        for (T cards : cards) {
            score += cards.value();
        }
        return score;
    }

    public void addCards(T card) {
        cards.add(card);
    }

}
