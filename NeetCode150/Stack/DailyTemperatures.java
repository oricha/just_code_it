/**
 * Daily Temperatures
 * You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.
 * Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a future day. If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0 instead.
 * Example 1:
 *
 * Input: temperatures = [30,38,30,36,35,40,28]
 * Output: [1,4,1,2,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [22,21,20]
 *
 * Output: [0,0,0]
 * Constraints:
 *
 * 1 <= temperatures.length <= 1000.
 * 1 <= temperatures[i] <= 100
 */

import java.util.Stack;

/**
 * Daily Temperatures
 * Given an array temperatures[], return an array result[] where:
 * - result[i] = number of days after day `i` until a warmer temperature appears.
 * - If no warmer day exists, result[i] = 0.
 *
 * Example 1:
 * Input: temperatures = [30,38,30,36,35,40,28]
 * Output: [1,4,1,2,1,0,0]
 *
 * Example 2:
 * Input: temperatures = [22,21,20]
 * Output: [0,0,0]
 */

class DailyTemperatures {
    /**
     * Computes the number of days to wait for a warmer temperature.
     *
     * @param temperatures The array of daily temperatures.
     * @return An array where result[i] is the number of days to wait for a warmer temperature.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n]; // Output array initialized to 0s
        Stack<Integer> stack = new Stack<>(); // Monotonic decreasing stack storing indices

        // Traverse the temperatures array
        for (int i = 0; i < n; i++) {
            // Check if the current temperature is greater than the temperature at stack's top
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop(); // Get the index of the previous cooler day
                result[prevIndex] = i - prevIndex; // Compute the difference in days
            }
            stack.push(i); // Store the index of the current day
        }

        return result;
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();

        // Example 1
        int[] temperatures1 = {30, 38, 30, 36, 35, 40, 28};
        System.out.println(java.util.Arrays.toString(solution.dailyTemperatures(temperatures1)));
        // Output: [1,4,1,2,1,0,0]

        // Example 2
        int[] temperatures2 = {22, 21, 20};
        System.out.println(java.util.Arrays.toString(solution.dailyTemperatures(temperatures2)));
        // Output: [0,0,0]

        // Example 3
        int[] temperatures3 = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(java.util.Arrays.toString(solution.dailyTemperatures(temperatures3)));
        // Output: [1,1,4,2,1,1,0,0]
    }
}

/**
 * Explanation of the Solution
 * 	1.	Use a Monotonic Stack (Stack<Integer>) to store indices of temperatures.
 * 	•	The stack stores indices of days where the temperature has not yet found a warmer day.
 * 	•	The stack is always decreasing (i.e., top of the stack holds the most recent cooler temperature index).
 * 	2.	Iterate over the temperatures[] array:
 * 	•	If temperatures[i] is warmer than temperatures[stack.peek()]:
 * 	•	Pop from the stack.
 * 	•	Calculate the difference (i - prevIndex), store it in result[prevIndex].
 * 	•	Push i onto the stack.
 * 	3.	Unprocessed elements in the stack have no warmer day in the future.
 * 	•	The result[] array is initialized with 0s, so no need for extra handling.
 * 	4.	Return the result[] array.
 *
 * Time & Space Complexity:
 * 	•	Time Complexity: O(n), where n is the number of temperatures.
 * 	•	Space Complexity: O(n), where n is the number of temperatures.
 */