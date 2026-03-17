package org.example;

import java.util.ArrayList;

public class GameHandler {
    private ArrayList<Player> players;
    private int nOPlayers;
    private final int NODICES = 6;
    private Dice diceSet[];
    private InputHandler inputHandler;

    public GameHandler(int nOPlayers) {
        this.nOPlayers = nOPlayers;
        this.inputHandler = new InputHandler();

        this.diceSet = new Dice[NODICES];
        for (int i = 0 ; i<NODICES ; i++ ){
            this.diceSet[i] = new Dice();
        }
        this.players = new ArrayList<Player>();
        initializePlayers();
    }

    private void initializePlayers() {
        for (int i = 0 ; i < nOPlayers; i++){
            String name = inputHandler.getAndValidateString("Name of player " +i);
            players.add(new Player(name));
        }
    }

    public void rollDices(){
        for (Dice  d : this.diceSet){
           d.roll();
        }
    }

    public void showDiceSet(){
        int i = 1;
        for (Dice d : this.diceSet){
            System.out.println(i+". " + d.getValue());
            i++;
        }
    }

    public void playRound() {
        for (Player player : players) {

            for (int i = 0; i < 3; i++) {
                System.out.println("Rolling dices");
                this.rollDices();
                this.showDiceSet();
                while (true) {
                    int pickedDice = inputHandler.getAndValidateInt("Give number of dice to keep. (End with 0) ");
                    if (pickedDice == 0) {
                        break;
                    }
                    if (pickedDice > 0 && pickedDice < 7) {
                        diceSet[pickedDice - 1].setLocked(true);
                    } else {
                        System.out.println("No a valid number (1-6) ");
                    }
                }
            }// i-loopen
            this.showDiceSet();
            int toScore = inputHandler.getAndValidateInt("To score (1-6): ");
            int sum = 0;
            for (Dice d : diceSet){
                if (d.getValue() == toScore){
                    sum = sum + d.getValue();
                }
                player.setScore(player.getScore() +sum);
            }
            unlockDiceSet();
                    } //Playerloopen
    }


    private void  unlockDiceSet(){
        for (Dice d : diceSet){
            d.setLocked(false);
        }
    }

    @Override
    public String toString(){
        String returnString ="";
        for (Player p :players) {
            returnString += p.getName() +" Score: "+ p.getScore() + "\n";
        }
        return returnString;
    }
}
