package org.example.game;

import org.example.Card;
import org.example.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class CardGame {
    public static final SymbolValue[] SYMBOLS_AND_VALUES = {
            new SymbolValue("2", 2), new SymbolValue("3", 3), new SymbolValue("4", 4),
            new SymbolValue("5", 5), new SymbolValue("6", 6), new SymbolValue("7", 7),
            new SymbolValue("8", 8), new SymbolValue("9", 9), new SymbolValue("10", 10),
            new SymbolValue("J", 11), new SymbolValue("Q", 12), new SymbolValue("K", 13),
            new SymbolValue("A", 14)};

    private static final Comparator<Card> CARD_VALUE_SUIT_COMPARATOR = Comparator.comparingInt(Card::getValue).thenComparing(Comparator.comparing(Card::getSuit).reversed());
    private static final Comparator<Card> CARD_SUIT_VALUE_COMPARATOR = Comparator.comparing(Card::getSuit).thenComparingInt(Card::getValue);

    private List<Card> deckOfCards = new ArrayList<>();

    public CardGame(String name) {
        this.deckOfCards = generateDeck();
    }

    public static List<Card> generateDeck() {
        List<Card> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (SymbolValue symbolAndValue : SYMBOLS_AND_VALUES) {
                deck.add(new Card(suit, symbolAndValue.symbol(), symbolAndValue.value()));
            }
        }
        return deck;
    }

    protected Card dealCard() {
        if (deckOfCards.isEmpty()) {
            throw new IllegalStateException("Deck is empty, cannot deal card");
        }
        return deckOfCards.remove(deckOfCards.size() - 1);
    }

    protected void sortDeckInNumberOrder() {
        if (deckOfCards.isEmpty()) {
            throw new IllegalStateException("Deck is empty, cannot sort");
        }
        deckOfCards.sort(CARD_VALUE_SUIT_COMPARATOR);
    }

    protected void sortDeckIntoSuits() {
        if (deckOfCards.isEmpty()) {
            throw new IllegalStateException("Deck is empty, cannot sort");
        }
        deckOfCards.sort(CARD_SUIT_VALUE_COMPARATOR);
    }

    protected void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }

    protected List<Card> getDeck() {
        return deckOfCards;
    }

    public record SymbolValue(String symbol, int value) {
    }
}
