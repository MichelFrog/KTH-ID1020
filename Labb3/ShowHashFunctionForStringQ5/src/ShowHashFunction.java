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

    public static void main(String[] args) throws FileNotFoundException {

        /************************
         * BINARY SEARCH TREE
         **************************************/
        int amountOfWords = 0;
        FileReader readTemp = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");
        Scanner readTxt = new Scanner(readTemp);
        while (readTxt.hasNext()) {
            if (null == readTxt.next())
                break;
            amountOfWords++;
        }
        System.out.println("Total wordcount in text: " + amountOfWords);
        // Scanner and filreader WORKS
        FileReader readTxtForBST = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");
        Scanner readTxtFileForBST = new Scanner(readTxtForBST);

        BST<String, Integer> BinarySearchTree = new BST<String, Integer>();
        BST<Integer, String> BinarySearchTreeOfHash = new BST<Integer, String>();

        int counter = 0;
        int DistinctWordsInText = 0;
        int collison = 0;

        long startTimeForBST = System.currentTimeMillis();
        while (readTxtFileForBST.hasNext()) { // Build symbol table and count
            String word = readTxtFileForBST.next(); // Read the next string from the file
            int hashValue = word.toString().hashCode();
            counter++;
            if (null == word) {
                System.out.println("Found null");
            }
            if (!BinarySearchTree.contains(word)) { // Add new word to the tree
                BinarySearchTree.put(word, 1);
                DistinctWordsInText++;
            } else {
                BinarySearchTree.put(word, BinarySearchTree.get(word) + 1);
            }

            if (!BinarySearchTreeOfHash.contains(hashValue)) { // Add new hashValue(int) to tree with the word(String)
                BinarySearchTreeOfHash.put(hashValue, word);
            } else if (!BinarySearchTreeOfHash.get(hashValue).equals(word)) {
                collison++;
                System.out.println("Collision #" + collison + ":\n" + "The collison occured with hashCode: [" + hashValue
                        + "], which belongs to both [" + word + "] & [" + BinarySearchTreeOfHash.get(hashValue) + "]");
            }
            if (amountOfWords == counter) {
                break;
            }
        }
        /* FOR BINARY SEARCH TREE */
        long stopTimeBST = System.currentTimeMillis();
        long elapsedTimeBST = stopTimeBST - startTimeForBST;
        System.out.println();
        System.out.println("Probability of collision: " + collison +" out of "+amountOfWords );
        System.out.println("Excution for Binary Search Tree: " + elapsedTimeBST + "ms");

    }
}
