package snap;

import card.Card;
import deck.Deck;

import java.util.ArrayList;
import java.util.List;

public class SnapGame {

    private Deck deck;
    private List<Card> pile;

//    Constructor to initialise game
    public SnapGame() {
        deck = new Deck();
        pile = new ArrayList<>();
    }

// deal card from the deck
    public Card dealCard() {
        Card card = deck.dealCard();
        if (card != null) {
            pile.add(card);
        }
        return card;
    }

//    check if there is a snap
    public boolean isSnap() {
        if (pile.size() < 2) {
            return false; // f
        }
        Card topCard = pile.get(pile.size() - 1);
        Card secondCard = pile.get(pile.size() - 2);
        return topCard.getSymbol().equals(secondCard.getSymbol());
    }

//    check if the game is over (deck is empty
    public boolean isGameOver() {
        return deck.isEmpty();
    }

}
