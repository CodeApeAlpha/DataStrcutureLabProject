package DATASTRUCTURELAB_PROJECT.GamePlay;

public class CWP {

    private String Category;
    private String guessPhrase;

    public CWP() {
        Category = "";
        guessPhrase = "";
    }

    public CWP(String category, String guessphrase) {
        Category = category;
        guessPhrase = guessphrase;
    }

    public CWP(CWP obj) {
        Category = obj.getCategory();
        guessPhrase = obj.getGuessPhrase();
    }

    public String getCategory() {
        return Category;
    }

    public String getGuessPhrase() {
        return guessPhrase;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setGuessPhrase(String guessphrase) {
        guessPhrase = guessphrase;
    }

};
