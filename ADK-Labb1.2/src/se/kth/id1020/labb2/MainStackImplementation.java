package se.kth.id1020.labb2;
import java.io.IOException;
/*
 * Main class which is used to test the LIFO_Stack and recursive
 * method from LIFO_Stack API. Reads the input from System.in and
 * casts it to chars which are pushed onto the stack.
 * 
 * Exception handling is used to allow from casting from System.in
 * to char.
 * 
 */
public class MainStackImplementation {
    public static void main(String[] args) throws IOException {
    	
    		try {
        LIFO_Stack<Character> stack = new LIFO_Stack<Character>(); 
        char typedChar= ' ';
        while (typedChar != '\n') {
            typedChar = (char) System.in.read();
            stack.push(typedChar);
        }
        stack.pop();
        while(!stack.isEmpty()) {
            stack.PopAndPrintStack();
        }
        
    		}catch(IOException e){
    	        System.out.println (e.toString()); 
    		}
    	
    }
}