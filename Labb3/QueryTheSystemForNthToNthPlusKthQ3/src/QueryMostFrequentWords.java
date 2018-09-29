import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

public class QueryMostFrequentWords {

    public static void readAllWordsInText(Scanner fileName, int countWords) {
        while (fileName.hasNext()) {
            fileName.next();
            countWords++;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        /************************ BINARY ST **************************************/

        // Scanner and filreader WORKS
        FileReader readTxtTMP = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");
        Scanner readTxtFileTMP = new Scanner(readTxtTMP);

        int minlen = 3;
        int distinctWords = 0;
        int amountOfWords = 0;
        /* Count amount of words in text */
        while (readTxtFileTMP.hasNext()) {
            if (null == readTxtFileTMP.next()) {
                break;
            }
            amountOfWords++;
        }

        /************************
         * BINARY SEARCH TREE
         **************************************/

        // Scanner and filreader WORKS
        FileReader readTxtForBST = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");
        Scanner readTxtFileForBST = new Scanner(readTxtForBST);

        BST<String, Integer> BinarySearchTree = new BST<String, Integer>();
        BST<String, Integer> BinarySearchTreeCopy = new BST<String, Integer>();

        long startTimeForBST = System.currentTimeMillis();
        while (readTxtFileForBST.hasNext()) { // Build symbol table and count
            String word = readTxtFileForBST.next(); // Read the next string from the file
            if (null == word) {
                System.out.println("Found null");
            }
            if (word.length() < minlen) // Disregard small words
                continue; // Ignore short keys.
            if (!BinarySearchTree.contains(word)) {
                BinarySearchTree.put(word, 1);
                BinarySearchTreeCopy.put(word, 1);
                distinctWords++;
            } else {
                BinarySearchTree.put(word, BinarySearchTree.get(word) + 1); // Increase the value of said key
                BinarySearchTreeCopy.put(word, BinarySearchTreeCopy.get(word) + 1);
            }
            if (amountOfWords == BinarySearchTree.size()) {
                break;
            }
        }

        Scanner inputFromKeyboard = new Scanner(System.in); // Reading from System.in
        System.out.println("Enter the Nth most frequent word: ");
        int nth = inputFromKeyboard.nextInt();
        if(nth > distinctWords || nth < 0) {System.exit(1);}
        System.out.println("Show till Kth most freqeuent word (must be greater): ");
        int kth = inputFromKeyboard.nextInt();
        if(kth > distinctWords || nth < 0) {System.exit(1);}
        inputFromKeyboard.close();
        
        //String array that stores all most frequet words(keys)
        String[] ascendingFreqWord = new String[distinctWords];
        ascendingFreqWord[0] = "";
        int i = 1;
        /* FOR BINARY SEARCH TREE */
        String maxBST = "";
        BinarySearchTreeCopy.put(maxBST, 0);
        while (i < distinctWords) {
            for (String word : BinarySearchTreeCopy.keys()) {
                if (BinarySearchTreeCopy.get(word) > BinarySearchTreeCopy.get(maxBST)) {
                    maxBST = word;
                }
            }
            BinarySearchTreeCopy.put(maxBST, 0); 
            if(i >= nth && i <=kth) 
                ascendingFreqWord[i] = maxBST;
            else if(i>kth) 
                   break; 
            i++;
        }
               
        String theWord = "";
        System.out.println("The most frequent words from " + nth +" to " + kth + " are:");
        for(i = nth; i <= (kth); i++) {
            theWord = ascendingFreqWord[i];
            System.out.println(theWord + " #" + BinarySearchTree.get(theWord));
        }
        long stopTimeBST = System.currentTimeMillis();
        long elapsedTimeBST = stopTimeBST - startTimeForBST;
        System.out.println("Excution for Binary Search Tree: " + elapsedTimeBST + "ms");

    }
}
