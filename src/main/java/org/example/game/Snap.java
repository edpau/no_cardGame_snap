package org.example.game;

import org.example.card.Card;
import org.example.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snap extends CardGame {
    private static final Scanner scanner = new Scanner(System.in);

    private final Player playerOne;
    private final Player playerTwo;
    private final List<Player> playerList;

    private int currentPlayerIndex = 0;
    private Card previousCard;
    private Card currentCard;

    public Snap() {
        super("Snap");

        // TODO make a function to create new player and list;
        this.playerOne = new Player("Player One");
        this.playerTwo = new Player("Player Two");
        playerList = new ArrayList<>(List.of(playerOne, playerTwo));

    }

    public static void promptEnterKey(Player currentPlayer) {
        while (true) {
            System.out.println(currentPlayer.getName() + ", your turn! Please press ENTER to draw");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
        }
    }

    public void playGameLoop() {
        while (true) {
            promptEnterKey(currentPlayer());
            this.currentCard = dealCard();
            System.out.println(currentPlayer().getName() + " draws:" + this.currentCard);
            if (isSymbolMatch(this.getPreviousCard(), this.getCurrentCard())) {
                handleSnapInput();
                break;
            } else if (this.getDeck().isEmpty()) {
                System.out.println("No card left, draw");
                break;
            } else {
                this.previousCard = this.currentCard;
                System.out.println("No match. Next player...");
                System.out.println("Cards remaining in the deck: " + this.getDeck().size());
                switchPlayer();
            }
            ;
        }
    }

    public void createNewGame() {
        shuffleDeck();
        this.previousCard = dealCard();
        System.out.println("Welcome to Snap!");
        System.out.println("Two players will take turns drawing cards");
        System.out.println("If the value of the new card matches the previous one, SNAP to win!");
        System.out.println("------------------------------------------");
        System.out.println("Starting card on the table: " + this.previousCard);
        System.out.println(currentPlayer().getName() + " will go first");
        System.out.println();
    }

    protected boolean isSymbolMatch(Card previousCard, Card currentCard) {
        return previousCard.getSymbol().equals(currentCard.getSymbol());
    }

    protected void switchPlayer() {
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % this.playerList.size();
    }

    protected Player currentPlayer() {
        return this.playerList.get(currentPlayerIndex);
    }

    protected void handleSnapInput() {
        String currentPlayer = currentPlayer().getName();
        System.out.println(currentPlayer + " : Match found! Type 'snap' within 2 seconds to win!");

        Thread snapThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("\nToo late! 2 seconds are up");
            } catch (InterruptedException e) {
                return;
            }

            System.out.println(currentPlayer + ", you missed your chance. You lose. Game End");
            System.exit(0);
        });

        snapThread.start();

        if (scanner.nextLine().equalsIgnoreCase("snap")) {
            System.out.println(currentPlayer + ", you win. Game End");
        } else {
            System.out.println(currentPlayer + ", incorrect input. You lose the game. Game End");
        }
        snapThread.interrupt();
    }

    protected Card getPreviousCard() {
        return previousCard;
    }

    protected Card getCurrentCard() {
        return currentCard;
    }

    protected int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    protected List<Player> getPlayerList() {
        return playerList;
    }

}
