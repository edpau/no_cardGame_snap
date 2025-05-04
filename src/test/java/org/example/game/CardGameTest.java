package org.example.game;

import org.example.Card;
import org.example.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CardGameTest {
    private static final String GAME_NAME = "Game";

    private CardGame cardGame;

    @BeforeEach
    void setUp() {
        cardGame = buildAnonymousCardGame();
    }

    // ===== @Test methods =====
    @Test
    void getDeck_WhenCalledAfterConstruction_Return52cards() {
        assertEquals(52, cardGame.getDeck().size());
    }

    @Test
    void dealCard_whenDeckHasCard_shouldReturnACard() {
        Card card = cardGame.dealCard();
        assertNotNull(card, "Dealt card should not be null when deck has cards");
        assertInstanceOf(Card.class, card);
    }

    @Test
    void dealCard_whenDeckHasCard_shouldReduceDeckSizeByOne() {
        int initialNumberOfCards = cardGame.getDeck().size();
        cardGame.dealCard();
        assertEquals(initialNumberOfCards - 1, cardGame.getDeck().size());
    }

    @Test
    void dealCard_whenDeckIsEmpty_ThrowsIllegalStateException() {
        cardGame.getDeck().clear();
        assertThrows(IllegalStateException.class, () -> cardGame.dealCard());
    }

    @Test
    void sortDeckInNumberOrder_whenDeckIsUnsortedAndFull_shouldSortCorrectly() {
        List<Card> deck = cardGame.getDeck();
        setupDeckInWrongOrder(deck);
        cardGame.sortDeckInNumberOrder();

        // Check all "2" cards are in order
        assertSameCard(Suit.Diamond, "2", 2, deck, 0);
        assertSameCard(Suit.Club, "2", 2, deck, 1);
        assertSameCard(Suit.Heart, "2", 2, deck, 2);
        assertSameCard(Suit.Spade, "2", 2, deck, 3);
        // Check all "6" cards are in order
        assertSameCard(Suit.Diamond, "6", 6, deck, 4);
        assertSameCard(Suit.Club, "6", 6, deck, 5);
        assertSameCard(Suit.Heart, "6", 6, deck, 6);
        assertSameCard(Suit.Spade, "6", 6, deck, 7);
    }

    @Test
    void sortDeckInNumberOrder_whenDeckIsEmpty_ThrowsIllegalStateException() {
        cardGame.getDeck().clear();
        assertThrows(IllegalStateException.class, () ->
                cardGame.sortDeckInNumberOrder()
        );
    }

    @Test
    void sortDeckIntoSuits_whenDeckIsUnsortedAndFull_shouldSortCorrectly() {
        List<Card> deck = cardGame.getDeck();
        setupDeckInWrongOrder(deck);
        cardGame.sortDeckIntoSuits();

        assertSameCard(Suit.Spade, "2", 2, deck, 0);
        assertSameCard(Suit.Spade, "6", 6, deck, 1);

        assertSameCard(Suit.Heart, "2", 2, deck, 2);
        assertSameCard(Suit.Heart, "6", 6, deck, 3);

        assertSameCard(Suit.Club, "2", 2, deck, 4);
        assertSameCard(Suit.Club, "6", 6, deck, 5);

        assertSameCard(Suit.Diamond, "2", 2, deck, 6);
        assertSameCard(Suit.Diamond, "6", 6, deck, 7);
    }

    @Test
    void sortDeckIntoSuits_whenDeckIsEmpty_ThrowsIllegalStateException() {
        cardGame.getDeck().clear();
        assertThrows(IllegalStateException.class, () ->
                cardGame.sortDeckIntoSuits()
        );
    }


    // ====== Helper methods ======
    void setupDeckInWrongOrder(List<Card> deck) {
        deck.clear();
        deck.add(new Card(Suit.Heart, "6", 6));
        deck.add(new Card(Suit.Spade, "2", 2));
        deck.add(new Card(Suit.Club, "2", 2));
        deck.add(new Card(Suit.Diamond, "6", 6));
        deck.add(new Card(Suit.Club, "6", 6));
        deck.add(new Card(Suit.Diamond, "2", 2));
        deck.add(new Card(Suit.Heart, "2", 2));
        deck.add(new Card(Suit.Spade, "6", 6));
    }

    void assertSameCard(Suit suit, String symbol, int value, List<Card> deck, int deckCardIndex) {
        Card card = new Card(suit, symbol, value);
        Card deckCard = deck.get(deckCardIndex);
        assertEquals(card.getSuit(), deckCard.getSuit());
        assertEquals(card.getValue(), deckCard.getValue());
        assertEquals(card.getSymbol(), deckCard.getSymbol());
    }

private CardGame buildAnonymousCardGame() {
        return new CardGame(CardGameTest.GAME_NAME){};
}

}
