package snap;

import java.util.Scanner;

public class SnapGameConsole {

    public static void main(String[] args) {
//        Create new snapgame object
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

            if (input)
        }
    }
}
