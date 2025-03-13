/**
 * Contains Duplicate
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [1, 2, 3, 3]
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1, 2, 3, 4]
 *
 * Output: false
 */
class ContainsDuplicate {
    /**
     * Checks if an array contains duplicate elements.
     *
     * @param nums The input array of integers.
     * @return true if any value appears more than once, otherwise false.
     */
    public boolean containsDuplicate(int[] nums) {
        // Use a HashSet to store unique numbers encountered in the array
        Set<Integer> set = new HashSet<>();

        // Iterate over each number in the input array
        for (int num : nums) {
            // If the number is already in the set, a duplicate exists, return true
            if (set.contains(num)) return true;

            // Add the number to the set for future checks
            set.add(num);
        }

        // If no duplicates were found, return false
        return false;
    }
}

/**
 * Explanation:
 * 	1.	Uses a HashSet<Integer> → The HashSet is chosen because it allows O(1) average time complexity for insertions and lookups.
 * 	2.	Iterates through nums array → For each integer:
 * 	•	Checks if the number is already in the set (indicating a duplicate).
 * 	•	If found, returns true immediately.
 * 	•	Otherwise, adds the number to the set for tracking.
 * 	3.	Returns false if no duplicates are found after scanning the entire array.
 *
 * Time & Space Complexity:
 * 	•	Time Complexity: O(n), since we traverse the array once.
 * 	•	Space Complexity: O(n), since we store up to n unique elements in the HashSet.
 *
 * This is an efficient solution for detecting duplicates in an array using a set-based approach. 🚀
 *
 */