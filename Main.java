package DATASTRUCTURELAB_PROJECT;

import DATASTRUCTURELAB_PROJECT.CircularLinkedListWheel.Card;
import DATASTRUCTURELAB_PROJECT.Contestant.Player;
import DATASTRUCTURELAB_PROJECT.GamePlay.GamePlay;
import DATASTRUCTURELAB_PROJECT.Queue.String.GuessesQueue;
import DATASTRUCTURELAB_PROJECT.Queue.Player.Queue;
import DATASTRUCTURELAB_PROJECT.WHEEL.Wheel;


import java.util.Scanner;


public class Main {

//  Queue
    private Queue playerQueueTemp =new Queue();
    private Queue playerQueue=new Queue();
    private GuessesQueue collectedPhraseLetter=new GuessesQueue();

//  Wheel
    private  Wheel wheel= new Wheel();

//  Player
    private Player players=new Player();

//  Gameplay
    private  GamePlay gamePlay=new GamePlay();

//  Card
    private Card wheelSpinOutcome;

//  Collect Set And Validate Player Data
    public void PlayerDataFunction(){
        while (true){
            System.out.println("Enter number of player");
            String numberOfPlayers= new Scanner(System.in).next();
            if(numberOfPlayers.matches("[0-9]")){
                int numPlayers=Integer.parseInt(numberOfPlayers);
                for (int playerCount=0;playerCount<numPlayers;playerCount++){
                    System.out.println("Enter player name");
                    String playerName= new Scanner(System.in).next();
                    Player newPlayer=new Player(playerCount,playerName);
                    this.playerQueue.Enqueue(newPlayer);
                }
                return;
            }
            else{
                System.out.println("Invalid Number");
            }
        }


    }

//  Spin Wheel
    public boolean wheelSpinValidation(Player playerData){
        wheelSpinOutcome=wheel.spin();
        if(playerData.getPlayerName()!=null){
            System.out.println("\nPlayer ID "+ playerData.getPlayerNumber()+" Name "+playerData.getPlayerName());
            System.out.println("Wheel Spun Type: "+wheelSpinOutcome.getTypeOfCard()+"\t Value: "+wheelSpinOutcome.getValueOfCard());
//          Turn validation
            if(wheelSpinOutcome.getTypeOfCard().equalsIgnoreCase("bankrupt")){
                System.out.println("Player Loses Turn ---> No points will be rewarded");
                return false;
            }
            else if (wheelSpinOutcome.getTypeOfCard().equalsIgnoreCase("loseturn")){
                System.out.println("Player Loses Turn ---> Player will receive points ");
                return false;
            }else{
                return true;
            }
        }
        else{
            System.out.println("End Of Player Queue");
        }
        return false;

    }

//  Display User
    public boolean moreOptions(Player playerData){

//  User Option
//  Spin:0	Buy-Vowel:1
//  Solve:2	Guess-Letter:3
        String option= gamePlay.userOption();
        boolean continued=false;
        if(option.equals("0")){
            continued=wheelSpinValidation(playerData);
            if(!continued){
                return false;
            }
        }else if(option.equals("1")){
            gamePlay.buyVowel();

        }else if(option.equals("2")){
//            Solve phrase
            System.out.println("Enter your phrase");
            String guessedPhrase =new Scanner(System.in).next();
//          Validates
            if(gamePlay.getSecretPhrase().equalsIgnoreCase(guessedPhrase)){
                StringBuilder guessedPh=new StringBuilder();
                guessedPh.append(guessedPhrase);
                gamePlay.setUnfinishedGuess(guessedPh);
                return true;
            }else{
                return false;
            }

        }else if(option.equals("3")){
            return solvePuzzle(playerData);
        }
        return true;
    }

//  Solve Puzzle
    public boolean solvePuzzle(Player playerSolving){
        int roundTotal=0;
        boolean firstSpin=true;
//      Collect Player Guesses
        int numberOfOccurrence=gamePlay.letterGuesser();
//      Queues Collected Guesses
//        if(collectedPhraseLetter.validate(gamePlay.getUserGuesses())){
            collectedPhraseLetter.Enqueue(gamePlay.getUserGuesses());
//        }else {
//            System.out.println("\n\n\nPlayer "+playerSolving.getPlayerName()+ " lost turn");
//            collectedPhraseLetter.Display();
//            return false;
//        }
//      Display Members of Queue
        collectedPhraseLetter.Display();
        while (numberOfOccurrence!=0){
            if(firstSpin){
                System.out.println("\nMoney on the board: Wheel Card Value:"+wheelSpinOutcome.getValueOfCard()+" * "+"NumberOfOccurrence:"+ numberOfOccurrence+" = "+ (roundTotal+=wheelSpinOutcome.getValueOfCard()*numberOfOccurrence));
                playerSolving.setPlayerGrandTotal(roundTotal+=playerSolving.getPlayerGrandTotal());
                System.out.println("Player "+playerSolving.getPlayerName() + " GrandTotal = GrandTotal+RoundTotal "+playerSolving.getPlayerGrandTotal());
            }
            if(!moreOptions(playerSolving)){
                return false;
            }
            
            numberOfOccurrence=gamePlay.letterGuesser();
            collectedPhraseLetter.Enqueue(gamePlay.getUserGuesses());
            collectedPhraseLetter.Display();

            if(gamePlay.phraseGuesser(gamePlay.getUnfinishedGuess().toString())){
                System.out.println("\n\nPlayer Won Their Turn");
//              Rest List
                collectedPhraseLetter=new GuessesQueue();
                return true ;
            }
            firstSpin=false;
        }
        System.out.println("\n\n\nPlayer "+playerSolving.getPlayerName()+ " lost turn");
        return false;

    }

//  Display Winner
    public void roundWinner(){
        System.out.println("\nList Of Player Results");
        int max=0;
        Player roundWinner=null;
//      Depose payer from List
        Player player= playerQueueTemp.Dequeue();
        while(player.getPlayerName()!=null){
            System.out.println("\tPlayer Data: "+player.getPlayerNumber()+" "+player.getPlayerName()+" "+player.getPlayerGrandTotal());
            if(player.getPlayerGrandTotal()>max && player.getPlayerGrandTotal()!=0){
                roundWinner=player;
                max= player.getPlayerGrandTotal();
            }
            player= playerQueueTemp.Dequeue();
        }
        if(roundWinner!=null){
            System.out.println("Winner Player Data: ID "+roundWinner.getPlayerNumber()+" Name "+roundWinner.getPlayerName()+" Points "+roundWinner.getPlayerGrandTotal());
        }else {
            System.out.println("No Winner Was Determined");
        }
    }

    public static void main(String[] args) {
        Boolean findWinner=false;
        int rounds=0;
        Main main=new Main();
//      Collect Player Data
        main.PlayerDataFunction();
//      Depose Player From Queue
        Player playerToSolve= main.playerQueue.Dequeue();
//      Load New File Data For Players
        main.gamePlay.newRound();
//      Act As A 3 Round Loop
        while (rounds!=3){

            if(rounds!=3){
                System.out.println("\n\n\n\n\n\n\n\n----------------------------------------New Round---------------------------------------------");
                System.out.println("\n----------------------------------------Round--->"+(rounds+1));
            }
//          Acts A Loop For Player Each Player
            while (playerToSolve.getPlayerName()!=null){
//              Validate Spin From Wheel
                if(main.wheelSpinValidation(playerToSolve)){
//                  Act A Player Main Screen
                    System.out.println("\n-------------------------New Phrase Loaded-----------------------");
                    System.out.println("-------------------------Categories-----------------------");
                    System.out.println("-------------------------"+main.gamePlay.getCategory());
//                  Player At
                    findWinner=main.solvePuzzle(playerToSolve);
                }
//              Add Player In New Queue
                main.playerQueueTemp.Enqueue(playerToSolve);
//              Depose Player From Queue
                playerToSolve=main.playerQueue.Dequeue();
            }
            main.collectedPhraseLetter=new GuessesQueue();
//          Player reload To Queue For Loop
            main.playerQueue= new Queue(main.playerQueueTemp);
//          Find Determine Round Winner
            if (!findWinner){
                main.roundWinner();
            }
            rounds++;
            if(rounds==3){
                String playGame;
                System.out.println("Enter Y/N to play again: ");
                playGame = new Scanner(System.in).next();
                if(playGame.equalsIgnoreCase("y"))
                {
                    rounds=0;
                    playerToSolve=main.playerQueue.Dequeue();
                    main.gamePlay.newRound();
                }
                main.playerQueueTemp=new Queue(main.getPlayerQueue());
            }else{
                playerToSolve=main.playerQueue.Dequeue();
                main.gamePlay.newRound();
            }

        }
        System.out.println("\n\n\n\n\n\n\n\n----------------------------------------Overall Round Winner---------------------------------------------");
        main.roundWinner();
    }


    public Queue getPlayerQueueTemp() {
        return playerQueueTemp;
    }

    public Player getRoundPlayer() {
        return players;
    }

    public Queue getPlayerQueue() {
        return playerQueue;
    }
}


