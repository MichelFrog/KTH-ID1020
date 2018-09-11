package se.kth.id1020.labb6;
import java.util.*;

/*
 * Filter that check if a string of characters are balanced(i.e there are equal
 * amount of x-opening brackets as closing brackets)
 * 
 * 1.Check if its an opening bracket, one of three.
 * 2.Immediately check if there is any closing bracket, 
 * if not same type OR stack is empty, return false.
 * 3.Check if there
 * 
 * 
 * @author michelouadria
 */
public class BalancedParantheses {

    public static void main(String args[]) {
        
//        System.out.println(isParenthesesBalanced("[{HELLO]}"));
        System.out.println(isParenthesesBalanced("{(})[{}]"));
//        System.out.println(isParenthesesBalanced("This is a sentence"));
//        System.out.println(isParenthesesBalanced("This is a sentence]"));
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

        for (int i = 0; i < stringOfChars.length(); i++) {
            char element = stringOfChars.charAt(i);
            // If the the char at each position is open bracket and push to stack.
            if (element == '[' || element == '(' || element == '{') {
                stack.push(element);
            } else if (element == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
            } else if (element == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }

            } else if (element == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
            }
            System.out.println(element);
        }
        return stack.isEmpty();
    }
}
