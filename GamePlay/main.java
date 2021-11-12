package DATASTRUCTURELAB_PROJECT.GamePlay;

public class main {

    public static void main(String[] args) {

        for (int i = 0; i <=2; i++) {
            CWP cwp = new CWP();
            FileReader fileReader=new FileReader();
            fileReader.getCWP();
            System.out.println(cwp.getCategory() + " " + cwp.getGuessPhrase());
        }
    }
}
