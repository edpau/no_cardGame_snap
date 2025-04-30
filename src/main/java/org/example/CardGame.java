package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CardGame {
    private String name;
    private List<Card> deckOfCards = new ArrayList<>();

    public record SymbolValue(String symbol, int value) {
    }

    public static final SymbolValue[] SYMBOLS_AND_VALUES = {
            new SymbolValue("2", 2), new SymbolValue("3", 3), new SymbolValue("4", 4),
            new SymbolValue("5", 5), new SymbolValue("6", 6), new SymbolValue("7", 7),
            new SymbolValue("8", 8), new SymbolValue("9", 9), new SymbolValue("10", 10),
            new SymbolValue("J", 11), new SymbolValue("Q", 12), new SymbolValue("K", 13),
            new SymbolValue("A", 14)};

    private static final Comparator<Card> CARD_VALUE_SUIT_COMPARATOR = Comparator.comparingInt(Card::getValue).thenComparing(Comparator.comparing(Card::getSuit).reversed());
    private static final Comparator<Card> CARD_SUIT_VALUE_COMPARATOR = Comparator.comparing(Card::getSuit).thenComparingInt(Card::getValue);


    //

    public static List<Card> generateDeck() {
        List<Card> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (SymbolValue symbolANdValue : SYMBOLS_AND_VALUES) {
                deck.add(new Card(suit, symbolANdValue.symbol(), symbolANdValue.value()));
            }
        }
        return deck;
    }

    public CardGame(String name) {
        this.name = name;
        this.deckOfCards = generateDeck();
    }

    public List<Card> getDeck() {
        return deckOfCards;
    }

    // TODO handle dealCard when the deck is empty, with exception
    public Card dealCard() {
        // check is the deck has card or not, if no card left, then draw the game, now only return null
        // get one card from the end of the array, it is cheaper to get it from the end
        // return it
        // ToDO change to throw exception
        if (deckOfCards.isEmpty()) {
            return null;
        }
        return deckOfCards.remove(deckOfCards.size() - 1);
    }


    // TODO handle when the deck is empty, with exception
    public void sortDeckInNumberOrder() {
        if (deckOfCards.isEmpty()) {
            return;
        }
        deckOfCards.sort(CARD_VALUE_SUIT_COMPARATOR);
    }

    public void sortDeckIntoSuits() {
        if (deckOfCards.isEmpty()) {
            return;
        }
        deckOfCards.sort(CARD_SUIT_VALUE_COMPARATOR);
    }

    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }
}
