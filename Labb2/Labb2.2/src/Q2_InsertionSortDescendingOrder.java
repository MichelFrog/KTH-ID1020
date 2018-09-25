import java.util.Scanner;

/**
 * Sorts the array in descending order according to the insertion algorithm.
 * 
 * Assume index 0 is sorted. Start at 1.
 * Check the values that comes before 1 is smaller
 * If so, swap the elements.
 * If not, try to decrement and check again.
 * If not, exit while and go to next index. 
 *
 * @author michelouadria
 *
 */
public class Q2_InsertionSortDescendingOrder {

    int length = 0;
    int[] arrayToBeSorted;
    static int numberOfSorts;

    public static void insertionSortDescendingOrder(int[] array) {
        int lengthOfArray = array.length;
        int j;
        
        for (int i = 1; i < lengthOfArray; i++) {
            j = i;
            while (j > 0 && (array[j] > array[j - 1])) {
                swap(array, j, j - 1);
                j--;
                ++numberOfSorts;
                System.out.println(printTheArray(array));
                System.out.println("Number of swaps so far: " + numberOfSorts);
            }
        }
    }
    
    /*Swap element from current to the position of next*/
    private static void swap(int[] a, int current, int next) {
        int arrayValue = a[current];
        a[current] = a[next];
        a[next] = arrayValue;
    }

    /*print the values of each index between opening and closing brackets*/
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
        Scanner input = new Scanner(System.in);
        
        System.out.println("Choose size of array: ");
        int N = input.nextInt();
        
        int[] arraytobesorted = new int[N];

        
        System.out.println("Enter values in array: ");
        for(int i = 0; i < N; i++) {
            System.out.println("Please add " + (N-i) + " numbers");
            arraytobesorted[i] = input.nextInt();
        }
        
        insertionSortDescendingOrder(arraytobesorted);
    }

}
