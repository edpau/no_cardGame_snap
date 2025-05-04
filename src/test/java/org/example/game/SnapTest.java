package org.example.game;

import org.example.card.Card;
import org.example.card.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnapTest {
    private Snap snapGame;

    @BeforeEach
    void setUp() {
        snapGame = new Snap();
    }

    @Test
    void isSymbolMatch_twoCardsHaveSameSymbol_returnTrue() {
        Card card1 = new Card(Suit.Diamond, "2", 2);
        Card card2 = new Card(Suit.Spade, "2", 2);

        assertTrue(snapGame.isSymbolMatch(card1, card2));
    }

    @Test
    void isSymbolMatch_twoCardsHaveDifferentSymbol_returnFalse() {
        Card card1 = new Card(Suit.Diamond, "2", 2);
        Card card2 = new Card(Suit.Spade, "3", 3);
        assertFalse(snapGame.isSymbolMatch(card1, card2));
    }

    @Test
    void switchPlayer_playerOneIsCurrentPlayer_switchPlayerTwoToCurrentPlayer() {
        assertEquals(0, snapGame.getCurrentPlayerIndex());
        snapGame.switchPlayer();
        assertEquals(1, snapGame.getCurrentPlayerIndex());
    }

    @Test
    void switchPlayer_cycleThroughPlayers_returnsToPlayerOne() {
        // test multiplayer in the future
        assertEquals(0, snapGame.getCurrentPlayerIndex());
        for(int i=0; i<snapGame.getPlayerList().size(); i++){
            snapGame.switchPlayer();
        }
        assertEquals(0, snapGame.getCurrentPlayerIndex());
    }


}