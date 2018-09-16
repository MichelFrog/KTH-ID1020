
/*
 * Implement one of the algorithms in chapter 2.1. Augment the sorting 
 * process so that all the content of the array that is being sorted is 
 * printed after each inner loop iteration. Write a unit test in main() 
 * which allows the user to define the size of the input (N) and then input
 *  (N) integers from the command line which is to be sorted.
 */
public class InsertionSort<T> {
    // Select size of array

    // Enter desired amount
    int length = 0;
    int[] arrayToBeSorted;

    public static void insertionSort(int[] array) {
        int lengthOfArray = array.length;
        int j;
        for (int i = 1; i < lengthOfArray; i++) { // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            j = i;
            while (j > 0 && (array[j] < array[j - 1])) {
                swap(array, j, j - 1);
                j--;
                System.out.println(printTheArray(array));
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

        int[] arraytobesorted = { 100, 12, 31, 5, 4, 3, 2, 1 };
        insertionSort(arraytobesorted);
    }

}
