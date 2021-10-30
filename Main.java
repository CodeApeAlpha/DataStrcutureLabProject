package DATASTRUCTURELAB_PROJECT;
import DATASTRUCTURELAB_PROJECT.Contestant.Player;
import DATASTRUCTURELAB_PROJECT.GamePlay.GamePlay;
import DATASTRUCTURELAB_PROJECT.Queue.Queue;
import DATASTRUCTURELAB_PROJECT.WHEEL.Wheel;
//import Queue.Queue;

public class Main {
    public static void main(String args[]) {

//        Wheel obj= new Wheel();
//        obj.getContent();
//        System.out.println("Spin"+obj.spin().toString());

//        Player playerObject_1=new Player(1,"Kemani");
//        Player playerObject_2=new Player(2,"Joel");
//        Player playerObject_3=new Player(3,"Jasmine");

//        Queue q = new Queue();
//        System.out.println("Number of Nodes: " + q.CountNodes());
//        q.Enqueue(playerObject_1);
//        System.out.println("Number of Nodes: " + q.CountNodes());
//        System.out.println("QueueFront: " + q.QueueFront().toString());
//        q.Enqueue(playerObject_2);
//        System.out.println("Number of Nodes: " + q.CountNodes());
//        System.out.println("QueueFront: " + q.QueueFront().toString());
//        q.Dequeue();
//        System.out.println("Number of Nodes: " + q.CountNodes());
//        System.out.println("QueueFront: " + q.QueueFront().toString());




        Wheel wheel= new Wheel();
        Player player1=new Player(001,"Kemani");

        GamePlay check= new GamePlay();

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

