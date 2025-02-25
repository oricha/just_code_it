/**
 * 121. Best Time to Buy and Sell Stock
 * Easy
 * Topics
 * Companies
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * ⏱️ Time Complexity:
 * 	•	O(n): We go through the prices array once, making it efficient even for large inputs.
 *
 * 🛠️ Space Complexity:
 * 	•	O(1): Only two variables (min and max) are used.
 */

public class BestTimeToSell {
    public int maxProfit(int[] prices) {
        // Initialize the minimum price to the highest possible value.
        // This ensures any stock price encountered will be smaller initially.
        int min = Integer.MAX_VALUE;

        // Initialize the maximum profit to zero, assuming no profit initially.
        int max = 0;

        // Iterate through each day's stock price.
        for (int i = 0; i < prices.length; i++) {
            // Update the minimum price if the current price is lower.
            // This represents the best day to buy so far.
            min = Math.min(min, prices[i]);

            // Calculate the potential profit if selling on the current day.
            // Compare it with the previous maximum profit and update if it's higher.
            max = Math.max(max, prices[i] - min);
        }

        // Return the maximum profit found.
        // If no profit is possible, it returns 0 by default.
        return max;
    }
}