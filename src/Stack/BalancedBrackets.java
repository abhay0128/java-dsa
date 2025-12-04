package Stack;

import java.util.*;
import java.lang.*;

public class BalancedBrackets {

    public static boolean isBalanced(String input) {
        if (input == null || input.length() % 2 != 0) return false;

        java.util.Stack<Character> stack = new java.util.Stack<>();

        Map<Character, Character> bracketPairs = Map.of(
                ')', '(',
                '}', '{',
                ']', '[',
                '>', '<'
        );

        for (char c : input.toCharArray()) {
            if (bracketPairs.containsValue(c)) {
                stack.push(c); // Opening bracket
            } else if (bracketPairs.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != bracketPairs.get(c)) {
                    return false; // Mismatched or no matching opening
                }
            } else {
                return false; // Invalid character
            }
        }

        return stack.isEmpty(); // True if all matched
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{}[(){]}"));
    }
}
