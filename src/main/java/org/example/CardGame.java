package org.example;

import java.util.ArrayList;
import java.util.List;

public class CardGame {
    private String name;
    private List<Card> deckOfCards = new ArrayList<>();

    public record SymbolValue(String symbol, int value) {
    }

    ;

    public CardGame(String name) {
        this.name = name;

        String[] suits = {"♠", "♥", "♣", "♦"};
        SymbolValue[] symbolsAndValues = {
                new SymbolValue("2", 2), new SymbolValue("3", 3), new SymbolValue("4", 4),
                new SymbolValue("5", 5), new SymbolValue("6", 6), new SymbolValue("7", 7),
                new SymbolValue("8", 8), new SymbolValue("9", 9), new SymbolValue("10", 10),
                new SymbolValue("J", 11), new SymbolValue("Q", 12), new SymbolValue("K", 13),
                new SymbolValue("A", 14)

        };

        for (String suit : suits) {
            for (SymbolValue symbolANdValue : symbolsAndValues) {
                deckOfCards.add(new Card(suit, symbolANdValue.symbol(), symbolANdValue.value()));
            }
        }

    }

    public List<Card> getDeck() {
        return deckOfCards;
    }

}
