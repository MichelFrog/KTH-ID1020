import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Insertion sort that firstly prints out the inventions needed to sort
 * the array in descending order.
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
public class Q4_InsertionSortPrintInversions {
    int length = 0;
    int[] arrayToBeSorted;
    static int numberOfSorts;

    /*
     * Sort array in descending order
     * 
     * 
     * @param array The array to be sorted
     */
    public static void insertionSortDescendingOrder(int[] array) {
        numberOfSorts=0;
        int lengthOfArray = array.length;
        int j;
        for (int i = 1; i < lengthOfArray; i++) {                   //Iterate through the array from 1 to length
            j = i;
            while (j > 0 && (array[j] > array[j - 1])) {            //Do as long as the current index isn't greater than previous
                swap(array, j, j - 1);
                j--;
                ++numberOfSorts;
                System.out.println(printTheArray(array));
                System.out.println("Number of swaps: " + numberOfSorts);
            }
        }
    }

    /*Swap element from current to the position of next*/
    private static void swap(int[] a, int current, int next) {
        int arrayValue = a[current];
        a[current] = a[next];
        a[next] = arrayValue;
    }
    
    
    /*Sort and print the inversions of a duplicated array and print the number of swaps */
    public static void printInversions(int array[]) {
        int[] tempArray = Arrays.copyOf(array, array.length);   //C1    1  
        int lengthOfArray = tempArray.length;                   //C2    1
        int j;                                                  //C3    1
        for (int i = 1; i < lengthOfArray; i++) {               //C4    n+1 
            j = i;                                              //c5    n
            while (j > 0 && (tempArray[j] > tempArray[j - 1])){ //c6    for->(n+1)*n = n^2 + n
                swap(tempArray, j, j - 1);                      //c7    3*n(?)
                j--;                                            //c8    n
                ++numberOfSorts;                                //c9    n
                System.out.print("[");                          //c10-x n*13
                System.out.print(j);
                System.out.print(",");
                System.out.print(tempArray[j]);
                System.out.print("]");
                System.out.print(",");
                System.out.print("[");
                System.out.print(j+1);
                System.out.print(",");
                System.out.print(tempArray[j+1]);
                System.out.print("]");
                System.out.println();
                System.out.println("Number of swaps: " + numberOfSorts);
            }
        }
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

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Choose size of array: ");
        int n = input.nextInt();
        
        int[] arraytobesorted = new int[n];

        
        System.out.println("Enter values in array: ");
        for(int i = 0; i < n; i++) {
            System.out.println((n-i) + " to go");
            arraytobesorted[i] = input.nextInt();
        } 
        System.out.println(printTheArray(arraytobesorted));
        printInversions(arraytobesorted);
        
        TimeUnit.SECONDS.sleep(3);

        insertionSortDescendingOrder(arraytobesorted);

    }
}