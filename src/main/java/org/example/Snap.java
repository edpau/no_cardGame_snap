package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Snap extends CardGame {
    private static final Scanner scanner = new Scanner(System.in);

    private Card previousCard;
    private Card currentCard;


    public Snap() {
        super("Snap");
    }


    public static void promptEnterKey() {
        while (true) {
            System.out.println("Press \"ENTER\" to continue...");
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

    public void createNewGame() {
        shuffleDeck();
        this.previousCard = dealCard();
        System.out.println("Previous Card is " + this.previousCard);
    }

    public boolean isSymbolMatch(Card previousCard, Card currentCard) {
        return previousCard.getSymbol().equals(currentCard.getSymbol());
    }

    public void playGameLoop() {
        while(true){
            promptEnterKey();
            this.currentCard = dealCard();
            System.out.println("New Card is " + this.currentCard);
            if(isSymbolMatch(this.getPreviousCard(), this.getCurrentCard())){
                System.out.println("You win");
                break;
            } else if(this.getDeck().isEmpty()){
                System.out.println("You loss");
                break;
            } else {
                this.previousCard = this.currentCard;
                System.out.println("You didn't win");
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
