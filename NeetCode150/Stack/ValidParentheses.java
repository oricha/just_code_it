/**
 * Valid Parentheses
 * You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
 *
 * The input string s is valid if and only if:
 *
 * Every open bracket is closed by the same type of close bracket.
 * Open brackets are closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * Return true if s is a valid string, and false otherwise.
 *
 * Example 1:
 *
 * Input: s = "[]"
 *
 * Output: true
 * Example 2:
 *
 * Input: s = "([{}])"
 *
 * Output: true
 * Example 3:
 *
 * Input: s = "[(])"
 *
 * Output: false
 * Explanation: The brackets are not closed in the correct order.
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 */

import java.util.*;

/**
 * Valid Parentheses
 * Given a string `s` consisting of '(', ')', '{', '}', '[' and ']', determine if the string is valid.
 *
 * A valid string follows these conditions:
 * 1. Every opening bracket has a corresponding closing bracket.
 * 2. Brackets must be closed in the correct order.
 *
 * Example 1:
 * Input: s = "[]"
 * Output: true
 *
 * Example 2:
 * Input: s = "([{}])"
 * Output: true
 *
 * Example 3:
 * Input: s = "[(])"
 * Output: false
 */

class ValidParentheses {
    /**
     * Checks if a string contains valid parentheses using a stack.
     *
     * @param s The input string containing brackets.
     * @return True if the string is valid, otherwise false.
     */
    public boolean isValid(String s) {
        // Stack to track opening brackets
        Stack<Character> stack = new Stack<>();

        // HashMap to store matching pairs of brackets
        Map<Character, Character> bracketPairs = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If it's a closing bracket, check if it matches the last opened bracket
            if (bracketPairs.containsKey(c)) {
                // Pop from stack or use a placeholder if empty
                char top = stack.isEmpty() ? '#' : stack.pop();

                // If mismatched brackets, return false
                if (top != bracketPairs.get(c)) return false;
            } else {
                // If it's an opening bracket, push onto the stack
                stack.push(c);
            }
        }

        // Valid if all brackets are matched (stack should be empty)
        return stack.isEmpty();
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        // Example 1
        String s1 = "[]";
        System.out.println(solution.isValid(s1)); // Output: true

        // Example 2
        String s2 = "([{}])";
        System.out.println(solution.isValid(s2)); // Output: true

        // Example 3
        String s3 = "[(])";
        System.out.println(solution.isValid(s3)); // Output: false

        // Example 4
        String s4 = "{[()]}";
        System.out.println(solution.isValid(s4)); // Output: true

        // Example 5
        String s5 = "({[)]}";
        System.out.println(solution.isValid(s5)); // Output: false
    }
}

/**
 * Explanation of the Solution
 * 	1.	Use a Stack (Stack<Character>) to store opening brackets.
 * 	2.	Use a HashMap (Map<Character, Character>) to define matching bracket pairs.
 * 	3.	Iterate through the string:
 * 	•	If it’s an opening bracket ((, {, [), push it onto the stack.
 * 	•	If it’s a closing bracket (), }, ]):
 * 	•	Check if it matches the top of the stack.
 * 	•	If mismatched or stack is empty, return false.
 * 	4.	Finally, check if the stack is empty.
 * 	•	If empty → All brackets were properly matched (true).
 * 	•	If not empty → Unmatched opening brackets remain (false).
 * 	 Complexity Analysis:
 * 	 •	Time complexity: O(n), where n is the length of the input string.
 * 	•	Space complexity: O(n), where n is the length of the input string.
 */