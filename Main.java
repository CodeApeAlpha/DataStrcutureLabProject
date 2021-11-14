package DATASTRUCTURELAB_PROJECT;

import DATASTRUCTURELAB_PROJECT.GamePlay.GamePlay;
import DATASTRUCTURELAB_PROJECT.WHEEL.Wheel;


public class Main {

    public static void main(String[] args) {
//      Creates Wheel methods
        Wheel wheel= new Wheel();
//      Creates game interaction
        GamePlay gamePlay=new GamePlay();

//      Set number of rounds
        for(int numberOfrounds=0;numberOfrounds<3;numberOfrounds++){

//          Triggers new phrase
            gamePlay.newRound();

//          Triggers letter guesser
            int numberOfOccurrence=gamePlay.letterGuesser();

//          Validates and display player option
            while (numberOfOccurrence!=-0 && !gamePlay.phraseGuesser(gamePlay.getUnfinishedGuess().toString())){
                String option= gamePlay.userOption();
                if(option.equals("0")){
//              Spin wheel
                    System.out.println("Spin Wheel"+wheel.spin());
                }else if(option.equals("1")) {
//                  Buy a vowel
                    gamePlay.buyVowel();
                }else {
                    System.out.println(gamePlay.getUnfinishedGuess());
                    numberOfOccurrence=gamePlay.letterGuesser();
                }
            }
            if(gamePlay.phraseGuesser(gamePlay.getUnfinishedGuess().toString())){
                System.out.println("\nPlayer won turn");

            }else {
                System.out.println("\nPlayer loses turn");
            }
    }
    }
}


