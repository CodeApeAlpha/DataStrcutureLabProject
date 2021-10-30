package DATASTRUCTURELAB_PROJECT.CircularLinkedListWheel;

public class Card {

    private String typeOfCard;
    private int valueOfCard;

    public Card(String typeOfCard, int valueOfCard) {
        this.typeOfCard = typeOfCard;
        this.valueOfCard = valueOfCard;
    }

    public String getTypeOfCard() {
        return typeOfCard;
    }

    public void setTypeOfCard(String typeOfCard) {
        this.typeOfCard = typeOfCard;
    }

    public int getValueOfCard() {
        return valueOfCard;
    }

    public void setValueOfCard(int valueOfCard) {
        this.valueOfCard = valueOfCard;
    }

    @Override
    public String toString() {
        return "Card{" +
                "typeOfCard='" + typeOfCard + '\'' +
                ", valueOfCard='" + valueOfCard + '\'' +
                '}';
    }
}
