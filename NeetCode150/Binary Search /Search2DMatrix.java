/**
 * Search a 2D Matrix
 * You are given an m x n 2-D integer array matrix and an integer target.
 *
 * Each row in matrix is sorted in non-decreasing order.
 * The first integer of every row is greater than the last integer of the previous row.
 * Return true if target exists within matrix or false otherwise.
 *
 * Can you write a solution that runs in O(log(m * n)) time?
 *
 * Example 1:
 * Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10
 *
 * Output: true
 * Example 2:
 * Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 15
 *
 * Output: false
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10000 <= matrix[i][j], target <= 10000
 */
/**
 * Search a 2D Matrix
 * Given an `m x n` matrix where each row is sorted and the first element of each row
 * is greater than the last element of the previous row, determine if `target` exists.
 *
 * Example 1:
 * Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 15
 * Output: false
 */

class Search2DMatrix {
    /**
     * Searches for a target in a sorted 2D matrix using binary search.
     *
     * @param matrix The 2D matrix.
     * @param target The target number to search for.
     * @return True if target exists, otherwise false.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1; // Treat 2D matrix as 1D sorted array

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n]; // Convert 1D index to 2D coordinates

            if (midValue == target) return true;
            else if (midValue < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        Search2DMatrix solution = new Search2DMatrix();

        // Example 1
        int[][] matrix1 = {
                {1, 2, 4, 8},
                {10, 11, 12, 13},
                {14, 20, 30, 40}
        };
        int target1 = 10;
        System.out.println(solution.searchMatrix(matrix1, target1)); // Output: true

        // Example 2
        int target2 = 15;
        System.out.println(solution.searchMatrix(matrix1, target2)); // Output: false

        // Example 3
        int[][] matrix2 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target3 = 3;
        System.out.println(solution.searchMatrix(matrix2, target3)); // Output: true
    }
}

/**
 * Explanation of the Solution
 * 	1.	Convert the 2D Matrix into a 1D Sorted Array (Virtually)
 * 	•	Each row is sorted, and the first element of a row is greater than the last element of the previous row.
 * 	•	Treat the matrix as a 1D array of size m * n.
 * 	2.	Perform Binary Search (O(log(m * n)))
 * 	•	Left Pointer: left = 0
 * 	•	Right Pointer: right = m * n - 1
 * 	•	Midpoint Calculation:
 * 	•	Convert 1D index to 2D coordinates:
 * 	•	midValue = matrix[mid / n][mid % n]
 * 	•	Increment left pointer: left = mid + 1
 * 	•	Decrement right pointer: right = mid - 1
 * 	3.	Return true if target is found, false otherwise.
 * 	Complexity Analysis:
 * 	•	Time complexity: O(log(m * n))
 * 	•	Space complexity: O(1)
 */