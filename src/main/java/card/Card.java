package card;

public class Card {

//    Attributes
    private String suit;
    private String symbol;
    private int value;

//    Arrays for suits, symbols and values
    public static final String[] SUITS = {"\u2665", "\u2663", "\u2666", "\u2660"};
    public static final String[] SYMBOLS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public static final int[] INT_VALUES = { 2, 3, 4, 5, 6, 7, 8, 9 , 10, 11, 12, 13, 14 };

    // Constructor
    public Card (String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

//    Getters and setters

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

//    toString method for card clas description
    @Override
    public String toString() {
        return suit + symbol  + "(Value: " + value + ")";
    }

//    Main method for testing
    public static void main(String[] args) {
        Card card1 = new Card(SUITS[0], "A", 14); // Ace of hearts
        System.out.println(card1);
    }
}
