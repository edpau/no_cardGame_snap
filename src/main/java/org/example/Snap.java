package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Snap extends CardGame {
    private static final Scanner scanner = new Scanner(System.in);
    private Player playerOne;
    private Player playerTwo;
    private int currentPlayerIndex = 0;
    private List<Player> playerList;

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

    public Card getPreviousCard() {
        return previousCard;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    protected int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    protected List<Player> getPlayerList() {
        return playerList;
    }

    public void createNewGame() {
        shuffleDeck();
        this.previousCard = dealCard();
        System.out.println("Previous Card is " + this.previousCard);
    }

    public boolean isSymbolMatch(Card previousCard, Card currentCard) {
        return previousCard.getSymbol().equals(currentCard.getSymbol());
    }

    protected void switchPlayer() {
        this.currentPlayerIndex = (this.currentPlayerIndex + 1 ) % this.playerList.size();
    }

    public void playGameLoop() {
        while(true){
            promptEnterKey(this.playerList.get(currentPlayerIndex));
            this.currentCard = dealCard();
            System.out.println("New Card is " + this.currentCard);
            if(isSymbolMatch(this.getPreviousCard(), this.getCurrentCard())){
                System.out.println(this.playerList.get(currentPlayerIndex).getName() + ", You win");
                break;
            } else if(this.getDeck().isEmpty()){
                System.out.println("Draw");
                break;
            } else {
                this.previousCard = this.currentCard;
                System.out.println(this.playerList.get(currentPlayerIndex).getName() + ", didn't win");
                System.out.println("Card left in Deck " + this.getDeck().size());
                switchPlayer();
            };
        }
    }


    // createNewGame(){}, start game, create the deck, shuffle the deck, return a card,


    // Stage 3

    // next turn
    // by pressing enter
    // deal a card

    // check win or not
    // state to hold previous card
    // check whether the current card and the previous card is the same or not

    // Stage 4
    // create a state to hold playingPlayer

    // next turn function take a user. update the playerInPlay in Snap
    // switch player

    // check win or not
    // print out which player win

}
