package WarGame.Player;

import card.Card;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Card> hand;
    private int score;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public Card drawCard() {
        return hand.remove(0);
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getScore() {
        return score; // Getter for score
    }

    public void incrementScore() {
        this.score++; // Increment score by 1
    }
}


