package org.example.game;

import org.example.card.Card;
import org.example.card.Suit;
import org.example.card.SymbolValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.example.card.SymbolValue.SYMBOLS_AND_VALUES;

public abstract class CardGame {

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
}
