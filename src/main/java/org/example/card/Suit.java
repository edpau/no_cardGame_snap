package org.example.card;

public enum Suit {
    Spade("♠"), Heart("♥"), Club("♣"), Diamond("♦");

    public final String unicode;

    private Suit(String unicode) {
        this.unicode = unicode;
    }
}
