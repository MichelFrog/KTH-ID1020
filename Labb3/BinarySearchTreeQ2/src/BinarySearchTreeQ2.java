import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
//import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTreeQ2 {
    public static class BST<Key extends Comparable<Key>, Value> {
        private Node root;

        private class Node {
            private Key key;
            private Value val;
            private Node left, right;
            private int N;

            public Node(Key key, Value val, int N) {
                this.key = key;
                this.val = val;
                this.N = N;
            }
        }

        public int size() {
            return size(root);
        }

        private int size(Node x) {
            if (x == null)
                return 0;
            else
                return x.N;
        }

        boolean contains(Key key) {
            return get(key) != null;
        }

        public Value get(Key key) {
            return get(root, key);
        }

        private Value get(Node x, Key key) { // Return value associated with key in the subtree rooted at x;
                                             // return null if key not present in subtree rooted at x.
            if (x == null)
                return null;
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                return get(x.left, key);
            else if (cmp > 0)
                return get(x.right, key);
            else
                return x.val;
        }

        public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
            root = put(root, key, val);
        }

        private Node put(Node x, Key key, Value val) {
            // Change key’s value to val if key in subtree rooted at x.
            // Otherwise, add new node to subtree associating key with val.
            if (x == null)
                return new Node(key, val, 1);
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x.left = put(x.left, key, val);
            else if (cmp > 0)
                x.right = put(x.right, key, val);
            else
                x.val = val;
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        public Key min() {
            return min(root).key;
        }

        public Key max() {
            return root.key;
        }

        private Node min(Node x) {
            if (x.left == null)
                return x;
            return min(x.left);
        }

        public Iterable<Key> keys() {
            return keys(min(), max());
        }

        public Iterable<Key> keys(Key lo, Key hi) {
            Queue<Key> queue = new Queue<Key>();
            keys(root, queue, lo, hi);
            return queue;
        }

        private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
            if (x == null)
                return;
            int cmplo = lo.compareTo(x.key);
            int cmphi = hi.compareTo(x.key);
            if (cmplo < 0)
                keys(x.left, queue, lo, hi);
            if (cmplo <= 0 && cmphi >= 0)
                queue.enqueue(x.key);
            if (cmphi > 0)
                keys(x.right, queue, lo, hi);
        }

        /*
         * public Iterable<Key> keys
         * 
         * public Iterable<Key> nodeIterator() { Queue<Key> keys = new Queue<Key>();
         * Queue<Node> queue = new Queue<Node>(); queue.enqueue(root); while
         * (!queue.isEmpty()) { Node x = queue.dequeue(); if (x == null) continue;
         * keys.enqueue(x.key); queue.enqueue(x.left); queue.enqueue(x.right); } return
         * keys; }
         */

    }

    /*********************************************************************************
     * Class for implementation of and ordered BinaryST
     *******************************************************************************/
    public static class OrderedBinaryST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
        private Key[] keyArr;
        private Value[] valArr;
        private int N;

        public OrderedBinaryST(int capacity) {
            keyArr = (Key[]) new Comparable[capacity];
            valArr = (Value[]) new Object[capacity];
        }
        

        public int size() {
            return N;
        }

        boolean contains(Key key) {
            return get(key) != null;
        }

        private boolean isEmpty() {
            return N == 0;
        }

        public Value get(Key key) {
            if (isEmpty()) // Check if empty
                return null;

            int i = rank(key); // Find where key is located at

            if (i < N && keyArr[i].compareTo(key) == 0)
                return valArr[i];
            else
                return null;
        }

        public int rank(Key key) {
            int lo = 0, hi = N - 1; // Start and end
            while (lo <= hi) { // While Start not equal hi
                int mid = lo + (hi - lo) / 2;

                int cmp = key.compareTo(keyArr[mid]);
                if (cmp < 0)
                    hi = mid - 1;
                else if (cmp > 0)
                    lo = mid + 1;
                else
                    return mid;
            }
            return lo;
        }

        public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
            int i = rank(key);
            if (i < N && keyArr[i].compareTo(key) == 0) {
                valArr[i] = val;
                return;
            }
            for (int j = N; j > i; j--) {
                keyArr[j] = keyArr[j - 1];
                valArr[j] = valArr[j - 1];
            }
            keyArr[i] = key;
            valArr[i] = val;
            N++;
        }

        private class KeyIterator<key> implements Iterator<Key> {
            private Key[] currentKey = keyArr;
            private int size = N;
            private int currentPos = 1;

            @Override
            public boolean hasNext() {
                return currentPos < size;

            }

            @Override
            public Key next() {
                return currentKey[currentPos++];
            }

        }

        @Override
        public Iterator<Key> iterator() {
            return new KeyIterator();
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        /************************BINARY ST**************************************/

        
        // Scanner and filreader WORKS
        FileReader readTxt = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");
        Scanner readTxtFile = new Scanner(readTxt);

        int minlen = 3;
        int amountOfWords = 100;

        OrderedBinaryST<String, Integer> binarySearchST = new OrderedBinaryST<>(amountOfWords);
        
        long startTimeForBinaryST = System.currentTimeMillis();
        while (readTxtFile.hasNext() && null != readTxtFile.next()) { // Build symbol table and count frequencies.
            String word = readTxtFile.next();                        // Read the next string from the file
            if (word.length() < minlen) {                                    // Disregard small words
                continue;                }                            // Ignore short keys.
            if ( !binarySearchST.contains(word)) { binarySearchST.put(word, 1);}// At first
            else { binarySearchST.put(word, binarySearchST.get(word) + 1);} // Increase the value of said key            
            if(binarySearchST.N == amountOfWords-1) {break;}
            }
        

        /* FOR BINARY SEARCH SYMBOL TABLE */
        String max = "";
        binarySearchST.put(max, 0);
        Iterator<String> iterator = binarySearchST.iterator();
        while (iterator.hasNext()) {
            String word = (String) iterator.next();
            if(null == word) {break;}
            if (binarySearchST.get(word) > binarySearchST.get(max)) {
                max = word;
            }
        }
        
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTimeForBinaryST;
        System.out.println("Excution for BinaryST: " + elapsedTime + "ms");
        System.out.println(max + " " + binarySearchST.get(max));

        
        
        
        
        
        
        /************************BINARY SEARCH TREE**************************************/
        
        
        // Scanner and filreader WORKS
        FileReader readTxtForBST = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");
        Scanner readTxtFileForBST = new Scanner(readTxtForBST);

        BST<String, Integer> BinarySearchTree = new BST<String, Integer>();

        int amountOfWordsToRead = 100;

        long startTimeForBST = System.currentTimeMillis();
        while (readTxtFileForBST.hasNext() && null != readTxtFileForBST.next()) { // Build symbol table and count
                                                                                  // frequencies.
            String word = readTxtFileForBST.next(); // Read the next string from the file
            if (word.length() < 3) // Disregard small words
                continue; // Ignore short keys.
            if (!BinarySearchTree.contains(word))
                BinarySearchTree.put(word, 1);// At first
            else
                BinarySearchTree.put(word, BinarySearchTree.get(word) + 1); // Increase the value of said key
                       
            if(amountOfWordsToRead == BinarySearchTree.size()) {
                break;}
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

    }

}
