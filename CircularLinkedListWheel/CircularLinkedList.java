package DATASTRUCTURELAB_PROJECT.CircularLinkedListWheel;


public class CircularLinkedList {

    private Node Head=null;
    private Node Tail=null;

    public CircularLinkedList(){

    }

    public void addToBack(Card card) {
//      Create new node
        Node newNode = new Node(card);
        //Checks if the list is empty.
        if (Head == null) {
            //If list is empty, both head and tail would point to new node.
            Head = newNode;
            Tail = newNode;
            newNode.setNextNodeCard(Head);
        } else {
            //tail will point to new node.
            Tail.setNextNodeCard(newNode);
            //New node will become new tail.
            Tail = newNode;
            Tail.setNextNodeCard(Head);
        }
    }


    public Node getHead() {
        return Head;
    }

    public void setHead(Node head) {
        Head = head;
    }

    public Node getTail() {
        return Tail;
    }

    public void setTail(Node tail) {
        Tail = tail;
    }
}
