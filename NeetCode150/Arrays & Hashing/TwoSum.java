/**
 * Two Sum
 * Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
 *
 * You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
 *
 * Return the answer with the smaller index first.
 *
 * Example 1:
 *
 * Input:
 * nums = [3,4,5,6], target = 7
 *
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] == 7, so we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [4,5,6], target = 10
 *
 * Output: [0,2]
 * Example 3:
 *
 * Input: nums = [5,5], target = 10
 *
 * Output: [0,1]
 * Constraints:
 *
 * 2 <= nums.length <= 1000
 * -10,000,000 <= nums[i] <= 10,000,000
 * -10,000,000 <= target <= 10,000,000
 */

class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array of numbers.
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement needed to reach the target.
            int complement = target - nums[i];

            // Check if the complement exists in the HashMap.
            if (map.containsKey(complement)) {
                // If found, return the indices of the current number and its complement.
                return new int[] {map.get(complement), i};
            }

            // Store the current number as the key and its index as the value.
            map.put(nums[i], i);
        }

        // If no solution is found, return an empty array.
        return new int[0];
    }

}

/**
 * Explanation of the Solution:
 * 	1.	Create a HashMap<Integer, Integer> map to store the numbers and their indices.
 * 	2.	Iterate through the array of numbers.
 * 	3.	Calculate the complement needed to reach the target.
 * 	4.	Check if the complement exists in the HashMap.
 * 	5.	If found, return the indices of the current number and its complement.
 * 	6.	Store the current number as the key and its index as the value.
 * 	7.	If no solution is found, return an empty array.
 * 	Complexity Analysis:
 * 	•	Time complexity: O(n), where n is the number of elements in the input array.
 * 	•	Space complexity: O(n), where n is the number of unique elements in the input array.
 *  Complexity Analysis:
 * 	•	Time complexity: O(n), where n is the number of elements in the input array.
 * 	•	Space complexity: O(n), where n is the number of unique elements in the input array.
 */