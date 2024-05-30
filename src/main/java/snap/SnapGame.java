package snap;

import card.Card;
import deck.Deck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnapGame {
    private Deck deck;
    private List<Card> previousCards;
    private int snapCount;

    public SnapGame() {
        deck = new Deck();
        deck.shuffleDeck();
        previousCards = new ArrayList<>();
        snapCount = 0;
    }

    public void play() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Snap!");
        System.out.println("Press ENTER to flip a card. Press SPACE to call Snap!");

        while (!deck.isEmpty()) {
            while (System.in.read() != '\n') {
            }

            Card currentCard = deck.dealCard();
            if (currentCard == null) {
                break;
            }

            System.out.println("You flipped: " + currentCard);

            boolean isSnap = false;
            for (Card previousCard : previousCards) {
                if (previousCard.getSuit().equals(currentCard.getSuit()) ||
                        previousCard.getSymbol().equals(currentCard.getSymbol())) {
                    isSnap = true;
                    break;
                }
            }

            if (isSnap) {
                long startTime = System.currentTimeMillis();
                boolean snapped = false;
                while (System.currentTimeMillis() - startTime < 2000) {
                    if (System.in.available() > 0) {
                        char snapInput = (char) System.in.read();
                        if (snapInput == ' ') {
                            snapCount++;
                            System.out.println("Snap! Total snaps: " + snapCount);
                            snapped = true;
                            break;
                        }
                    }
                }
                if (!snapped) {
                    System.out.println("Missed Snap. Keep playing.");
                }
            }
            previousCards.add(currentCard);
        }
//        scanner.close();
        System.out.println("No more cards left in the deck. Game over!");
        System.out.println("Total snaps: " + snapCount);
    }
    public static void main(String[] args) throws IOException {
        SnapGame game = new SnapGame();
        game.play();
    }
}