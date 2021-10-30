package DATASTRUCTURELAB_PROJECT.CircularLinkedListWheel;

public class Node {

    private Card nodeOfCardData;
    private Node nextNodeCard;

    public Node(Card nodeOfCardData, Node nextNodeCard, Node prevNodeCard) {
        this.nodeOfCardData = nodeOfCardData;
        this.nextNodeCard = nextNodeCard;
    }

    public Node(Card nodeOfCardData) {
        this.nodeOfCardData = nodeOfCardData;
        this.nextNodeCard = null;
    }

    public Card getNodeOfCardData() {
        return nodeOfCardData;
    }

    public void setNodeOfCardData(Card nodeOfCardData) {
        this.nodeOfCardData = nodeOfCardData;
    }

    public Node getNextNodeCard() {
        return nextNodeCard;
    }

    public void setNextNodeCard(Node nextNodeCard) {
        this.nextNodeCard = nextNodeCard;
    }

}
