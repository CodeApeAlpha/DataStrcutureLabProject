package DATASTRUCTURELAB_PROJECT;

import DATASTRUCTURELAB_PROJECT.CircularLinkedListWheel.Card;
import DATASTRUCTURELAB_PROJECT.Contestant.Player;
import DATASTRUCTURELAB_PROJECT.GamePlay.GamePlay;
import DATASTRUCTURELAB_PROJECT.Queue.Node;
import DATASTRUCTURELAB_PROJECT.Queue.Queue;
import DATASTRUCTURELAB_PROJECT.WHEEL.Wheel;


import java.util.Scanner;


public class Main {

    private Queue playerQueueTemp =new Queue();
    private Queue playerQueue=new Queue();

    private Queue winnerQueue=new Queue();




    private  Wheel wheel= new Wheel();
    private Player players=new Player();

    private  GamePlay gamePlay=new GamePlay();

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
        }else{
            System.out.println("End Of Player Queue");
        }
        return false;

    }

    public boolean solvePuzzle(Player playerSolving){
        int roundTotal=0;
        int numberOfOccurrence=gamePlay.letterGuesser();
        while (numberOfOccurrence!=0){
            System.out.println("\nMoney on the board: Wheel Card Value:"+wheelSpinOutcome.getValueOfCard()+" * "+"NumberOfOccurrence:"+ numberOfOccurrence+" = "+ (roundTotal+=wheelSpinOutcome.getValueOfCard()*numberOfOccurrence));
            playerSolving.setPlayerGrandTotal(roundTotal+=playerSolving.getPlayerGrandTotal());
            System.out.println("Player "+playerSolving.getPlayerName() + " GrandTotal = GrandTotal+RoundTotal "+playerSolving.getPlayerGrandTotal());
            numberOfOccurrence=gamePlay.letterGuesser();
            if(gamePlay.phraseGuesser(gamePlay.getUnfinishedGuess().toString())){
                System.out.println("\n\nPlayer Won Their Turn");
                winnerQueue.Enqueue(playerSolving);
                return false ;
            }
        }
        System.out.println("\nPlayer "+playerSolving.getPlayerName()+ " lost turn");
        return true;

    }

    public void roundWinner(){
        System.out.println("\nList Of Player Results");
        int max=0;
        Player roundWinner=null;
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
            winnerQueue.Enqueue(roundWinner);

        }else {
            System.out.println("No Winner Was Determined");
        }

    }
    public static void main(String[] args) {

        Boolean findWinner=true;
        int rounds=0;
        Main main=new Main();
        main.PlayerDataFunction();

        Player playerToSolve= main.playerQueue.Dequeue();
        main.gamePlay.newRound();
        while (rounds!=3){
            System.out.println("-------------------------New Phrase Loaded-----------------------");
            System.out.println("-------------------------Categories-----------------------");
            System.out.println("-------------------------"+main.gamePlay.getCategory());
            while (playerToSolve.getPlayerName()!=null){
                if(main.wheelSpinValidation(playerToSolve)){
                    findWinner=main.solvePuzzle(playerToSolve);
                }
                if(!findWinner){
                    System.out.println("-------------------------New Phrase Loaded-----------------------");
                    System.out.println("-------------------------Categories-----------------------");
                    System.out.println("-------------------------"+main.gamePlay.getCategory());
                    main.gamePlay.newRound();
                }
                main.playerQueueTemp.Enqueue(playerToSolve);
                playerToSolve=main.playerQueue.Dequeue();
        }
//      Player reload of Queue
            main.playerQueue= new Queue(main.playerQueueTemp);
//      Find winner
            if (findWinner){
                main.roundWinner();
                main.gamePlay.newRound();

            }
//            main.playerQueueTemp=main.playerQueue;
            playerToSolve=main.playerQueue.Dequeue();

            rounds++;
            if(rounds!=3){
                System.out.println("\n\n\n\n\n\n\n\n----------------------------------------New Round---------------------------------------------");
                System.out.println("\n\n\n\n\n\n\n\n----------------------------------------"+rounds);

            }

        }

        System.out.println("\n\n\n\n\n\n\n\n----------------------------------------Overall Round Winner---------------------------------------------");
        main.roundWinner();




//        System.out.println(main.getPlayerQueue());




//        System.out.println(main.playerQueue);



////      Creates Wheel methods
//
//
//
////      Creates game interaction
//
//
////      Set number of rounds
//        for(int numberOfrounds=0;numberOfrounds<3;numberOfrounds++){
//
//            Boolean callNewPlayer=false;
////          Spin wheel
//            Card wheelSpinOutcome=wheel.spin();
////          Call player from Queue
//            roundPlayer=playerQueue.Dequeue();
//            if(roundPlayer.getPlayerName()!=null){
//                System.out.println("Player "+roundPlayer.getPlayerName()+" Spins Wheel");
//                System.out.println("Wheel Type: "+wheelSpinOutcome.getTypeOfCard()+"\t Value: "+wheelSpinOutcome.getValueOfCard());
////              Turn validation
//                if(wheelSpinOutcome.getTypeOfCard().equalsIgnoreCase("bankrupt")){
//                    System.out.println("Player Loses turn---->Bankrupt");
//                    callNewPlayer=true;
//                    roundQueue.Enqueue(roundPlayer);
//                }
//                else if (wheelSpinOutcome.getTypeOfCard().equalsIgnoreCase("loseturn")){
//                    callNewPlayer=true;
//                    roundQueue.Enqueue(roundPlayer);
//                    System.out.println("Player Loses turn--->No points will be rewarded");
//                }
//                while(callNewPlayer){
//    //              Call new player
//                    roundPlayer=playerQueue.Dequeue();
//    //              Spin wheel for new player
//                    wheelSpinOutcome=wheel.spin();
//
//                    if(roundPlayer.getPlayerName()==null ){
//                        System.out.println("No New Player");
//                        return;
//                    }
//                    System.out.println("Player "+roundPlayer.getPlayerName()+" Spins Wheel");
//                    System.out.println("Wheel Type: "+wheelSpinOutcome.getTypeOfCard()+"\t Value: "+wheelSpinOutcome.getValueOfCard());
//                    if(wheelSpinOutcome.getTypeOfCard().equalsIgnoreCase("bankrupt")){
//                        System.out.println("Player Loses Turn---->Bankrupt");
//                    }
//                    else if (wheelSpinOutcome.getTypeOfCard().equalsIgnoreCase("loseturn")){
//                        System.out.println("Player Loses Turn--->No points will be rewarded");
//                    }else{
//                        callNewPlayer=false;
//                    }
//                    roundQueue.Enqueue(roundPlayer);
//                }
//    //          Round Total
//                int roundTotal=0;
//    //          Vowel
//                Boolean boughtVowel=false;
//                Boolean spinWheel=false;
//    //          Triggers new phrase
//                gamePlay.newRound();
//
//    //          Triggers letter guesser
//                int numberOfOccurrence=gamePlay.letterGuesser();
//    //          Validates and display player option
//                if(numberOfOccurrence==0){
//                    System.out.println("\nPlayer "+roundPlayer.getPlayerName()+ " lost turn");
//                    roundQueue.Enqueue(roundPlayer);
//                }
//                else {
//                    System.out.println("\nMoney on the board: "+roundTotal+" + " +wheelSpinOutcome.getValueOfCard()+" * "+ numberOfOccurrence+" = "+ (roundTotal+=wheelSpinOutcome.getValueOfCard()*numberOfOccurrence) );
//                    while (!gamePlay.phraseGuesser(gamePlay.getUnfinishedGuess().toString())){
////                  Call user options
//                    String option= gamePlay.userOption();
//                    if(option.equals("0")){
//    //              Spin wheel
//                        if(!spinWheel){
//                            System.out.println("Spin Wheel"+wheel.spin());
//                            spinWheel=true;
//                        }
//                        else {
//                            System.out.println("You must solve or guesses letter before you spin again");
//                        }
//                    }
//                    else if(option.equals("1")) {
////                      Buy a vowel
//                        if(!boughtVowel){
//                            boughtVowel=true;
//                            gamePlay.buyVowel();
//                        }else {
//                            System.out.println("You must solve or guesses letter before you buy a vowel again");
//                        }
//                    }
//                    else if (option.equals("2")){
//    //                  Solve phrase
//                        System.out.println("Enter your phrase");
//                        String guessedPhrase =new Scanner(System.in).next();
//    //                  Validates
//                        if(gamePlay.getSecretPhrase().equalsIgnoreCase(guessedPhrase)){
//                            StringBuilder guessedPh=new StringBuilder();
//                            guessedPh.append(guessedPhrase);
//                            gamePlay.setUnfinishedGuess(guessedPh);
//                            numberOfOccurrence=0;
//                        }
//                    }
//                    else if(option.equals("3")){
//                        numberOfOccurrence=gamePlay.letterGuesser();
//                        System.out.println("\nMoney on the board: "+roundTotal+" + " +wheelSpinOutcome.getValueOfCard()+" * "+ numberOfOccurrence+" = "+ (roundTotal+=wheelSpinOutcome.getValueOfCard()*numberOfOccurrence) );
//                        if(numberOfOccurrence==0){
//                            System.out.println("\nPlayer loses turn");
//                            if(roundTotal==0){
//                                callNewPlayer=true;
////                                wheelSpinOutcome=wheel.spin();
//                                while(callNewPlayer){
//    //              Call new player
//                                    roundPlayer=playerQueue.Dequeue();
//
//                                    if(roundPlayer.getPlayerName()==null ){
//                                        System.out.println("No New Player");
//                                        return;
//                                    }
//                                    //              Spin wheel for new player
//                                    wheelSpinOutcome=wheel.spin();
//                                    System.out.println("Player "+roundPlayer.getPlayerName()+" Spins Wheel");
//                                    System.out.println("Wheel Type: "+wheelSpinOutcome.getTypeOfCard()+"\t Value: "+wheelSpinOutcome.getValueOfCard());
//                                    if(wheelSpinOutcome.getTypeOfCard().equalsIgnoreCase("bankrupt")){
//                                        System.out.println("Player Loses Turn---->Bankrupt");
//                                        roundQueue.Enqueue(roundPlayer);
//                                    }
//                                    else if (wheelSpinOutcome.getTypeOfCard().equalsIgnoreCase("loseturn")){
//                                        roundQueue.Enqueue(roundPlayer);
//                                        System.out.println("Player Loses Turn--->No points will be rewarded");
//                                    }else{
//                                        callNewPlayer=false;
//                                    }
//                                }
//                            }
//                            roundQueue.Enqueue(roundPlayer);
//
//                        }else{
//                            System.out.println("\nMoney on the board: "+roundTotal+" + " +wheelSpinOutcome.getValueOfCard()+" * "+ numberOfOccurrence+" = "+ (roundTotal+=wheelSpinOutcome.getValueOfCard()*numberOfOccurrence) );
//                            boughtVowel=false;
//                        }
//                    }
//                }
//                }
//                if(gamePlay.phraseGuesser(gamePlay.getUnfinishedGuess().toString())){
//                    System.out.println("\nPlayer won round");
//                    roundPlayer.setPlayerGrandTotal(roundPlayer.getPlayerNumber()+roundTotal);
//                    roundQueue.Enqueue(roundPlayer);
//                }
//    }
//            else{
//                playerQueue=roundQueue;
//            }
//        }

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


