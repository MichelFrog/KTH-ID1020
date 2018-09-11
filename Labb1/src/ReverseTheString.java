import java.util.Stack;
import java.util.ArrayList;
import java.util.Scanner;

public class ReverseTheString {
	static Stack<Character> charStack = new Stack<Character>();
	
	public static void main(String[] args) {
		
	    Scanner in = new Scanner(System.in);
		/*Start with reading the user input 
		 * till the user enters a newline*/
	    
	    int newLine = 0;
	    
	    while(readTypedChars(in) != newLine) {
	    readTypedChars(in);	}    
	    	}
	
	/*
	 * Reads the the user input till a newline is entered.
	 */
	private static int readTypedChars(Scanner in) 
	{
		
		char charInput = nextChar(in);
		if(charInput != '\n') {
			charStack.push(charInput);
			readTypedChars(in);
			return 1;
		}
		else {return 0;}
				
		}
		
	
	
	private static void reversePrint(Stack<Character> charStack) 
	{
		if(charStack.isEmpty()) { System.out.println("Stack is empty");}
		
		while(charStack != null) {
			System.out.print(c);
		}
		
		
	}
	
	/*Used to fetch the most recent input from client and 
	 * make the code more readable*/
	private static char nextChar(Scanner in) {
		return in.next().charAt(0);	
		}
}
