package WarGame;

import card.Card;
import deck.Deck;
import WarGame.Player.Player;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class WarGame {
    private final Player player;
    private final Player computer;
    private final Deck deck;
    private final Scanner scanner;

    public WarGame(String playerName) {
        player = new Player(playerName);
        computer = new Player("Computer");
        deck = new Deck();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        deck.shuffleDeck();
        dealCards();
        playRounds();
        declareWinner();
    }

    private void dealCards() {
        while (!deck.getDeckOfCards().isEmpty()) {
            player.addCardToHand(deck.dealCard());
            computer.addCardToHand(deck.dealCard());
        }
    }

    private void playRounds() {
        while (player.hasCards() && computer.hasCards()) {
            Card playerCard = getPlayerCard();
            Card computerCard = computer.drawCard();

            System.out.println(player.getName() + " plays " + playerCard);
            if (computerCard != null) {
                System.out.println(computer.getName() + " plays " + computerCard);
            } else {
                System.out.println(computer.getName() + " has no cards left.");
                break; // End the game if the computer has no cards left
            }

            if (playerCard.getValue() > computerCard.getValue()) {
                player.addCardToHand(playerCard);
                player.addCardToHand(computerCard);
                player.incrementScore(); // Increment player's score
                System.out.println(player.getName() + " wins the round.");
            } else if (playerCard.getValue() < computerCard.getValue()) {
                computer.addCardToHand(playerCard);
                computer.addCardToHand(computerCard);
                computer.incrementScore(); // Increment computer's score
                System.out.println(computer.getName() + " wins the round.");
            } else {
                // War condition
                System.out.println("War!");
                if (player.hasCards() && computer.hasCards()) {
                    // Each player puts three cards face down and one card face up
                    Card[] warCardsPlayer = drawWarCards(player);
                    Card[] warCardsComputer = drawWarCards(computer);

                    System.out.println(player.getName() + " random cards will be put down for the players to pick a winner for this round");


                    Card warCardPlayer = warCardsPlayer[warCardsPlayer.length - 1];
                    Card warCardComputer = warCardsComputer[warCardsComputer.length - 1];

                    System.out.println(player.getName() + " plays " + warCardPlayer);
                    System.out.println(computer.getName() + " plays " + warCardComputer);

                    if (warCardPlayer.getValue() > warCardComputer.getValue()) {
                        for (Card card : warCardsPlayer) {
                            player.addCardToHand(card);
                        }
                        for (Card card : warCardsComputer) {
                            player.addCardToHand(card);
                        }
                        player.incrementScore(); // Increment player's score for war round
                        System.out.println(player.getName() + " wins the war round.");
                    } else if (warCardPlayer.getValue() < warCardComputer.getValue()) {
                        for (Card card : warCardsPlayer) {
                            computer.addCardToHand(card);
                        }
                        for (Card card : warCardsComputer) {
                            computer.addCardToHand(card);
                        }
                        computer.incrementScore(); // Increment computer's score for war round
                        System.out.println(computer.getName() + " wins the war round.");
                    } else {
                        // If another tie occurs, continue the war
                        for (Card card : warCardsPlayer) {
                            player.addCardToHand(card);
                        }
                        for (Card card : warCardsComputer) {
                            player.addCardToHand(card);
                        }
                        System.out.println("Another war round will start.");
                    }
                }
            }

            // Display current scores
            displayScores();
        }
    }


    private Card getPlayerCard() {
        while (true) {
            System.out.println("Your hand:");
            for (int i = 0; i < player.getHand().size(); i++) {
                System.out.print((i + 1) + ": " + player.getHand().get(i) + "  ");
            }
            System.out.println("\nEnter the number of the card you want to play:");

            try {
                int choice = scanner.nextInt();
                if (choice < 1 || choice > player.getHand().size()) {
                    System.out.println("Invalid choice. Please try again.");
                } else {
                    return player.getHand().remove(choice - 1);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();  // Clear the invalid input
            }
        }
    }










    private Card[] drawWarCards(Player player) {
        Card[] cards = new Card[4];
        for (int i = 0; i < 4; i++) {
            if (player.hasCards()) {
                cards[i] = player.drawCard();
            } else {
                break;
            }
        }
        return cards;
    }

    private void declareWinner() {
        if (player.hasCards() && !computer.hasCards()) {
            System.out.println(player.getName() + " wins the game!");
        } else if (computer.hasCards() && !player.hasCards()) {
            System.out.println(computer.getName() + " wins the game!");
        } else {
            System.out.println("The game is a tie!");
        }

        // Display final scores
        displayScores();
    }

    private void displayScores() {
        System.out.println("Current Scores:");
        System.out.println(player.getName() + ": " + player.getScore());
        System.out.println(computer.getName() + ": " + computer.getScore());
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String playerName = scanner.nextLine();

        WarGame warGame = new WarGame(playerName);
        warGame.startGame();
    }
}









