/**
 * Binary Search
 * You are given an array of distinct integers nums, sorted in ascending order, and an integer target.
 * Implement a function to search for target within nums. If it exists, then return its index, otherwise, return -1.
 * Your solution must run inO(logn) time.
 * Example 1:
 * Input: nums = [-1,0,2,4,6,8], target = 4
 * Output: 3
 * Example 2:
 *
 * Input: nums = [-1,0,2,4,6,8], target = 3
 *
 * Output: -1
 * Constraints:
 *
 * 1 <= nums.length <= 10000.
 * -10000 < nums[i], target < 10000
 */

class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // Set search range from first to last index

        while (left <= right) { // Continue searching while the range is valid
            int mid = left + (right - left) / 2; // Find the middle index (avoid overflow)

            if (nums[mid] == target) return mid; // Found the target, return its index
            else if (nums[mid] < target) left = mid + 1; // Search in the right half
            else right = mid - 1; // Search in the left half
        }
        return -1; // Target not found
    }
}

/**
 * Explanation of the Code
 *  1.  The binary search algorithm is implemented to find the target element in the sorted array.
 *  2.  The left and right pointers are initialized to the first and last index of the array, respectively.
 *  3.  The binary search loop continues until the left pointer is less than or equal to the right pointer.
 *  4.  The middle index is calculated as the average of the left and right pointers, rounded down.
 *  5.  If the middle element is equal to the target, return its index.
 *  6.  If the middle element is less than the target, set the left pointer to the middle index + 1.
 *  7.  Otherwise, set the right pointer to the middle index - 1.
 *  8.  Return -1 if the target is not found in the array.
 */