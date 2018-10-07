import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/**********************/
public class FindindicesOfWordQ6 {

    public static void main(String[] args) throws FileNotFoundException {

        /************************
         * BINARY SEARCH TREE
         **************************************/
        // Scanner and file-reader
        FileReader readTxtTMP = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");
        Scanner readTxtFileTMP = new Scanner(readTxtTMP);

        int amountOfWords = 0;
        /* Count amount of words in text */
        while (readTxtFileTMP.hasNext()) {
            if (null == readTxtFileTMP.next()) {
                break;
            }
            amountOfWords++;
        }

        // Scanner and file-reader
        FileReader readTxtForBST = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");
        Scanner readTxtFileForBST = new Scanner(readTxtForBST);

        BST<String, Integer> BinarySearchTree = new BST<String, Integer>();

        Scanner inputFromKeyboard = new Scanner(System.in); // Reading from System.in
        System.out.println("Which word do you want to find: ");
        String wordToBeFound = inputFromKeyboard.next().toLowerCase();
        inputFromKeyboard.close();

        int minlen = wordToBeFound.length();

        int wordCounter = 0;
        int charCounter = 0;
        int index = 0;
        int amountOfTimesWordIsFound = 0;

        String[] indicesWhereTheWordAppears = new String[amountOfWords];

        long startTimeForBST = System.currentTimeMillis();

        while (readTxtFileForBST.hasNext()) { // Build symbol table and count
            String word = readTxtFileForBST.next().toLowerCase(); // Read the next string from the file
            wordCounter++;
            charCounter += word.length();
            if (word.length() < minlen) // Disregard small words
                continue; // Ignore short keys.
            if (word.equals(wordToBeFound)) {
                amountOfTimesWordIsFound++;
                indicesWhereTheWordAppears[index++] = ((charCounter - word.length()) + "-" + charCounter);
            }
            if (amountOfWords == wordCounter) {
                break;
            }
        }
        System.out.println("Looking for the word [" + wordToBeFound + "] in the text...");
        System.out.println("---------------------");

        // Check if there we not match, else print out how many were found. Iterate
        // through the string array and show.
        if (0 == amountOfTimesWordIsFound)
            System.out.println("[" + wordToBeFound + "] isnt a part of the text");
        else
            System.out.println(wordToBeFound + " appears in the text [" + amountOfTimesWordIsFound + "] times!");
        for (int i = 0; i < amountOfTimesWordIsFound; i++) {
            if (null == indicesWhereTheWordAppears[i]) {
                break;
            }

            System.out.print("#"+i+" ["+ indicesWhereTheWordAppears[i] + "] ");
            if (i % 2 == 0) {
                System.out.println();
            }
        }
        long stopTimeBST = System.currentTimeMillis();
        long elapsedTimeBST = stopTimeBST - startTimeForBST;
        System.out.println();
        System.out.println("Execution for function is " + elapsedTimeBST + "ms");

    }
}
