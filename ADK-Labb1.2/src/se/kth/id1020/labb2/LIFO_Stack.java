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
    int counter = 0;
    int size;
    
    /*Recursive function that keep call itself till the */
    public void PopAndPrintStack() {
        
        if (isEmpty()) {
            return;
        } else {
            if(this.size != 0) {
            System.out.print(",");
            }
            System.out.print("[");
            System.out.print(pop());
            System.out.print("]");
            PopAndPrintStack();
            size--;
        }
    }
    
    void push(E element) {
        if(element == null) {
           System.out.println("Can't store null in stack");
        }
        stack[++size] = element;
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
    
   public static void main(String[] args) throws IOException {
    	
        LIFO_Stack<Character> stack = new LIFO_Stack<Character>(); 
        char typedChar= ' ';
        while (typedChar != '\n') {
            typedChar = (char) System.in.read();
            stack.push(typedChar);
        }
        stack.pop();
        stack.PopAndPrintStack();
    }
}
