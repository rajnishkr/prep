package design.deckCards;

import java.util.ArrayList;

public class Deck<T extends Card> {

    private ArrayList<T> cards = new ArrayList<>();
    private int dealtIndex = 0;

    public Deck(ArrayList<T> cards) {
        this.cards = cards;
    }

    public void setCards(ArrayList<T> cards) {
        this.cards = cards;
    }

    public int getDealtIndex() {
        return dealtIndex;
    }

    public void suffleCards() {

    }

    public T dealCard() {
        T card = this.cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        dealtIndex++;
        return card;
    }

    public T[] dealhands(int numberOfHands) {
        //TODO get number of hand and add validations
        return null;
    }
}
