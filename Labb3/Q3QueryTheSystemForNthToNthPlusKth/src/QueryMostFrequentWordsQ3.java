import java.awt.font.NumericShaper.Range;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

/*
 * Binary search tree datastructure that is used to find 
 * the the most frequent words from Nth to Nth + Kth in a text file of a certain length
 * */
public class QueryMostFrequentWordsQ3 {

    public static void main(String[] args) throws FileNotFoundException {

        /************************ BINARY ST **************************************/

        // Scanner and filreader WORKS
        FileReader readTxtTMP = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");
        Scanner readTxtFileTMP = new Scanner(readTxtTMP);

        Scanner input = new Scanner(System.in); // Reading from System.in
        System.out.println("Enter the minimum length of the words(Interval of 1-10): ");
        int minlen = input.nextInt();
        if (minlen > 10 || minlen < 1) {
            System.out.println("Please try again with an integer without the Range.");
            System.exit(1);
        }

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

        long startTimeForBUILD_BST = System.currentTimeMillis();
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

        /* CHOOSE NTH AND KTH */
        long stopTimeBUILD_BST = System.currentTimeMillis();
        long elapsedTimeBUILD_BST = stopTimeBUILD_BST - startTimeForBUILD_BST;
        System.out.println("Execution for build of Binary Search Tree: " + elapsedTimeBUILD_BST + "ms");

        System.out.println("Enter the Nth most frequent word: ");
        int nth = input.nextInt();
        if (nth > distinctWords || nth < 0) {
            System.exit(1);
        }
        System.out.println("Show till Kth most frequent word (must be greater than previous): ");
        int kth = input.nextInt();
        if (kth > distinctWords || nth < 0 || nth > kth) {
            System.exit(1);
        }
        input.close();

        long startTimeForBUILBD_AND_SEARCH_BST = System.currentTimeMillis();
        // String array that stores all most frequent words(keys)
        String[] decendingFreqWord = new String[distinctWords];
        decendingFreqWord[0] = "";
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
            if (i >= nth && i <= kth+nth)
                decendingFreqWord[i] = maxBST;
            else if (i > kth+nth)
                break;
            i++;
        }

        String theWord = "";
        System.out.println("The most frequent words from " + nth + " to " + kth + " are:");
        for (i = nth; i <= (kth+nth); i++) {
            theWord = decendingFreqWord[i];
            System.out.println("#"+i + "["+ theWord + "] #" + BinarySearchTree.get(theWord));
        }
        long stopTimeForBUILBD_AND_SEARCH_BST = System.currentTimeMillis();
        long elapsedTimeBST = stopTimeForBUILBD_AND_SEARCH_BST - startTimeForBUILBD_AND_SEARCH_BST;
        System.out.println("Execution for Binary Search Tree: " + elapsedTimeBST + "ms");

    }
}
