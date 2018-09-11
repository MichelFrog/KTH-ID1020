package se.kth.id1020.labb6;

import java.util.*;

/*
 * Filter that check if a string of characters are balanced(i.e there are equal
 * amount of x-opening brackets as closing brackets). The program strives
 * to return an empty stack, which means that there are no open brackets without
 * a pair or neither of the two.
 * 
 * If an opening bracket isn't follow by the correct closing bracket the parentheses
 * in the string isn't balanced.
 * 
 * 
 * @author michelouadria
 */
public class BalancedParantheses {

	public static void main(String args[]) {

		System.out.println(isParenthesesBalanced("[{HELLO]}"));
		System.out.println(isParenthesesBalanced("[{}"));
		System.out.println(isParenthesesBalanced("This is a sentence"));
		System.out.println(isParenthesesBalanced("This is a sentence]"));
		System.out.println(isParenthesesBalanced("12312412"));
		System.out.println(isParenthesesBalanced(null));

	}

	/*
	 * Checks if there is equal amount of opening and closing brackets
	 * 
	 * @param stringOfChar A string that is read one character at a time
	 * 
	 * @return true(balanced) or false(not balanced)
	 */
	public static boolean isParenthesesBalanced(String stringOfChars) {
		Stack<Character> stack = new Stack<Character>();
		
		
		if(stringOfChars == null) {
			System.out.print("Can't determine input ERROR: " + stringOfChars + " ");
			return false;
		}
		for (int i = 0; i < stringOfChars.length(); i++) {
			char element = stringOfChars.charAt(i);

			if (element == '(' || element == '[' || element == '{') {
				stack.push(element);
			} else if (element == ')') {
				if (stack.isEmpty() || stack.pop() != ')') {
					return false;
				}

			} else if (element == '[') {
				if (stack.isEmpty() || stack.pop() != ']') {
					return false;
				}

			} else if (element == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
