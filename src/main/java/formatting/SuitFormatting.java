package formatting;

import card.Card;

import java.util.Scanner;

public class SuitFormatting {

    public void selectCard() {

        Scanner scanner = new Scanner(System.in);

//    Display available suits
        System.out.println("Select a suit: ");
        String [] SUITS_INITIALS = {"H", "C", "D","S"};
        for (int i = 0; i < Card.SUITS.length; i++) {
            System.out.println((SUITS_INITIALS[i]) + ":" + Card.SUITS[i]);
        }

//        Get suit choice from user
        String chosenSuit = null;
        while (chosenSuit == null) {
            System.out.println("Enter your suit choice: ");
            String suitInput = scanner.next().toUpperCase();
            switch (suitInput) {
                case "H":
                    chosenSuit = Card.SUITS[0];
                    break;
                case "C":
                    chosenSuit = Card.SUITS[1];
                    break;
                case "D":
                    chosenSuit = Card.SUITS[2];
                    break;
                case "S":
                    chosenSuit = Card.SUITS[3];
                    break;
                default:
                    System.out.println("Invalid suit choice. Please try again.");
                    
            }
        }

        //    Display available values
        System.out.println("Select a value: ");
        for (int i = 0; i < Card.SYMBOLS.length; i++) {
            System.out.println((i + 1) + ":" + Card.SYMBOLS[i]);
        }

        //        Get value choice from user
        int valueChoice = -1;
        while (valueChoice < 1 || valueChoice > Card.SYMBOLS.length) {
            System.out.println("Enter your value choice:");
            valueChoice = scanner.nextInt();
        }

      String chosenSymbol = Card.SYMBOLS[valueChoice - 1];
        int chosenValue = Card.INT_VALUES[valueChoice - 1];

        //    Create and return selected card
        Card selectedCard = new Card (chosenSuit, chosenSymbol, chosenValue);
        System.out.println("You have selected the following card: " + selectedCard);
    }

// Testing
        public static void main (String[]args){
            System.out.println("choose from the following suits:");
            SuitFormatting suitFormatting = new SuitFormatting();
            suitFormatting.selectCard();
        }


}



