package DATASTRUCTURELAB_PROJECT.Contestant;

public class Player {

    private int playerNumber=0;
    private String playerName;
    private int playerGrandTotal=0;

    public Player() {
    }

    public Player(Player playerObject) {
        this.playerNumber++;
        this.playerName = playerObject.playerName;
        this.playerGrandTotal =playerObject.playerGrandTotal;
    }

    public Player(int playerNumber,String playerName) {
        this.playerNumber=playerNumber;
        this.playerName = playerName;
    }


    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerGrandTotal() {
        return playerGrandTotal;
    }

    public void setPlayerGrandTotal(int playerGrandTotal) {
        this.playerGrandTotal = playerGrandTotal;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerNumber=" + playerNumber +
                ", playerName='" + playerName + '\'' +
                ", playerGrandTotal=" + playerGrandTotal +
                '}';
    }
}
