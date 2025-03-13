/**
 * Generate Parentheses
 * You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.
 *
 * Example 1:
 *
 * Input: n = 1
 *
 * Output: ["()"]
 * Example 2:
 *
 * Input: n = 3
 *
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * You may return the answer in any order.
 *
 * Constraints:
 *
 * 1 <= n <= 7
 */

import java.util.*;

/**
 * Generate Parentheses
 * Given an integer `n`, return all well-formed parentheses strings that can be generated with `n` pairs.
 *
 * Example 1:
 * Input: n = 1
 * Output: ["()"]
 *
 * Example 2:
 * Input: n = 3
 * Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
 */

class GenerateParentheses {
    /**
     * Generates all valid parentheses combinations using backtracking.
     *
     * @param n The number of pairs of parentheses.
     * @return A list of all valid parentheses strings.
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    /**
     * Backtracking helper function to generate valid parentheses.
     *
     * @param result The list storing valid parentheses combinations.
     * @param current The current string being built.
     * @param open The count of open parentheses used.
     * @param close The count of close parentheses used.
     * @param max The total number of pairs.
     */
    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base case: When the string reaches the max length (2 * n), add to the result
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Add an open parenthesis if we have not used all `n` open brackets
        if (open < max) {
            current.append("(");
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // Undo change (backtrack)
        }

        // Add a close parenthesis if the number of open brackets is greater than close
        if (close < open) {
            current.append(")");
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // Undo change (backtrack)
        }
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();

        // Example 1
        int n1 = 1;
        System.out.println(solution.generateParenthesis(n1)); // Output: ["()"]

        // Example 2
        int n2 = 3;
        System.out.println(solution.generateParenthesis(n2)); // Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
    }
}

/**
 * Explanation of the Solution
 * 	1.	Use Backtracking (Recursive DFS)
 * 	•	Build valid parenthesis strings incrementally.
 * 	•	If open < n, add "(" (more open brackets are available).
 * 	•	If close < open, add ")" (a valid closing bracket is possible).
 * 	•	Stop recursion when the string length reaches 2 * n.
 * 	2.	Use a StringBuilder for Efficiency
 * 	•	Since String is immutable, using StringBuilder prevents unnecessary object creation.
 * 	•	The backtrack function undoes the last character (deleteCharAt) after recursion.
 * 	3.	Store Results in a List
 * 	•	When a valid combination is formed (length == 2 * n), add it to result.
 * 	 Complexity Analysis:
 * 	 •	Time complexity: O(2^n), where n is the number of pairs of parentheses.
 * 	•	Space complexity: O(n), where n is the number of pairs of parentheses.
 *
 */