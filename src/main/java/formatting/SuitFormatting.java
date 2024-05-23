package formatting;

import card.Card;

import java.util.Scanner;

public class SuitFormatting {

    public Card selectCard() {

        Scanner scanner = new Scanner(System.in);

//    Display available suits

        System.out.println("Select a suit: ");
        for (int i = 0; i < Card.SUITS.length; i++) {
            System.out.println((i + 1) + ":" + Card.SUITS[i]);
        }

//        Get suit choice from user
        int suitChoice = -1;
        while (suitChoice < 1 || suitChoice > Card.SUITS.length) {
            System.out.println("Enter your suit choice:");
            suitChoice = scanner.nextInt();
        }
        String chosenSuit = Card.SUITS[suitChoice - 1];

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
        return selectedCard;

    }


////    Get suit choice from user
//public String getCardChoice() {
//            System.out.println("Enter the chosen card");
//            String input = scanner.nextLine();
//            return input.toLowerCase();
//        }


        public static void main (String[]args){
            System.out.println("choose from the following suits:");
            SuitFormatting suitFormatting = new SuitFormatting();
            suitFormatting.selectCard();
//       for (Card card : deck.deckOfCards) {
//       System.out.println(card)

        }


}



