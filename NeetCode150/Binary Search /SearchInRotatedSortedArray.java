/**
 *Search in Rotated Sorted Array
 * You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:
 *
 * [3,4,5,6,1,2] if it was rotated 4 times.
 * [1,2,3,4,5,6] if it was rotated 6 times.
 * Given the rotated sorted array nums and an integer target, return the index of target within nums, or -1 if it is not present.
 *
 * You may assume all elements in the sorted rotated array nums are unique,
 *
 * A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time?
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,6,1,2], target = 1
 *
 * Output: 4
 * Example 2:
 *
 * Input: nums = [3,5,6,0,1,2], target = 4
 *
 * Output: -1
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -1000 <= target <= 1000
 */

/**
 * Search in Rotated Sorted Array
 * Given a sorted array that has been rotated, find the index of `target` in `O(log n)`.
 *
 * Example 1:
 * Input: nums = [3,4,5,6,1,2], target = 1
 * Output: 4
 *
 * Example 2:
 * Input: nums = [3,5,6,0,1,2], target = 4
 * Output: -1
 */

class SearchInRotatedSortedArray {
    /**
     * Searches for the target in a rotated sorted array using binary search.
     *
     * @param nums   The rotated sorted array.
     * @param target The value to find.
     * @return The index of the target, or -1 if not found.
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If we found the target, return its index
            if (nums[mid] == target) return mid;

            // Determine which half is sorted
            if (nums[left] <= nums[mid]) { // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search in left half
                } else {
                    left = mid + 1; // Search in right half
                }
            } else { // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search in right half
                } else {
                    right = mid - 1; // Search in left half
                }
            }
        }

        return -1; // Target not found
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();

        // Example 1
        int[] nums1 = {3, 4, 5, 6, 1, 2};
        int target1 = 1;
        System.out.println(solution.search(nums1, target1)); // Output: 4

        // Example 2
        int[] nums2 = {3, 5, 6, 0, 1, 2};
        int target2 = 4;
        System.out.println(solution.search(nums2, target2)); // Output: -1

        // Example 3
        int[] nums3 = {4, 5, 6, 7, 0, 1, 2};
        int target3 = 6;
        System.out.println(solution.search(nums3, target3)); // Output: 2
    }
}

/**
 * Explanation of the Solution
 * 	1.	Use Binary Search (O(log n))
 * 	•	Left Pointer (left): Starts at 0.
 * 	•	Right Pointer (right): Starts at nums.length - 1.
 * 	•	Midpoint Calculation: mid = left + (right - left) / 2.
 * 	2.	Key Observations:
 * 	•	If nums[mid] == target, return mid.
 * 	•	Determine if the left half is sorted (nums[left] <= nums[mid]).
 * 	•	If target is within the left half, search left (right = mid - 1).
 * 	•	Otherwise, search right (left = mid + 1).
 * 	•	Otherwise, the right half is sorted.
 * 	•	If target is within the right half, search right (left = mid + 1).
 * 	•	Otherwise, search left (right = mid - 1).
 * 	3.	Stop when left > right
 * 	•	If target is not found, return -1.
 * 	Complexity Analysis:
 * 	•	Time complexity: O(log n)
 * 	•	Space complexity: O(1)
 */