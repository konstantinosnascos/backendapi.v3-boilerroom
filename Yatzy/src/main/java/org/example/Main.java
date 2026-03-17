package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//Skräpkod /Test


        GameHandler gameHandler = new GameHandler(2);

        System.out.println(gameHandler);

        gameHandler.playRound();

        System.out.println(gameHandler);

        /*
        Player p = new Player("Arthur Dent");
        System.out.println("Player created with name: " + p.getName());

        Dice dice = new Dice();
        dice.roll();
        System.out.println(dice.getValue());
        dice.setLocked(true);
        dice.roll();
        System.out.println(dice.getValue());
*/
        boolean gameIsOn = true;
       // while (gameIsOn){
            // game.handler.setActivePlayer();
           // gameHanlder.playRound;
           // gamehHandler.showResult();

//        }


    }
}