import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class mainRedBlackQ4 {

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


        long startTimeForBST = System.currentTimeMillis();
        while (readTxtFileForBST.hasNext()) { // Build symbol table and count
            String word = readTxtFileForBST.next(); // Read the next string from the file
            distinctWords++;
            if (word.length() < minlen) // Disregard small words
                continue; // Ignore short keys.
            if (!BinarySearchTree.contains(word)) {
                BinarySearchTree.put(word, 1);// At first
            } else
                BinarySearchTree.put(word, BinarySearchTree.get(word) + 1); // Increase the value of said key
        }

        /* FOR BINARY SEARCH TREE */
        String BSTmax = "";
        BinarySearchTree.put(BSTmax, 0);
        for (String word : BinarySearchTree.keys()) {
            if (BinarySearchTree.get(word) > BinarySearchTree.get(BSTmax)) {
                BSTmax = word;
            }
        }
        long stopTimeBST = System.currentTimeMillis();
        long elapsedTimeBST = stopTimeBST - startTimeForBST;
        System.out.println("Excution for Binary Search Tree: " + elapsedTimeBST + "ms");
        System.out.println(BSTmax + " " + BinarySearchTree.get(BSTmax));
        System.out.println();






        /* ************************
         * ************************
         * ************************
         * ************************
         * ************************
         * RED BLACK TREE EXECUTION
         * ************************
         * ************************
         * ************************
         * ************************
         * ************************
         * ************************/

        FileReader readTxtForRBT = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");
        Scanner txtForRBT = new Scanner(readTxtForRBT);

        RedBlackTree<String, Integer> RedBlackTree = new RedBlackTree<String, Integer>();

        long startTimeForRBT = System.currentTimeMillis();
        while (txtForRBT.hasNext()) { // Build symbol table and count
            String word = txtForRBT.next(); // Read the next string from the file
            distinctWords++;
            if (word.length() < minlen) // Disregard small words
                continue; // Ignore short keys.
            if (!RedBlackTree.contains(word)) {
                RedBlackTree.put(word, 1);// At first
            } else
                RedBlackTree.put(word, RedBlackTree.get(word) + 1); // Increase the value of said key
        }

        /* FOR RED BLACK TREE */
        String RBTmax = "";
        RedBlackTree.put(RBTmax, 0);
        for (String word : RedBlackTree.keys()) {
            if (RedBlackTree.get(word) > RedBlackTree.get(RBTmax)) {
                RBTmax = word;
            }
        }
        long stopTimeRBT = System.currentTimeMillis();
        long elapsedTimeRBT = stopTimeRBT - startTimeForRBT;
        System.out.println("Excution for Red Black Tree"
                + ": " + elapsedTimeRBT + "ms");
        System.out.println(RBTmax + " " + RedBlackTree.get(RBTmax));
        System.out.println();
    }
}
