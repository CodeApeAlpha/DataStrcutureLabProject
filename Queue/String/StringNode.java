package DATASTRUCTURELAB_PROJECT.Queue.String;

public class StringNode {

    private String guesses;
    private StringNode nextNode;
    private StringNode prevNode;


    public StringNode(){
        this.guesses=null;
        this.nextNode=null;
        this.prevNode=null;
    }

    public StringNode(String input) {
        this.guesses = input;
        this.nextNode = null;
        this.prevNode = null;
    }

    public StringNode(StringNode nodeObject) {
        this.guesses = nodeObject.guesses;
        this.nextNode = nodeObject.getNextNode();
        this.prevNode = nodeObject.getPrevNode();
    }

    public String getGuesses() {
        return guesses;
    }

    public void setGuesses(String guesses) {
        this.guesses = guesses;
    }

    public StringNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(StringNode nextNode) {
        this.nextNode = nextNode;
    }

    public StringNode getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(StringNode prevNode) {
        this.prevNode = prevNode;
    }
}
