package snap;

import card.Card;

import java.util.Scanner;

public class SnapGameConsole {

    public static void main(String[] args) {
//        Create new snap game object
        SnapGame game = new SnapGame();
//        Create for user input
        Scanner scanner = new Scanner(System.in);
//        initialise game over
        boolean gameOver = false;

        System.out.println("Welcome to snap! Please ENTER to deal a card or type 'snap' to call snap");

//        Get user input
        while (!gameOver) {
            System.out.println("Your move: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("snap")) {
                if (game.isSnap()) {
                    System.out.println("Snap! You win!");
                    gameOver = true;
                } else {
                    System.out.println("No snap. Keep playing.");
                }
            } else if (input.isEmpty()) {
                Card card = game.dealCard();
                if (card != null) {
                    System.out.println("Dealt card: " + card);
                } else {
                    System.out.println("Deck is empty! Game over!");
                    gameOver = true;
                }
            } else {
                System.out.println("Invalid input. Press ENTER to deal a card or type 'snap' to call snap.");
            }
            if (game.isGameOver()) {
                System.out.println("Deck is empty! Game over");
                gameOver = true;
            }
        }
        scanner.close();
    }
}
