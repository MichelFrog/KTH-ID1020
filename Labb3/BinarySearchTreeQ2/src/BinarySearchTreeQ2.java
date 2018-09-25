import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BinarySearchTreeQ2 {
    public class BST<Key extends Comparable<Key>, Value> {
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

    }

    /* Class for implementation of and ordered BinaryST */
    public static class OrderedBinaryST<Key extends Comparable<Key>, Value> {
        private Key[] keyArr;
        private Value[] valArr;
        private int N;

        public  OrderedBinaryST(int capacity) {
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
            if (isEmpty())
                return null;

            int i = rank(key);

            if (i < N && keyArr[i].compareTo(key) == 0)
                return valArr[i];
            else
                return null;
        }

        public int rank(Key key) {
            int lo = 0, hi = N - 1;
            while (lo <= hi) {
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

    }

    public static void main(String[] args) {
        Scanner readTxtFile = new Scanner(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");

        int minlen = Integer.parseInt(args[0]);

        OrderedBinaryST<String, Integer> OrdBST = new OrderedBinaryST<String, Integer>(minlen);

        int amountOfWordsToBeRead = 100; // Max length of words to read

        for (int i = 0; i < amountOfWordsToBeRead; i++) {

            while (readTxtFile.hasNext()) { // Build symbol table and count frequencies.
                String word = readTxtFile.next();
                if (word.length() < minlen)
                    continue; // Ignore short keys.
                if (!OrdBST.contains(word))
                    OrdBST.put(word, 1);
                else
                    OrdBST.put(word, OrdBST.get(word) + 1);
            }
            // Find a key with the highest frequency count.
            String max = "";
            OrdBST.put(max, 0);
            for (String word : OrdBST.keyArr) {
                if (OrdBST.get(word) > OrdBST.get(max))
                    max = word;
                System.out.println(max + " " + OrdBST.get(max));
            }

        }
    }
}
