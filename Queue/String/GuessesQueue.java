package DATASTRUCTURELAB_PROJECT.Queue.String;

public class GuessesQueue {
    private StringNode Front;
    private StringNode Rear;

    public GuessesQueue(){
        Front=null;
        Rear=null;
    }
    public GuessesQueue(GuessesQueue data){
        Front=data.Front;
        Rear=data.Rear;
    }

    public void Enqueue(String playerObject){
        StringNode temp = new StringNode(playerObject);
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

    public String Dequeue(){
        String dataToReturn=null;
        if(Front != null)
        {
            if(Front == Rear){
                Rear = null;
            }
            StringNode temp = Front;
            dataToReturn = Front.getGuesses();
            Front = Front.getNextNode();
            if(Front != null)
            {Front.setPrevNode(null);}
            temp = null;
        }
        return dataToReturn;
    }

    public String QueueFront(){
        if(Front == null)
        {
            System.out.println("The Queue is empty, cannot return value(s).");
            return null;
        }
        else
        {
            return Front.getGuesses();
        }
    }

    public void Display(){
        GuessesQueue transfer= new GuessesQueue();
        String displayString=Dequeue();
        System.out.println("\n\nList Of Guessed Letters");
        while (displayString!=null) {
            System.out.println(displayString);
            transfer.Enqueue(displayString);
            displayString=Dequeue();
        }
        String returnString=transfer.Dequeue();
        while (returnString!=null) {
            Enqueue(returnString);
            returnString=transfer.Dequeue();
        }


    }

    public StringNode getFront() {
        return Front;
    }

    public void setFront(StringNode front) {
        Front = front;
    }

    public StringNode getRear() {
        return Rear;
    }

    public void setRear(StringNode rear) {
        Rear = rear;
    }
}
