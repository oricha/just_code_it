/**
 * Container With Most Water
 * You are given an integer array heights where heights[i] represents the height of the
 * i-th bar of a bar chart. A bar chart is a vertical chart filled horizontally by bars of different heights. The base of the bars is at the ground and the height of each bar is the height of the barth
 *   bar.
 * You may choose any two bars to form a container. Return the maximum amount of water a container can store.
 * Example 1:
 * Input: height = [1,7,2,5,4,7,3,6]
 *
 * Output: 36
 * Example 2:
 *
 * Input: height = [2,2,2]
 *
 * Output: 4
 * Constraints:
 *
 * 2 <= height.length <= 1000
 * 0 <= height[i] <= 1000
 */
/**
 * Container With Most Water
 * Given an integer array `height` where `height[i]` represents the height of the i-th bar,
 * find the two bars that can form a container with the maximum possible area.
 *
 * Example 1:
 * Input: height = [1,7,2,5,4,7,3,6]
 * Output: 36
 *
 * Example 2:
 * Input: height = [2,2,2]
 * Output: 4
 */

class ContainerMostWater {
    /**
     * Finds the maximum water that can be contained.
     *
     * @param height Array representing the heights of vertical bars.
     * @return Maximum water that can be contained.
     */
    public int maxArea(int[] height) {
        // Initialize two pointers: left at start, right at end of array
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        // Use the two-pointer technique to find the maximum water container
        while (left < right) {
            // Calculate the area with the current left and right pointers
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int currentArea = minHeight * width;

            // Update maxArea if a larger area is found
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter height to try and find a larger container
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        ContainerMostWater solution = new ContainerMostWater();

        // Example 1
        int[] heights1 = {1, 7, 2, 5, 4, 7, 3, 6};
        System.out.println(solution.maxArea(heights1)); // Output: 36

        // Example 2
        int[] heights2 = {2, 2, 2};
        System.out.println(solution.maxArea(heights2)); // Output: 4
    }
}

/**
 * Explanation of the Solution
 * 	1.	Initialize Two Pointers:
 * 	•	left starts at the beginning (index 0).
 * 	•	right starts at the end (last index).
 * 	•	maxArea stores the maximum found area.
 * 	2.	Calculate Water Container Area at Each Step:
 * 	•	Area is given by: min(height[left], height[right]) * (right - left)
 * 	•	The width is (right - left).
 * 	•	The height is determined by the shorter of the two bars (to prevent overflow).
 *
 * 	3.	Move the Pointer of the Shorter Height:
 * 	•	If height[left] < height[right], move left forward.
 * 	•	Otherwise, move right backward.
 * 	•	This helps maximize potential area by keeping taller bars.
 * 	4.	Continue Until Pointers Meet.
 * 	•	The loop stops when left == right, ensuring all possible containers are considered.
 */