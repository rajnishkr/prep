package design.deckCards.blackJack;

import design.deckCards.Card;
import design.deckCards.Suit;

public class BlackJackCard extends Card {

    public BlackJackCard(int c, Suit s) {
        super(c, s);
    }

    @Override
    public int value() {
        if (isAce()) {
            return 1;
        } else if (faceValue >= 11 && faceValue <= 13) {
            return 10;
        } else {
            return faceValue;
        }
    }

    public int maxValue() {
        if (isAce()) return 11;
        else
            return value();
    }

    public boolean isFaceCard() {
        return faceValue >= 11 && faceValue <= 13;
    }

    private boolean isAce() {
        return faceValue == 1;
    }
}
