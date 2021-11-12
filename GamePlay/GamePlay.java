package DATASTRUCTURELAB_PROJECT.GamePlay;

import DATASTRUCTURELAB_PROJECT.Contestant.Player;
import DATASTRUCTURELAB_PROJECT.WHEEL.Wheel;

import java.util.Scanner;

public class GamePlay {

    private FileReader fileReader=new FileReader();
    private String secretPhrase;
    private String category;

    private int numberOfOccurrence=0;
    private StringBuilder correctGuesses=new StringBuilder();
    private StringBuilder unfinishedGuess=new StringBuilder();
    private CWP cwp;

    private String randomSentence ="A Glass Of Bourbon";


    public void newRound(){
        CWP cwp=fileReader.getCWP();
        secretPhrase=cwp.getGuessPhrase().toLowerCase();
        category= cwp.getCategory();
    }

    public int letterGuesser(){
//      Collecting file Data

//      Validate userInput for guess

        StringBuilder guesses= new StringBuilder(userInputValidation());
        unfinishedGuess=new StringBuilder();
            for(char secretLetter:secretPhrase.toCharArray()){
//              Check if letter is within the phrase
                if(!guesses.toString().toLowerCase().contains(String.valueOf(secretLetter))){
//                  Print spaces
                    if(secretLetter==' '){
                        unfinishedGuess.append(secretLetter);
                        System.out.print(secretLetter);
                    }
//                  Print letters from correctGuesses
                    else if(correctGuesses.toString().contains(String.valueOf(secretLetter))){
                        unfinishedGuess.append(secretLetter);
                        System.out.print(secretLetter);
                    }
//                  Print * for wrong guess
                    else{
                        unfinishedGuess.append("*");
                        System.out.print('*');
                    }
                }
                else{
//                  Print letters found
                    unfinishedGuess.append(secretLetter);
                    System.out.print(secretLetter);
                    if(!correctGuesses.toString().contains(String.valueOf(secretLetter))){
//                      Adds new letters to collection of correct guess
                        guesses=correctGuesses.append(guesses);
                        numberOfOccurrence++;
                    }
                }
            }
        return numberOfOccurrence;
    }

    public Boolean phraseGuesser(String inputPhrase){
        if(secretPhrase.equalsIgnoreCase(inputPhrase)){
            return true;
        }
        return false;
    }

    private boolean userInputLetterValidation(String userInput){
        return userInput.matches("^[a-zA-Z]*$") && userInput.length() == 1;
    }

    private String userInputValidation(){
        String userInput;
        while(true){
            System.out.println("\nEnter your letter");
            userInput= new Scanner(System.in).next();
            if(userInputLetterValidation(userInput)){
                break;
            }
            System.out.println("Invalid Entry ");
        }
        return userInput;
    }


//  The contestant would still have his/her turn and he/she may
//  choose to spin again, buy a vowel, or solve the puzzle.
    public String userOption(){
        String userOption;
        while(true){
            System.out.println("\nUser Option\nSpin:0\tBuy-Vowel:1\tSolve:2");
            userOption=new Scanner(System.in).next();
            if(!userOptionInputNumberValidation(userOption)){
                System.out.println("Invalid option");
            }
            else {
                return userOption;
            }
        }
    }

    private boolean userOptionInputNumberValidation(String userOption){
        return userOption.matches("^[0-2]*$")&& userOption.length()==1;
    }

    public StringBuilder getUnfinishedGuess() {
        return unfinishedGuess;
    }

}
