import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/*
 * @author michelouadria
 *
 */
public class SeparateChainingHashSTQ7<Key, Value> {
    
    public static void main(String[] args) throws FileNotFoundException {
        /************************ 
         ***** BINARY ST ******** 
         ************************/

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

        System.out.println("Word count of text: "+amountOfWords);
        /************************
         *SEPERATE CHAINING HASH*
         ************************/

        // Scanner and filreader WORKS
        FileReader readTxtForBST = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");
        Scanner readTxtFileForBST = new Scanner(readTxtForBST);

        SeparateChainingHashSTQ7<String, Integer> SCH = new SeparateChainingHashSTQ7<String, Integer>();


        long startTimeForSEARCH_SCH = System.currentTimeMillis();
        while (readTxtFileForBST.hasNext()) { 
            String word = readTxtFileForBST.next(); 
            distinctWords++;
            if (word.length() < minlen) 
                continue; 
            if (!SCH.contains(word)) {
                SCH.put(word, 1);
            } else
                SCH.put(word, SCH.get(word) + 1); 
        }
        long stopTimeSEARCH_SCH = System.currentTimeMillis();
        long elapsedTimeSEARCH_SCH = stopTimeSEARCH_SCH - startTimeForSEARCH_SCH;
        System.out.println("Excution time for SEARCH of Seperate Chaining Hash: " + elapsedTimeSEARCH_SCH + "ms");

        
        long startTimeForBUILD_SCH = System.currentTimeMillis();
        /* FOR BINARY SEARCH TREE */
        String SCHmax = "";
        SCH.put(SCHmax, 0);
        for (String word : SCH.keys()) {
            if (SCH.get(word) > SCH.get(SCHmax)) {
                SCHmax = word;
            }
        }
        long stopTimeBUILD_SCH = System.currentTimeMillis();
        long elapsedTimeBUILD_SCH = stopTimeBUILD_SCH - startTimeForBUILD_SCH;
        System.out.println("Excution time for BUILD of Seperate Chaining Hash: " + elapsedTimeBUILD_SCH
                + "ms");
        System.out.println(SCHmax + " " + SCH.get(SCHmax));
        System.out.println();






        /* ************************
         * ************************
         * LINEAR PROBIING HASH ST
         * ************************
         * ************************
         * ************************/

        FileReader readTxtForLBHST = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");
        Scanner txtForLBHST = new Scanner(readTxtForLBHST);

        LinearProbingHashSTQ7<String, Integer> LBHST = new LinearProbingHashSTQ7<String, Integer>();

        long startTimeForSEARCH_LBHST = System.currentTimeMillis();
        while (txtForLBHST.hasNext()) { 
            String word = txtForLBHST.next(); 
            distinctWords++;
            if (word.length() < minlen) 
                continue; 
            if (!LBHST.contains(word)) {
                LBHST.put(word, 1);
            } else
                LBHST.put(word, LBHST.get(word) + 1); 
        }
        long stopTimeSEARCH_LBHST = System.currentTimeMillis();
        long elapsedTimeSEARCH_LBHST = stopTimeSEARCH_LBHST - startTimeForSEARCH_LBHST;
        System.out.println("Execution time for SEARCH of Linear Probing Hash ST: "
                + ": " + elapsedTimeSEARCH_LBHST + "ms");

        
        
        long startTimeForBUILD_LBHST = System.currentTimeMillis();

        /* FOR RED BLACK TREE */
        String LBHSTmax = "";
        LBHST.put(LBHSTmax, 0);
        for (String word : LBHST.keys()) {
            if (LBHST.get(word) > LBHST.get(LBHSTmax)) {
                LBHSTmax = word;
            }
        }
        long stopTimeBUILD_LBHST = System.currentTimeMillis();
        long elapsedTimeBUILD_LBHST = stopTimeBUILD_LBHST - startTimeForBUILD_LBHST;
        System.out.println("Execution time for BUILD of Linear Probing Hash ST: "
                + ": " + elapsedTimeBUILD_LBHST + "ms");
        System.out.println(LBHSTmax + " " + LBHST.get(LBHSTmax));
        System.out.println();
        
    }
    private static final int INIT_CAPACITY = 4;

    private int n;                                // number of key-value pairs
    private int m;                                // hash table size
    private SequentialSearchSTQ7<Key, Value>[] st;  // array of linked-list symbol tables


    /**
     * Initializes an empty symbol table.
     */
    public SeparateChainingHashSTQ7() {
        this(INIT_CAPACITY);
    } 

    /**
     * Initializes an empty symbol table with {@code m} chains.
     * @param m the initial number of chains
     */
    @SuppressWarnings("unchecked")
    public SeparateChainingHashSTQ7(int m) {
        this.m = m;
        st = (SequentialSearchSTQ7<Key, Value>[]) new SequentialSearchSTQ7[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchSTQ7<Key, Value>();
    } 

    // resize the hash table to have the given number of chains,
    // rehashing all of the keys
    private void resize(int chains) {
        SeparateChainingHashSTQ7<Key, Value> temp = new SeparateChainingHashSTQ7<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    // hash value between 0 and m-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } 


    public int size() {
        return n;
    } 


    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    } 


    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    } 

 
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        // double table size if average length of list >= 10
        if (n >= 10*m) resize(2*m);

        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    } 

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

        // halve table size if average length of list <= 2
        if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
    } 

    // return keys in symbol table as an Iterable
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }
}

  

