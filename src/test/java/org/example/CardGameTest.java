package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardGameTest {
    private CardGame cardGame;

    @BeforeEach
    void setUp() {
        cardGame = new CardGame("Snap");
    }

    // methodName_StateUnderTest_ExpectedBehaviour
    // TODO get rid of the magic number 52?
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

}
