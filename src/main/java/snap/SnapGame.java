package snap;

import card.Card;
import deck.Deck;

import java.util.ArrayList;
import java.util.List;

public class SnapGame {

    private Deck deck;
    private List<Card> dealtPile;
    private List<Card> snapPile;
    private Card previousCard;

    //    Constructor to initialise game
    public SnapGame() {
        deck = new Deck();
        deck.shuffleDeck();
        dealtPile = new ArrayList<>();
        snapPile = new ArrayList<>();
        previousCard = null;
    }

// deal card from the deck
    public Card dealCard() {
        Card card = deck.dealCard();
        if (card != null) {
            dealtPile.add(card);
        }
        return card;
    }

//    check if there is a snap
    public boolean playRound() {
        if (isGameOver()) {
            System.out.println("No cards left in the deck. Game over!");
            return false; // f
        }

        Card currentCard = deck.dealCard();
        if (currentCard == null) {
            return false;
        }
        System.out.println("Current card: " + currentCard);
        snapPile.add(currentCard);

        if (previousCard != null) {
            dealtPile.add(previousCard);
        }
            previousCard = currentCard;
            return true;
        }

    public boolean isSnap() {
        if (previousCard == null || snapPile.size() < 2) {
            return false;
        }
        Card lastCard = snapPile.get(snapPile.size() - 1);
        Card secondLastCard = snapPile.get(snapPile.size() - 2);
        return lastCard.getSymbol().equals(secondLastCard.getSymbol());    }

    public boolean isGameOver() {
        return deck.dealCard() == null;
    }

    public List<Card> getDealtPile() {
        return dealtPile;
    }

    public List<Card> getSnapPile() {
        return snapPile;
    }
}
