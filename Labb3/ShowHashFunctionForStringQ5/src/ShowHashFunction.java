import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/* Write a program that shows how evenly the built-in hash function 
 * for strings in Java distributes the hashes for the words found in the text.
 * 
 * Unicode for:
 * 0-9 = 48-57
 * A-Z = 65-90
 * a-z = 97-122
 * 
 * */
public class ShowHashFunction {
    
    public static void main(String[]args ) throws FileNotFoundException {

        /************************
         * BINARY SEARCH TREE
         **************************************/

        // Scanner and filreader WORKS
        FileReader readTxtForBST = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");
        Scanner readTxtFileForBST = new Scanner(readTxtForBST);

        BST<String, Integer> BinarySearchTree = new BST<String, Integer>();
        
        int counter = 1;
        int DistinctWordsInText = 0;
        int minlen = 3;
        int amountOfWords = 100;

        long startTimeForBST = System.currentTimeMillis();
        while (readTxtFileForBST.hasNext()) { // Build symbol table and count
            String word = readTxtFileForBST.next(); // Read the next string from the file
            counter++;
            if (null == word) {
                System.out.println("Found null");
            }
            if (word.length() < minlen) // Disregard small words
                continue; // Ignore short keys.
            if (!BinarySearchTree.contains(word)) {
                BinarySearchTree.put(word, 1);
                DistinctWordsInText++;
            } else {
                BinarySearchTree.put(word, BinarySearchTree.get(word) + 1); // Increase the value of said key
            }
            if (amountOfWords == counter) {
                break;
            }
        }
        System.out.println("Check if distinct words equal size of Tree");
        System.out.println("Distinct words in text: " + DistinctWordsInText);
        System.out.println("Size of BinarySearchTree: " + BinarySearchTree.size());
        System.out.println("---------------------");


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
        
    }
}
