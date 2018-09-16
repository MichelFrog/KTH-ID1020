#include <stdio.h>
/*
 * A method that order elements in two halfs,
 * negative first and positive integers after.
 *
 *@auther michelouadria
 */

void quickSortNegLeftPosRight(int array[], int length){

    int right;
    for(int i = 1; i < length; i++){
        int current = array[i];
        if(current>0){
            right = i - 1;
            while (right >= 0 && array[right] > 0)
            {
                array[i + 1] = array[right];
                right = right - 1;
            }
            array[right+1] = current;
        }
    }

    return;



}
void print(int array[], int length)
{
    for (int i = 0; i < length; i++)
        printf("%d ", array[i]);
}

int main() {
    int listOfIntegers[] = {1,2,-4,123,23,-24,525,63};

    int length = sizeof(listOfIntegers);
    quickSortNegLeftPosRight(listOfIntegers,length);
    print(listOfIntegers,length);

    return 0;
}
