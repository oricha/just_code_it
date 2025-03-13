/**
 * Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements within the array.
 *
 * The test cases are generated such that the answer is always unique.
 *
 * You may return the output in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,3,3], k = 2
 *
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [7,7], k = 1
 *
 * Output: [7]
 * Constraints:
 *
 * 1 <= nums.length <= 10^4.
 * -1000 <= nums[i] <= 1000
 * 1 <= k <= number of distinct elements in nums.
 */
import java.util.*;

/**
 * Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements within the array.
 *
 * Example 1:
 * Input: nums = [1,2,2,3,3,3], k = 2
 * Output: [2,3]
 *
 * Example 2:
 * Input: nums = [7,7], k = 1
 * Output: [7]
 */
class TopKFrequentElements {
    /**
     * Finds the k most frequent elements in the array.
     *
     * @param nums Array of integers.
     * @param k Number of top frequent elements to return.
     * @return Array of k most frequent elements.
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each number using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a Min-Heap (PriorityQueue) to keep track of top k frequent elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(frequencyMap.get(a), frequencyMap.get(b))
        );

        // Step 3: Maintain only k elements in the heap
        for (int num : frequencyMap.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }

        // Step 4: Extract k elements from the heap into the result array
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();

        // Example 1
        int[] nums1 = {1, 2, 2, 3, 3, 3};
        System.out.println(Arrays.toString(solution.topKFrequent(nums1, 2))); // Output: [2,3]

        // Example 2
        int[] nums2 = {7, 7};
        System.out.println(Arrays.toString(solution.topKFrequent(nums2, 1))); // Output: [7]
    }
}

/**
 * Explanation of the Solution
 * 	1.	Count the frequency of each number
 * 	•	We use a HashMap<Integer, Integer>, where:
 * 	•	Key = unique number.
 * 	•	Value = frequency count of that number.
 * 	2.	Use a Min-Heap (PriorityQueue) to track the top k frequent elements
 * 	•	The heap maintains the k most frequent elements.
 * 	•	It orders elements based on frequency (ascending order).
 * 	•	When the heap exceeds size k, we remove the least frequent element.
 * 	3.	Extract elements from the heap into the result array
 * 	•	Since the heap stores the most frequent elements, we retrieve them in descending order.
 * 	•	Starting from the last element, we add them to the result array.
 * 	4.	Return the result array containing the top k frequent elements.
 *
 * Time & Space Complexity:
 * 	•	Time Complexity: O(n + k log k), where n is the size of the input array and k is the number of top frequent elements.
 * 	•	Space Complexity: O(n), where n is the size of the input array.
 */