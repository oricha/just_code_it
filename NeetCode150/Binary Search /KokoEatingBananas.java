/**
 * Koko Eating Bananas
 * You are given an integer array piles where piles[i] is the number of bananas in the ith pile. You are also given an integer h, which represents the number of hours you have to eat all the bananas.
 *
 * You may decide your bananas-per-hour eating rate of k. Each hour, you may choose a pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, you may finish eating the pile but you can not eat from another pile in the same hour.
 *
 * Return the minimum integer k such that you can eat all the bananas within h hours.
 *
 * Example 1:
 *
 * Input: piles = [1,4,3,2], h = 9
 *
 * Output: 2
 * Explanation: With an eating rate of 2, you can eat the bananas in 6 hours. With an eating rate of 1, you would need 10 hours to eat all the bananas (which exceeds h=9), thus the minimum eating rate is 2.
 *
 * Example 2:
 *
 * Input: piles = [25,10,23,4], h = 4
 *
 * Output: 25
 * Constraints:
 *
 * 1 <= piles.length <= 1,000
 * piles.length <= h <= 1,000,000
 * 1 <= piles[i] <= 1,000,000,000
 */
import java.util.Arrays;

/**
 * Koko Eating Bananas
 * Given an array `piles[]` where `piles[i]` represents the number of bananas in the i-th pile
 * and an integer `h` (number of hours available), return the **minimum integer `k`** (bananas per hour)
 * so that Koko can eat all the bananas in `h` hours.
 *
 * Example 1:
 * Input: piles = [1,4,3,2], h = 9
 * Output: 2
 *
 * Example 2:
 * Input: piles = [25,10,23,4], h = 4
 * Output: 25
 */

class KokoEatingBananas {
    /**
     * Finds the minimum eating speed `k` such that Koko can finish eating within `h` hours.
     *
     * @param piles The array representing banana piles.
     * @param h The number of hours available.
     * @return The minimum eating speed required.
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum speed (1 banana per hour)
        int right = Arrays.stream(piles).max().getAsInt(); // Maximum speed (largest pile)

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                right = mid; // Try a smaller `k`
            } else {
                left = mid + 1; // Increase `k`
            }
        }
        return left;
    }

    /**
     * Helper function to check if Koko can eat all bananas at speed `k` within `h` hours.
     */
    private boolean canFinish(int[] piles, int h, int k) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += (pile + k - 1) / k; // Equivalent to `Math.ceil(pile / k)`
        }
        return hoursNeeded <= h;
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        KokoEatingBananas solution = new KokoEatingBananas();

        // Example 1
        int[] piles1 = {1, 4, 3, 2};
        int h1 = 9;
        System.out.println(solution.minEatingSpeed(piles1, h1)); // Output: 2

        // Example 2
        int[] piles2 = {25, 10, 23, 4};
        int h2 = 4;
        System.out.println(solution.minEatingSpeed(piles2, h2)); // Output: 25

        // Example 3
        int[] piles3 = {3, 6, 7, 11};
        int h3 = 8;
        System.out.println(solution.minEatingSpeed(piles3, h3)); // Output: 4
    }
}

/**
 * Explanation of the Solution
 * 	1.	Use Binary Search to Find the Minimum Speed (k)
 * 	•	The minimum possible eating speed is 1 banana per hour.
 * 	•	The maximum possible speed is the largest pile (eating all in one hour).
 * 	•	Perform binary search to minimize k.
 * 	2.	Check Feasibility with a Helper Function (canFinish)
 * 	•	Compute total hours required for a given k:
 * 	hoursNeeded += Math.ceil(pile / k)
 * 	•	If total hoursNeeded <= h, reduce k (try a smaller speed).
 * 	•	Otherwise, increase k to eat faster.
 *
 * 	3.	Stop When Left Pointer Converges
 * 	•	Binary search ensures we reach the smallest feasible k.
 * 	Complexity Analysis:
 * 	•	Time complexity: O(log(max(piles)))
 * 	•	Space complexity: O(1)
 */