package DATASTRUCTURELAB_PROJECT.Queue;
import DATASTRUCTURELAB_PROJECT.Contestant.Player;

public class Queue {

    private Node Front;
    private Node Rear;

    public Queue(){
        Front=null;
        Rear=null;
    }
    public Queue(Queue data){
        Front=data.Front;
        Rear=data.Rear;
    }

    public void Enqueue(Player playerObject){
        Node temp = new Node(playerObject);
        if (temp != null)
        {
            if(Front ==null)
            {
                Front=temp;
                Rear=temp;
            }
            else
            {
                Rear.setNextNode(temp);
                temp.setPrevNode(Rear);
                Rear = temp;
            }
        }
        else
        {
            System.err.println("The list is full. Cannot add another node.");
        }
    }

    public Player Dequeue(){
        Player dataToReturn = new Player();
        if(Front != null)
        {
            if(Front == Rear){
                Rear = null;
            }
            Node temp = Front;
            dataToReturn = Front.getPlayerData();
            Front = Front.getNextNode();
            if(Front != null)
            {Front.setPrevNode(null);}
            temp = null;
        }
        return dataToReturn;
    }

    public Player QueueFront(){
        if(Front == null)
        {
            System.out.println("The Queue is empty, cannot return value(s).");
            return null;
        }
        else
        {
            return Front.getPlayerData();
        }
    }

    public int CountNodes(){
        int count = 0;
        Queue tempQueue = new Queue(); //create temp queue
        while(Front != null) //while the original queue not empty
        {
            Player collect=Dequeue();
            tempQueue.Enqueue(collect); //remove from original queue and add to tempQueue
            count++; //increment counter
        }
        while(tempQueue.getFront()!= null) //while the tempQueue not empty
        {
            Player collect_2=tempQueue.Dequeue();
            Enqueue(collect_2); //dequeue from tempQueue and add to original
        }
        return count; // return the count
    }

    public Node getFront() {
        return Front;
    }

    public void setFront(Node front) {
        Front = front;
    }

    public Node getRear() {
        return Rear;
    }

    public void setRear(Node rear) {
        Rear = rear;
    }

 
}