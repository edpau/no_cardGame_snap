package org.example;

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
            System.out.println(currentPlayer.getName() + " please press \"ENTER\" to continue...");
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
            System.out.println("New Card is " + this.currentCard);
            if (isSymbolMatch(this.getPreviousCard(), this.getCurrentCard())) {
                handleSnapInput();
                break;
            } else if (this.getDeck().isEmpty()) {
                System.out.println("No card left, draw");
                break;
            } else {
                this.previousCard = this.currentCard;
                System.out.println(currentPlayer().getName() + ", didn't win");
                System.out.println("Card left in Deck " + this.getDeck().size());
                switchPlayer();
            }
            ;
        }
    }

    public void createNewGame() {
        shuffleDeck();
        this.previousCard = dealCard();
        System.out.println("Previous Card is " + this.previousCard);
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
        System.out.println(currentPlayer + " snap opportunity, you have 2 sec to type snap to win the game");

        Thread snapThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("\n2 second passed");
                } catch (InterruptedException e) {
                    return;
                }

                System.out.println(currentPlayer + " Time's up! You loss.");
                System.exit(0);
            }
        });

        snapThread.start();

        if (scanner.nextLine().equalsIgnoreCase("snap")) {
            System.out.println(currentPlayer + ", you win");
        } else {
            System.out.println(currentPlayer + ", wrong word, you loss");
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
