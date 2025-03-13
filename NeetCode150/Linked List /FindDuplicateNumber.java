/**
 * Find the Duplicate Number
 * You are given an array of integers nums containing n + 1 integers. Each integer in nums is in the range [1, n] inclusive.
 *
 * Every integer appears exactly once, except for one integer which appears two or more times. Return the integer that appears more than once.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,2,2]
 *
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3,4,4]
 *
 * Output: 4
 * Follow-up: Can you solve the problem without modifying the array nums and using
 * O
 * (
 * 1
 * )
 * O(1) extra space?
 *
 * Constraints:
 *
 * 1 <= n <= 10000
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 */
/**
 * Find the Duplicate Number
 * Given an array `nums` containing `n+1` integers, where each integer is in the range `[1, n]` and
 * exactly one integer appears more than once, find the duplicate without modifying the array.
 *
 * Example 1:
 * Input: nums = [1,2,3,2,2]
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,2,3,4,4]
 * Output: 4
 *
 * Constraints:
 * - 1 <= n <= 10000
 * - nums.length == n + 1
 * - 1 <= nums[i] <= n
 */

class FindDuplicateNumber {
    /**
     * Uses Floyd's Cycle Detection Algorithm to find the duplicate number in O(n) time and O(1) space.
     *
     * @param nums The input array containing `n+1` integers in range `[1, n]`.
     * @return The duplicated integer.
     */
    public int findDuplicate(int[] nums) {
        // Step 1: Detect the cycle (Tortoise and Hare approach)
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];        // Move slow pointer by 1 step
            fast = nums[nums[fast]];  // Move fast pointer by 2 steps
        } while (slow != fast);       // Loop until a cycle is detected

        // Step 2: Find the entrance of the cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // The duplicate number
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        FindDuplicateNumber solution = new FindDuplicateNumber();

        // Example 1: [1,2,3,2,2] -> Output: 2
        int[] nums1 = {1, 2, 3, 2, 2};
        System.out.println(solution.findDuplicate(nums1)); // Output: 2

        // Example 2: [1,2,3,4,4] -> Output: 4
        int[] nums2 = {1, 2, 3, 4, 4};
        System.out.println(solution.findDuplicate(nums2)); // Output: 4

        // Example 3: [3,1,3,4,2] -> Output: 3
        int[] nums3 = {3, 1, 3, 4, 2};
        System.out.println(solution.findDuplicate(nums3)); // Output: 3
    }
}

/**
 *
 */