package deck;

import card.Card;
import java.util.ArrayList;
import java.util.List;

public class Deck {
    int[] numberCards = new int[52];
    private List<Card> deckOfCards;

    // Constructor to initialise deck with 52 cards
    public Deck() {
        deckOfCards = new ArrayList<>();
        initialiseDeck();
    }

    //    Method to initialise the deck with 52 cards
    private void initialiseDeck() {
        //initialise the cards
        for (String suit : Card.SUITS) {
            for (int i = 0; i < Card.SYMBOLS.length; i++) {
                deckOfCards.add(new Card(suit, Card.SYMBOLS[i], Card.INT_VALUES[i]));
            }
        }
    }

    //method dealCards() - remove and return the first card from the deck
    public Card dealCard() {

        if (!deckOfCards.isEmpty()) {
            return  deckOfCards.remove(0);
        } else {
            System.out.println("No cards left in the deck");
            return null;
        }
//        deckOfCards.forEach((card) -> {
//            return deckOfCards[i];
//        });
    }
}
