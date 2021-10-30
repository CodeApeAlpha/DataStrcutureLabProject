package DATASTRUCTURELAB_PROJECT.WHEEL;

import DATASTRUCTURELAB_PROJECT.CircularLinkedListWheel.Card;
import DATASTRUCTURELAB_PROJECT.CircularLinkedListWheel.CircularLinkedList;
import DATASTRUCTURELAB_PROJECT.CircularLinkedListWheel.Node;

public class Wheel {

    private CircularLinkedList content=null;
    private Node currentPosition=null;

    public Wheel(){
        content=loadWheel();
        this.currentPosition=content.getHead();
    }

//  Act as a repository of data
    private CircularLinkedList loadWheel(){
        CircularLinkedList wheel= new CircularLinkedList();
    //      Money
        wheel.addToBack(new Card("Money",2500));
        wheel.addToBack(new Card("Money",600));
        wheel.addToBack(new Card("Money",700));
        wheel.addToBack(new Card("Money",600));
        wheel.addToBack(new Card("Money",650));
        wheel.addToBack(new Card("Money",500));
        wheel.addToBack(new Card("Money",700));
    //      Bankrupt
        wheel.addToBack(new Card("Bankrupt",0));
    //      Money
        wheel.addToBack(new Card("Money",600));
        wheel.addToBack(new Card("Money",550));
        wheel.addToBack(new Card("Money",500));
        wheel.addToBack(new Card("Money",600));
    //      Bankrupt
        wheel.addToBack(new Card("Bankrupt",0));
    //      Money
        wheel.addToBack(new Card("Money",650));
        wheel.addToBack(new Card("Money",850));
        wheel.addToBack(new Card("Money",700));
    //      Lose Turn
        wheel.addToBack(new Card("LoseTurn",0));
    //      Money
        wheel.addToBack(new Card("Money",800));
        wheel.addToBack(new Card("Money",500));
        wheel.addToBack(new Card("Money",650));
        wheel.addToBack(new Card("Money",500));
        wheel.addToBack(new Card("Money",900));
        wheel.addToBack(new Card("Money",700));
    //      Bankrupt
        wheel.addToBack(new Card("Bankrupt",0));
        return wheel;
    }

    public Card spin(){
        Node arrowPointer=currentPosition;
        int random_int = (int)Math.floor(Math.random()*(100-50+1)+50);
        for(int start=0;start<=random_int;start++){
            arrowPointer=arrowPointer.getNextNodeCard();
        }
        currentPosition=arrowPointer;
        return arrowPointer.getNodeOfCardData();
    }

    public CircularLinkedList getContent() {
        return content;
    }

    public void setContent(CircularLinkedList content) {
        this.content = content;
    }
}
