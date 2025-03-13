/**
 * Subsets
 * Given an array nums of unique integers, return all possible subsets of nums.
 * The solution set must not contain duplicate subsets. You may return the solution in any order.
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * Input: nums = [7]
 * Output: [[],[7]]
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int n = result.size();
            for (int i = 0; i < n; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }
        return result;
    }
}

/**
 * Explanation of the Solution
 *  1.	Create an empty list to store the subsets.
 *  2.	Add an empty subset to the result.
 *  3.	Iterate through the input array.
 *  4.	Create a new list to store the current subset.
 *  5.	Iterate through the existing subsets.
 *  6.	Add the current number to the current subset.
 *  7.	Add the current subset to the result.
 *  8.	Return the result.
 *  Complexity Analysis:
 *  •	Time complexity: O(2^n), where n is the length of the input array.
 *  •	Space complexity: O(n), where n is the length of the input array.
 */