//package snap;
//
//import card.Card;
//import deck.Deck;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class SnapGame {
//    private Deck currentPile;
//    private Deck snapPile;
//    private Card previousCard;
//    private int snapCount;
//
//    public SnapGame() {
//        currentPile = new Deck();
//        snapPile = new Deck();
//        snapCount = 0;
//    }
//    public void play() {
//        Scanner scanner = new Scanner(System.in);
//        Random random = new Random();
//
//        while (true) {
//            // Deal one card from the current pile randomly
//            Card currentCard = currentPile.dealCard(random.nextInt(currentPile.size()));
//            // Deal one card from the snap pile randomly
//            Card snapCard = snapPile.dealCard(random.nextInt(snapPile.size()));
//
//            // Ensure snap card and current card are different
//            while (snapCard.equals(currentCard)) {
//                snapCard = snapPile.dealCard(random.nextInt(snapPile.size()));
//            }
//
//            // Display the initial cards
//            System.out.println("Current card: " + currentCard);
//            System.out.println("Snap card: " + snapCard);
//
//            if (currentCard == null || snapCard == null) {
//                break;
//            }
//
//            if (previousCard != null && (previousCard.getSuit().equals(currentCard.getSuit()) ||
//                    previousCard.getSymbol().equals(currentCard.getSymbol()))) {
//                System.out.print("Enter 'snap': ");
//                String input = scanner.nextLine().trim();
//                if (input.equalsIgnoreCase("snap")) {
//                    if (snapCard.getSuit().equals(previousCard.getSuit()) || snapCard.getSymbol().equals(previousCard.getSymbol())) {
//                        snapCount++;
//                        System.out.println("Snap! Total snaps: " + snapCount);
//                    } else {
//                        System.out.println("Incorrect snap. Keep playing.");
//                    }
//                } else {
//                    System.out.println("Keep playing.");
//                }
//            }
//
//            // Deal the next cards for comparison
//            previousCard = currentCard;
//        }
//
//        scanner.close();
//    }
//
//    public static void main(String[] args) {
//        SnapGame game = new SnapGame();
//        game.play();
//    }
//}