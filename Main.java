package DATASTRUCTURELAB_PROJECT;
import DATASTRUCTURELAB_PROJECT.Contestant.Player;
import DATASTRUCTURELAB_PROJECT.GamePlay.GamePlay;
import DATASTRUCTURELAB_PROJECT.Queue.Queue;
import DATASTRUCTURELAB_PROJECT.WHEEL.Wheel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


//        Wheel obj= new Wheel();
//        Card SpinedWheelResults=obj.spin();
//        System.out.println("Type Of Card "+SpinedWheelResults.getTypeOfCard());
//        System.out.println("Vale Of Card "+SpinedWheelResults.getValueOfCard());

//           Boolean check= new GamePlay().phraseGuesser("all the world is a stage");
//           System.out.println(check);
//        Queue q=new Queue();
//        Player playerObject_1=new Player(1,"Kemani");
//        Player playerObject_2=new Player(2,"Joel");
//        Player playerObject_3=new Player(3,"Jasmine");
//
//
//        System.out.println("Number of Nodes: " + q.CountNodes());
//        q.Enqueue(playerObject_1);
//        System.out.println("Number of Nodes: " + q.CountNodes());
//        System.out.println("QueueFront: " + q.QueueFront());
//        q.Enqueue(playerObject_2);
//        System.out.println("Number of Nodes: " + q.CountNodes());
//        System.out.println("QueueFront: " + q.QueueFront());
//        q.Dequeue();
//        System.out.println("Number of Nodes: " + q.CountNodes());
//        System.out.println("QueueFront: " + q.QueueFront());




//        int count=0;
//        Queue playerQueue = new Queue();
//        System.out.println("Enter Player Name");
//        String nameOfPlayer=new Scanner(System.in).next();
//        Player players=new Player(count,nameOfPlayer);
//        playerQueue.Enqueue(players);
//        while(true){
//            try {
//
//                System.out.println("Would you like to enter more y/n");
//                String userInput=new Scanner(System.in).next();
//                if(!userInput.equalsIgnoreCase("y")){
//                    break;
//                }
//                System.out.println("Enter Player Name");
//                nameOfPlayer=new Scanner(System.in).next();
//                Player additionalPlayers =new Player(++count,nameOfPlayer);
//                playerQueue.Enqueue(additionalPlayers);
//            }catch ( Exception e){
//                System.out.println("Invalid response");
//            }
//
//        }
//
//        playerQueue.QueueFront();


        GamePlay check=new GamePlay();
        check.newRound();
        Wheel wheel= new Wheel();
        int numberOfOccurrence=check.letterGuesser();

        while (numberOfOccurrence!=-0){
            String option= check.userOption();
            if(option.equals("0")){
//              Spin wheel
                System.out.println("Spin Wheel"+wheel.spin());
            }else if(option.equals("1")) {
//              Buy a vowel
                System.out.println("Buy a vowel");
            }else {
                System.out.println(check.getUnfinishedGuess());
                numberOfOccurrence=check.letterGuesser();
            }
        }
        System.out.println("\nPlayer loses turn");
    }
}

