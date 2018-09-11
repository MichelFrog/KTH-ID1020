package se.kth.id1020.labb2;
import java.io.IOException;

public class MainStackImplementation extends LIFO_Stack<Character> {
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

