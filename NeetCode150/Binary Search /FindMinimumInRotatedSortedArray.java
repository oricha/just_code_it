/**
 * Find Minimum in Rotated Sorted Array
 * You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:
 *
 * [3,4,5,6,1,2] if it was rotated 4 times.
 * [1,2,3,4,5,6] if it was rotated 6 times.
 * Notice that rotating the array 4 times moves the last four elements of the array to the beginning. Rotating the array 6 times produces the original array.
 *
 * Assuming all elements in the rotated sorted array nums are unique, return the minimum element of this array.
 *
 * A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time?
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,6,1,2]
 *
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,5,0,1,2,3]
 *
 * Output: 0
 * Example 3:
 *
 * Input: nums = [4,5,6,7]
 *
 * Output: 4
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 */

/**
 * Find Minimum in Rotated Sorted Array
 * Given a sorted array that has been rotated, find the minimum element in `O(log n)`.
 *
 * Example 1:
 * Input: nums = [3,4,5,6,1,2]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,5,0,1,2,3]
 * Output: 0
 *
 * Example 3:
 * Input: nums = [4,5,6,7]
 * Output: 4
 */

class FindMinimumInRotatedSortedArray {
    /**
     * Finds the minimum element in a rotated sorted array using binary search.
     *
     * @param nums The rotated sorted array.
     * @return The minimum element.
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid is greater than right, minimum is on the right side
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, minimum is either mid or on the left side
                right = mid;
            }
        }

        return nums[left]; // Left points to the minimum element
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray solution = new FindMinimumInRotatedSortedArray();

        // Example 1
        int[] nums1 = {3, 4, 5, 6, 1, 2};
        System.out.println(solution.findMin(nums1)); // Output: 1

        // Example 2
        int[] nums2 = {4, 5, 0, 1, 2, 3};
        System.out.println(solution.findMin(nums2)); // Output: 0

        // Example 3
        int[] nums3 = {4, 5, 6, 7};
        System.out.println(solution.findMin(nums3)); // Output: 4
    }
}

/**
 * Explanation of the Solution
 * 	1.	Use Binary Search (O(log n))
 * 	•	Left Pointer (left): Starts at 0.
 * 	•	Right Pointer (right): Starts at nums.length - 1.
 * 	•	Midpoint Calculation: mid = left + (right - left) / 2.
 * 	2.	Key Observations:
 * 	•	If nums[mid] > nums[right], the minimum is in the right half, move left = mid + 1.
 * 	•	Else, the minimum is in the left half (including mid), move right = mid.
 * 	3.	Stop when left == right
 * 	•	left will point to the minimum element.
 * 	Complexity Analysis:
 * 	•	Time complexity: O(log n)
 * 	•	Space complexity: O(1)
 */