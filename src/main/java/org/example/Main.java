package org.example.card;

import org.example.game.Snap;

public class Main {
    public static void main(String[] args) {

        Snap game = new Snap();

        game.createNewGame();

        game.playGameLoop();


    }
}
