package user;

import WarGame.WarGame;
import snap.SnapGame;

import java.util.Scanner;

public class UserInteraction {

    private Scanner scanner;

    public UserInteraction() {
        this.scanner = new Scanner(System.in);
    }
//    choose game message
        public void chooseGameMessage () {
            boolean start = true;

            while (start) {
                System.out.println("Press 1 for War Game or 2 for Snap");
                System.out.println("Type a number:");
                String inputString = scanner.nextLine();

                while (!inputString.matches("^[1-2]$")) {
                    System.out.println("Only enter either 1 or 2");
                    inputString = scanner.nextLine();
                }

                long input = Long.parseLong(inputString);

//            switch cases
                switch ((int) input) {
                    case 1:
                        new WarGame ("War Game");
                        start = false;
                        break;
                    case 2:
                        SnapGame SnapGame = new SnapGame();
                        start = false;
                        break;
                    default:
                        System.out.println("Please enter a valid number");
                        break;
                }
            }
            scanner.close();
        }

        public static void main (String[]args){
            UserCreation userCreation = new UserCreation();
            userCreation.createUser();
            String userName = userCreation.getUserName();

            UserInteraction userInteraction = new UserInteraction();
            userInteraction.chooseGameMessage();
        }
    }

