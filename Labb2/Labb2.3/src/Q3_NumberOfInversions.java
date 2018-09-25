import java.util.Scanner;


/**
 * Sorts the array in descending order according to insertion sort algorithm.
 * 
 * Before the array is sorted the number of inversions needed to sort the array. Each
 * index is check through a for loop and compared if the current element is smaller
 * and increment a counter of inversions. This is done till the whole array has been
 * covered.
 * 
 * Its equal to the number of swap for insertion sort.
 * 
 * @author michelouadria
 *
 */
public class Q3_NumberOfInversions {

    int length = 0;
    int[] arrayToBeSorted;
    static int numberOfSorts;
    
    /*Sorts the array in descending order, accordint to insertion sort*/
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

    /*Checks the array element by element to find how many of the following
     * elements are of a greater value(since the array is sorted in 
     * descending order)*/
    private static int numberOfInversions(int array[], int length) {
          int countInvertions = 0; 
          for (int i = 0; i < length; i++) 
            for (int j = i+1; j < length; j++) 
              if (array[i] < array[j]) 
                  countInvertions++; 
          
          return countInvertions; 
    }
    /*Swap current position in the array with the next position the array*/
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
        int n = input.nextInt();
        
        int[] arraytobesorted = new int[n];

        
        System.out.println("Enter values in array: ");
        for(int i = 0; i < n; i++) {
            System.out.println((n-i) + " to go");
            arraytobesorted[i] = input.nextInt();
        }
        System.out.println("Number of Invertions equals: " + numberOfInversions(arraytobesorted,arraytobesorted.length));
        System.out.println();
        insertionSortDescendingOrder(arraytobesorted);
    }

}


