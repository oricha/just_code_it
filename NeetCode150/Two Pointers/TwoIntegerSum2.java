/**
 * Two Integer Sum II
 * Given an array of integers numbers that is sorted in non-decreasing order.
 *
 * Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.
 *
 * There will always be exactly one valid solution.
 *
 * Your solution must use
 * O
 * (
 * 1
 * )
 * O(1) additional space.
 *
 * Example 1:
 *
 * Input: numbers = [1,2,3,4], target = 3
 *
 * Output: [1,2]
 * Explanation:
 * The sum of 1 and 2 is 3. Since we are assuming a 1-indexed array, index1 = 1, index2 = 2. We return [1, 2].
 *
 * Constraints:
 *
 * 2 <= numbers.length <= 1000
 * -1000 <= numbers[i] <= 1000
 * -1000 <= target <= 1000
 */

/**
 * Two Integer Sum II
 * Given an array of integers sorted in non-decreasing order,
 * return the indices (1-indexed) of two numbers that add up to a given target.
 * The solution must use O(1) additional space.
 *
 * Example 1:
 * Input: numbers = [1,2,3,4], target = 3
 * Output: [1,2]
 * Explanation: The sum of 1 and 2 is 3. Since we use a 1-indexed array, index1 = 1, index2 = 2.
 */

class TwoIntegerSum2 {
    /**
     * Finds two numbers that add up to the target using the two-pointer technique.
     *
     * @param numbers Sorted integer array (1-indexed).
     * @param target Target sum.
     * @return An array containing the two indices [index1, index2].
     */
    public int[] twoSum(int[] numbers, int target) {
        // Initialize two pointers: one at the start, one at the end of the array
        int left = 0, right = numbers.length - 1;

        // Iterate until the two pointers meet
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Convert to 1-based index and return result
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++; // Move left pointer forward to increase the sum
            } else {
                right--; // Move right pointer backward to decrease the sum
            }
        }

        // The problem guarantees exactly one solution, so we should never reach this point.
        return new int[]{-1, -1};
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        TwoIntegerSum2 solution = new TwoIntegerSum2();

        // Example 1
        int[] numbers1 = {1, 2, 3, 4};
        int target1 = 3;
        System.out.println(Arrays.toString(solution.twoSum(numbers1, target1))); // Output: [1, 2]

        // Example 2
        int[] numbers2 = {-3, -1, 1, 2, 5};
        int target2 = 1;
        System.out.println(Arrays.toString(solution.twoSum(numbers2, target2))); // Output: [2, 4]

        // Example 3
        int[] numbers3 = {1, 5, 7, 10, 12, 15};
        int target3 = 17;
        System.out.println(Arrays.toString(solution.twoSum(numbers3, target3))); // Output: [2, 5]
    }
}
/**
 *
 */