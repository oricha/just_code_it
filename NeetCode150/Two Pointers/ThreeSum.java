/**
 * 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.
 *
 * The output should not contain any duplicate triplets. You may return the output and the triplets in any order.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 *
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 *
 * Example 2:
 *
 * Input: nums = [0,1,1]
 *
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 *
 * Example 3:
 *
 * Input: nums = [0,0,0]
 *
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 * Constraints:
 *
 * 3 <= nums.length <= 1000
 * -10^5 <= nums[i] <= 10^5
 */
import java.util.*;

/**
 * 3Sum Problem:
 * Given an integer array nums, return all unique triplets [nums[i], nums[j], nums[k]]
 * such that nums[i] + nums[j] + nums[k] == 0, where i, j, and k are distinct.
 * The solution should not contain duplicate triplets.
 */
class ThreeSum {
    /**
     * Finds all unique triplets that sum up to zero.
     *
     * @param nums The input array of integers.
     * @return A list of lists containing unique triplets.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array to enable two-pointer traversal
        Arrays.sort(nums);

        // Step 2: Iterate through the array with a fixed first element
        for (int i = 0; i < nums.length - 2; i++) {
            // Avoid duplicate solutions by skipping repeated elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Two-pointer approach for the remaining two numbers
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move both pointers to the next different number to avoid duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Increase left pointer to increase sum
                } else {
                    right--; // Decrease right pointer to decrease sum
                }
            }
        }
        return result;
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        // Example 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums1)); // Output: [[-1, -1, 2], [-1, 0, 1]]

        // Example 2
        int[] nums2 = {0, 1, 1};
        System.out.println(solution.threeSum(nums2)); // Output: []

        // Example 3
        int[] nums3 = {0, 0, 0};
        System.out.println(solution.threeSum(nums3)); // Output: [[0, 0, 0]]
    }
}

/**
 * Explanation of the Solution
 * 	1.	Sort the array → Sorting makes it easier to avoid duplicates and efficiently find triplets.
 * 	2.	Iterate through the array, fixing one element (nums[i]).
 * 	•	Use a two-pointer approach (left and right) to find the other two numbers.
 * 	•	Ensure no duplicate solutions by skipping repeated elements.
 * 	3.	Adjust pointers based on sum:
 * 	•	If sum == 0, add triplet to result.
 * 	•	If sum < 0, move left pointer forward to increase sum.
 * 	•	If sum > 0, move right pointer backward to decrease sum.
 * 	4.	Return result.
 * 	Complexity Analysis:
 * 	•	Time complexity: O(n^2), where n is the length of the input array.
 * 	•	Space complexity: O(n), where n is the length of the result list.
 */