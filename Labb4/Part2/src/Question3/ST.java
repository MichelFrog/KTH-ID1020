package Question3;
import java.util.Iterator;

/***
 * Used for SymbolGraph implementation.
 * @author michelouadria
 * ***/
    public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    		private static final int INIT_CAPACITY = 4;
        private Key[] keyArr;
        private Value[] valArr;
        private int N;

        public ST() {
            this(INIT_CAPACITY);
        }
        public ST(int capacity) {
            keyArr = (Key[]) new Comparable[capacity];
            valArr = (Value[]) new Object[capacity];
        }

        public int size() {
            return N;
        }
        private void resize(int capacity) {
            assert capacity >= N;
            Key[]   tempk = (Key[])   new Comparable[capacity];
            Value[] tempv = (Value[]) new Object[capacity];
            for (int i = 0; i < N; i++) {
                tempk[i] = keyArr[i];
                tempv[i] = valArr[i];
            }
            valArr = tempv;
            keyArr = tempk;
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
        /*
         * 
         * */
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
            
            if (N == keyArr.length) resize(2*keyArr.length);
            
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
            private int currentPos = 0;

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