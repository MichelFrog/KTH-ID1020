
public class InsertionSortDescendingOrder {

    // Select size of array

    // Enter desired amount
    int length = 0;
    int[] arrayToBeSorted;
    static int numberOfSorts;

    public static void insertionSortDescendingOrder(int[] array) {
        int lengthOfArray = array.length;
        int j;
        for (int i = 1; i < lengthOfArray; i++) { // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            j = i;
            while (j > 0 && (array[j] >
            array[j - 1])) {
                swap(array, j, j - 1);
                j--;
                ++numberOfSorts;
                System.out.println(printTheArray(array));
                System.out.println("Number of swaps: " + numberOfSorts);
            }
        }
    }

    private static void swap(int[] a, int current, int next) {
        int arrayValue = a[current];
        a[current] = a[next];
        a[next] = arrayValue;
    }


    public static String printTheArray(int array[]) {
        StringBuilder arrayAtTheMoment = new StringBuilder();
        int k = 0;
        while (k < array.length) {
            arrayAtTheMoment.append("[");
            arrayAtTheMoment.append(array[k]);
            arrayAtTheMoment.append("]");
            arrayAtTheMoment.append(",");
            k++;
        }
        arrayAtTheMoment.deleteCharAt(arrayAtTheMoment.length() - 1);
        return arrayAtTheMoment.toString();
    }

    public static void main(String[] args) {

        int[] arraytobesorted = { 3,75,234,7657,2,5,67,577 };
        insertionSortDescendingOrder(arraytobesorted);
    }

}
