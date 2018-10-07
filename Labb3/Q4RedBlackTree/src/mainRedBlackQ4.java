import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/*
 * Main for comparison of redblack tree and binary search tree
 * @author michelouadria
 */
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

        System.out.println(amountOfWords);
        /************************
         * BINARY SEARCH TREE
         **************************************/

        // Scanner and filreader WORKS
        FileReader readTxtForBST = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");
        Scanner readTxtFileForBST = new Scanner(readTxtForBST);

        BST<String, Integer> BinarySearchTree = new BST<String, Integer>();


        long startTimeForSEARCH_BST = System.currentTimeMillis();
        while (readTxtFileForBST.hasNext()) { 
            String word = readTxtFileForBST.next(); 
            distinctWords++;    //Not used
            if (word.length() < minlen)
                continue; 
            if (!BinarySearchTree.contains(word)) {
                BinarySearchTree.put(word, 1);
            } else
                BinarySearchTree.put(word, BinarySearchTree.get(word) + 1); 
        }
        long stopTimeSEARCH_BST = System.currentTimeMillis();
        long elapsedTimeSEARCH_BST = stopTimeSEARCH_BST - startTimeForSEARCH_BST;
        System.out.println("Execution time for SEARCH of Binary Search Tree: " + elapsedTimeSEARCH_BST + "ms");

        
        long startTimeForBUILD_BST = System.currentTimeMillis();
        /* FOR BINARY SEARCH TREE */
        String BSTmax = "";
        BinarySearchTree.put(BSTmax, 0);
        for (String word : BinarySearchTree.keys()) {
            if (BinarySearchTree.get(word) > BinarySearchTree.get(BSTmax)) {
                BSTmax = word;
            }
        }
        long stopTimeBUILD_BST = System.currentTimeMillis();
        long elapsedTimeBUILD_BST = stopTimeBUILD_BST - startTimeForBUILD_BST;
        System.out.println("Execution time for BUILD of Binary Search Tree: " + elapsedTimeBUILD_BST
                + "ms");
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

        long startTimeForSEARCH_RBT = System.currentTimeMillis();
        while (txtForRBT.hasNext()) { 
            String word = txtForRBT.next(); 
            distinctWords++;
            if (word.length() < minlen) 
                continue; 
            if (!RedBlackTree.contains(word)) {
                RedBlackTree.put(word, 1);
            } else
                RedBlackTree.put(word, RedBlackTree.get(word) + 1); 
        }
        long stopTimeSEARCH_RBT = System.currentTimeMillis();
        long elapsedTimeSEARCH_RBT = stopTimeSEARCH_RBT - startTimeForSEARCH_RBT;
        System.out.println("Execution time for SEARCH of Red Black Tree: "
                + ": " + elapsedTimeSEARCH_RBT + "ms");

        
        
        long startTimeForBUILD_RBT = System.currentTimeMillis();

        /* FOR RED BLACK TREE */
        String RBTmax = "";
        RedBlackTree.put(RBTmax, 0);
        for (String word : RedBlackTree.keys()) {
            if (RedBlackTree.get(word) > RedBlackTree.get(RBTmax)) {
                RBTmax = word;
            }
        }
        long stopTimeBUILD_RBT = System.currentTimeMillis();
        long elapsedTimeBUILD_RBT = stopTimeBUILD_RBT - startTimeForBUILD_RBT;
        System.out.println("Execution time for BUILD of Red Black Tree: "
                + ": " + elapsedTimeBUILD_RBT + "ms");
        System.out.println(RBTmax + " " + RedBlackTree.get(RBTmax));
        System.out.println();
    }
}
