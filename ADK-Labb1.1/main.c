#include <stdio.h>
/*
 * Program receives standard input which is added to an array.
 * The array prints in reverse by using recursion
 * OR
 * by using an iterative while loop function
 *
 * Maximum amount of charcter that can be typed is 20, can be changed.
 *
 *@auther michelouadria
 */
int const MAXIMUM_VALUE_FOR_STACK = 20;
int counter = 0;
char typedChar[MAXIMUM_VALUE_FOR_STACK];
char c;

void recursiveReversePrintStack(int counter){

    if(counter >= 0){
        putchar(typedChar[counter]);
        recursiveReversePrintStack(counter-1);
    }
}

void iterativeReversePrintStack(int counter){

    while(counter >= 0){
        putchar(typedChar[counter--]);
    }
}


int main() {

    while(c  != '\n'){
        c = getchar();
        typedChar[counter++] = c;
    }
    counter--;

//    recursiveReversePrintStack(counter);

    iterativeReversePrintStack(counter);
    return 0;
}
