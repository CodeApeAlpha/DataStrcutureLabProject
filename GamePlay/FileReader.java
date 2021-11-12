package DATASTRUCTURELAB_PROJECT.GamePlay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    /***************************************************************************************
     NOTE!!

     File path must be placed relative to the program root directory such that it matches "./src/questions.txt"

     Adding questions to the file should be in the format "Category" + 0 + "Phrase"..eg: "THING0Bottle"

     To get a CWP object, call "getCWP()"

     When all questions from the file have been used, the "CWP" object attributes will return "0"
     ****************************************************************************************/


    private  ArrayList<String> usedQuestions = new ArrayList<String>();

    private  ArrayList<String> fileData = new ArrayList<String>();

    private  CWP cwp = new CWP();

    private  int questionCount = 0;



    private String getRandomQuestion(int count) { //chooses a random number from the total questions
        int randomQuestionNum = (int) (Math.random() * count + 1);
        return fileData.get(randomQuestionNum - 1);
    }


    private String Compare(String question) { //returns a phrase that was not used before
        while(true) {
            if (usedQuestions.contains(question) == true) {
                question = getRandomQuestion(questionCount);
            }
            else {
                usedQuestions.add(question);
                break;
            }
        }

        return question;
    }


    private void createCWP(String question) {
        String category = "";
        String guessphrase = "";
        int splitPoint = 0;

        for (int i = 0; i < question.length(); i++) { //gets category
            if (question.charAt(i) == '0') {
                splitPoint = i + 1;
                break;
            }
            category = category + question.charAt(i);
        }

        for (int i = splitPoint; i < question.length(); i++) { //gets guess phrase
            guessphrase = guessphrase + question.charAt(i);
        }

        cwp.setCategory(category);
        cwp.setGuessPhrase(guessphrase);
    }


    public CWP getCWP() {
        File file = new File("C:\\Users\\young\\Desktop\\SpringBoot\\LAB6_ASSIGMENT\\src\\DATASTRUCTURELAB_PROJECT\\GamePlay\\questions.txt");
        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) { //Counts the number of questions in the file
                fileData.add(scanner.nextLine());
                questionCount++;
            }
            scanner.close();
            if (usedQuestions.size() != fileData.size() ) {
                createCWP(Compare(getRandomQuestion(questionCount)));
            }
            else {
                cwp.setCategory("0");
                cwp.setGuessPhrase("0");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }

        fileData.clear();
        questionCount = 0;
        return cwp;
    }





}




