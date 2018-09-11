package se.kth.id1020.labb2;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.lang.IllegalArgumentException; 
import java.io.*;

/**
 * The program uses a stack to add all elements from standard input from
 * the client. Each element is added with push function.
 * A recursive function pops and prints all the inputs in reverse with pop function.
 * @author michelouadria
 *
 */
public class LIFO_Stack<E> {
    E stack[];
    int counter = 1;
    int size;
    
    public void PopAndPrintStack() {
        
        if (isEmpty()) {
            return;
        } else {
            if(this.counter !=0) {
            System.out.print(",");
            }
            System.out.print("[");
            System.out.print(pop());
            System.out.print("]");
            PopAndPrintStack();
        }
    }
    
    void push(E element) {
        if(element == null) {
           System.out.println("Can't store null in stack");
        }
        stack[++counter] = element;
    }
    
    E pop() {
        E fetchedElement = stack[--this.counter];
        stack[this.counter]=null;
        return fetchedElement;
    }
    
    private  boolean isEmpty() {
        return size==0; 
    } 
    
    private int size() {
        return this.size;
    }
}
