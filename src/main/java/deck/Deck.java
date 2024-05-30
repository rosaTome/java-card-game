package deck;

import card.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import card.CardSorting;

public class Deck {
    int[] numberCards = new int[52];
    private final List<Card> deckOfCards;

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

    // Method dealCards - remove and return the first card from the deck
    public Card dealCard() {

        if (!deckOfCards.isEmpty()) {
            return deckOfCards.remove(0);
        } else {
            System.out.println("No cards left in the deck");
            return null;
        }
    }

    //    Method sortDeck - sorts the deck in numbers order
    public void sortDeck() {
        Collections.sort(deckOfCards, (c1, c2) -> Integer.compare(c1.getValue(), c2.getValue()));
    }

    //Method sortDeck(Comparator comparator)
    public void sortDeckComparator(CardSorting cardSorting) {
        Comparator<Card> comparator = null;
        switch (cardSorting) {
            case byValue:
                comparator = Comparator.comparing(Card::getValue);
                break;
            case bySuit:
                comparator = Comparator.comparing(Card::getSuit);
                break;
            case bySymbol:
                comparator = Comparator.comparing(Card::getSymbol);
                break;

        }
        Collections.sort(deckOfCards, comparator);
        for (Card card : deckOfCards) {
            System.out.println(card);
        }

    }

    //Method to shuffle the deck
    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }

    //Method to reset the deck
    public void resetDeck() {
        deckOfCards.clear();
        initialiseDeck();
    }
    
    //method to print each card in the deck
    public void printDeck() {
        for (Card card : deckOfCards) {
            System.out.println(card);
        }
    }

//    method for deck of cards size
    public int size() {
        return deckOfCards.size();
    }

// method for empty deck of cards
    public boolean isEmpty() {
        return deckOfCards.isEmpty();
    }

    //    Main method for testing
    public static void main (String[] args) {
//        Create a new deck
        Deck deck = new Deck();


//////        Deal and print 1 card
//        System.out.println("dealCards - dealing 1 card:");
//        Card dealtCard = deck.dealCard();
//        if (dealtCard != null) {
//            System.out.println("Dealt Card: " + dealtCard);
//        } else {
//            System.out.println("No card was dealt.");
//        }
//        System.out.println("Remaining deck size: " + deck.deckOfCards.size());

        ////        Deal and print 5 cards
//        System.out.println("dealCards - dealing 5 cards:");
//        for (int i = 0; i < 5; i++) {
//            Card dealtCard = deck.dealCard();
//            if (dealtCard != null) {
//                System.out.println("Dealt Card " + (i + 1) + ": " + dealtCard);
//            } else {
//                System.out.println("No card was dealt.");
//            }
//        }
//        System.out.println("Remaining deck size: " + deck.deckOfCards.size());
//
////      Sort the deck and print the sorted deck
//        deck.sortDeck();
//        for (Card card : deck.deckOfCards){
//            System.out.println(card);
//        }

        // Sort the deck by value and suit
        //deck.sortDeck(CardSorting.byValue);
//        System.out.println("Sorted deck by value:");
//        for (Card card : deck.deckOfCards) {
//            System.out.println(card);
//        }
////        deck.sortDeck(CardSorting.bySuit);
//        System.out.println("Sorted deck by suit:");
//        for (Card card : deck.deckOfCards) {
//            System.out.println(card);
//        }
//
//        System.out.println("Sorted deck by symbol:");
//        for (Card card : deck.deckOfCards) {
//            System.out.println(card);
//        }

//       Shuffle cards
//       deck.shuffleDeck();
//        System.out.println("Shuffled deck:");
//        for (Card card : deck.deckOfCards) {
//            System.out.println(card);
//        }

//      Reset cards
//        deck.resetDeck();
//        System.out.println("Reset deck:");
//        for (Card card : deck.deckOfCards) {
//            System.out.println(card);
//        }
//        System.out.println("Remaining deck size post reset cards method: " + deck.deckOfCards.size());

//        Print each card in the deck
        System.out.println("Printed deck of cards:");
        deck.printDeck();
    }



}
