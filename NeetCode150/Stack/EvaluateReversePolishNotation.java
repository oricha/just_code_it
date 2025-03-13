/**
 * Evaluate Reverse Polish Notation
 * You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
 *
 * Return the integer that represents the evaluation of the expression.
 *
 * The operands may be integers or the results of other operations.
 * The operators include '+', '-', '*', and '/'.
 * Assume that division between integers always truncates toward zero.
 * Example 1:
 *
 * Input: tokens = ["1","2","+","3","*","4","-"]
 *
 * Output: 5
 *
 * Explanation: ((1 + 2) * 3) - 4 = 5
 * Constraints:
 *
 * 1 <= tokens.length <= 1000.
 * tokens[i] is "+", "-", "*", or "/", or a string representing an integer in the range [-100, 100].
 */

import java.util.*;

/**
 * Evaluate Reverse Polish Notation (RPN)
 * Given an array of strings representing a valid arithmetic expression in Reverse Polish Notation,
 * return the evaluated result.
 *
 * Example 1:
 * Input: tokens = ["1","2","+","3","*","4","-"]
 * Output: 5
 * Explanation: ((1 + 2) * 3) - 4 = 5
 */

class EvaluateReversePolishNotation {
    /**
     * Evaluates an expression given in Reverse Polish Notation.
     *
     * @param tokens The array of strings representing the RPN expression.
     * @return The evaluated integer result.
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                // Pop the last two elements from the stack
                int b = stack.pop();
                int a = stack.pop();

                // Perform the operation and push the result back
                stack.push(applyOperation(a, b, token));
            } else {
                // Push numbers onto the stack
                stack.push(Integer.parseInt(token));
            }
        }

        // The final result is the only value left in the stack
        return stack.pop();
    }

    /**
     * Checks if a given string is an operator.
     */
    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    /**
     * Applies the operation on two numbers.
     */
    private int applyOperation(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Integer division (truncates toward zero)
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

        // Example 1
        String[] tokens1 = {"1", "2", "+", "3", "*", "4", "-"};
        System.out.println(solution.evalRPN(tokens1)); // Output: 5

        // Example 2
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(solution.evalRPN(tokens2)); // Output: 6 (4 + (13 / 5) = 6)

        // Example 3
        String[] tokens3 = {"2", "1", "+", "3", "*"};
        System.out.println(solution.evalRPN(tokens3)); // Output: 9

        // Example 4
        String[] tokens4 = {"10", "6", "9", "3", "/", "+", "-11", "*", "*", "17", "+", "5", "+"};
        System.out.println(solution.evalRPN(tokens4)); // Output: 22
    }
}
/**
 * Explanation of the Solution
 * 	1.	Use a Stack (Stack<Integer>) to store numbers and intermediate results.
 * 	2.	Iterate through tokens:
 * 	•	If it’s a number, push it onto the stack.
 * 	•	If it’s an operator, pop two numbers from the stack, apply the operation, and push the result back.
 * 	3.	At the end, the stack contains a single number, which is the final result.
 *
 *
 * Time & Space Complexity:
 * 	•	Time Complexity: O(n), where n is the number of tokens in the expression.
 * 	•	Space Complexity: O(n), where n is the number of tokens in the expression.
 *
 */