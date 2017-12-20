package design.deckCards.blackJack;

import design.deckCards.Hand;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard> {

    public int score() {
        ArrayList<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    private ArrayList<Integer> possibleScores() {
        ArrayList<Integer> scores = new ArrayList<>();

        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < scores.size(); j++) {
                if (cards.get(i).value() == 1 || cards.get(i).value() == 11) {

                } else {
                    scores.set(j, scores.get(i) + cards.get(i).value());
                }
            }
        }
        return scores;
    }

    public boolean busted() {
        return score() > 21;
    }

    public boolean is21() {
        return score() == 21;
    }
}
