package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardGameTest {
    private CardGame cardGame;

    @BeforeEach
    void setUp(){
        cardGame = new CardGame("Snap");
    }

    // methodName_StateUnderTest_ExpectedBehaviour
    @Test
    void getDeck_WhenCalledAfterConstruction_Return52cards(){
        assertEquals(52, cardGame.getDeck().size());
    }

}
