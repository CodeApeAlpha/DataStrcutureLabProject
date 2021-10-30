package DATASTRUCTURELAB_PROJECT.Queue;

import DATASTRUCTURELAB_PROJECT.Contestant.Player;

public class Node {

    private Player playerData;
    private Node nextNode;
    private Node prevNode;


    public Node(){
        this.playerData=null;
        this.nextNode=null;
        this.prevNode=null;
    }

    public Node(Player playerData) {
        this.playerData = playerData;
        this.nextNode = null;
        this.prevNode = null;
    }

    public Node(Node nodeObject) {
        this.playerData = nodeObject.getPlayerData();
        this.nextNode = nodeObject.getNextNode();
        this.prevNode = nodeObject.getPrevNode();
    }

    public Player getPlayerData() {
        return playerData;
    }

    public void setPlayerData(Player playerData) {
        this.playerData = playerData;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

}
