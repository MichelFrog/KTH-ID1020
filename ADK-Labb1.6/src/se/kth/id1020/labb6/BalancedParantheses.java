package se.kth.id1020.labb6;

import java.io.IOException;
import java.util.*;

/*
 * Filter that check if a string of characters are balanced(i.e there are equal
 * amount of x-opening brackets as closing brackets). The program strives
 * to return an empty stack, which means that there are no open brackets without
 * a pair or neither of the two.
 * 
 * If an opening bracket isn't follow by the correct closing bracket the parentheses
 * in the string isn't balanced.
 * If an char is a closing bracket, the program check whether the stack is empty or if
 * the popped element is a corresponding opening bracket.
 * 
 * try and catch to allow casting from system.in to char
 * 
 * @author michelouadria
 */
public class BalancedParantheses {

	public static void main(String args[]) {

		
	try {
		System.out.println(isParenthesesBalanced((char)System.in.read()));
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

	/*
	 * Checks if there is equal amount of opening and closing brackets
	 * 
	 * @param stringOfChar A string that is read one character at a time
	 * 
	 * @return true(balanced) or false(not balanced)
	 */
	public static boolean isParenthesesBalanced(char input) {
		Stack<Character> stack = new Stack<Character>();
		char typedChar= ' ';
		

		while (typedChar != '\n') {
			char element;
			try {
				typedChar = typedChar = (char) System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (typedChar == '(' || typedChar == '[' || typedChar == '{') {
				stack.push(typedChar);
			} else if (typedChar == ')') {
				if (stack.isEmpty() || stack.pop() != ')') {
					return false;
				}

			} else if (typedChar == '[') {
				if (stack.isEmpty() || stack.pop() != ']') {
					return false;
				}

			} else if (typedChar == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
