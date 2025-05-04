package org.example.card;

public class Card {
    private Suit suit;
    private String symbol;
    private int value;

    public Suit getSuit() {
        return suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }


    public Card(Suit suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public String toString() {
        return (String.format("%s%s", suit.unicode, symbol));
    }

}
