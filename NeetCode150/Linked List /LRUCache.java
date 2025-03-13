/**
 * LRU Cache
 * Implement the Least Recently Used (LRU) cache class LRUCache. The class should support the following operations
 *
 * LRUCache(int capacity) Initialize the LRU cache of size capacity.
 * int get(int key) Return the value corresponding to the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the introduction of the new pair causes the cache to exceed its capacity, remove the least recently used key.
 * A key is considered used if a get or a put operation is called on it.
 * Ensure that get and put each run in
 * O(1)
 * O(1) average time complexity.
 * Example 1:
 * Input:
 * ["LRUCache", [2], "put", [1, 10],  "get", [1], "put", [2, 20], "put", [3, 30], "get", [2], "get", [1]]
 *
 * Output:
 * [null, null, 10, null, null, 20, -1]
 * Explanation:
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 10);  // cache: {1=10}
 * lRUCache.get(1);      // return 10
 * lRUCache.put(2, 20);  // cache: {1=10, 2=20}
 * lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
 * lRUCache.get(2);      // returns 20
 * lRUCache.get(1);      // return -1 (not found)
 * Constraints:
 *
 * 1 <= capacity <= 100
 * 0 <= key <= 1000
 * 0 <= value <= 1000
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
 * Explanation of the Solution
 * 	1.	Use Floyd’s Cycle Detection Algorithm (O(n))
 * 	•	Treat the array as a linked list, where nums[i] points to nums[nums[i]].
 * 	•	Since n+1 elements are mapped to n distinct values, a cycle must exist.
 * 	•	Use Tortoise and Hare method to find the intersection point.
 * 	2.	Find the Entrance of the Cycle (O(n))
 * 	•	Reset slow to the start of the list.
 * 	•	Move both slow and fast one step at a time until they meet again.
 * 	•	The meeting point is the duplicate number.
 * 	Complexity Analysis:
 * 	•	Time complexity: O(n)
 * 	•	Space complexity: O(1)
 */