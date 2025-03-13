/**
 * Max Area of Island
 * You are given a matrix grid where grid[i] is either a 0 (representing water) or 1 (representing land).
 * An island is defined as a group of 1's connected horizontally or vertically. You may assume all four edges of the grid are surrounded by water.
 * The area of an island is defined as the number of cells within the island.
 * Return the maximum area of an island in grid. If no island exists, return 0.
 * Example 1:
 * Input: grid = [
 *   [0,1,1,0,1],
 *   [1,0,1,0,1],
 *   [0,1,1,0,1],
 *   [0,1,0,0,1]
 * ]
 *
 * Output: 6
 * Explanation: 1's cannot be connected diagonally, so the maximum area of the island is 6.
 *
 * Constraints:
 *
 * 1 <= grid.length, grid[i].length <= 50
 */
class MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0; // Variable to store the maximum island area

        // Iterate through each cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // If we find land (1), start DFS to calculate the island area
                if (grid[i][j] == 1) { // Chec
                        // is the cell is land count arround if is island too with dfs
                    maxArea = Math.max(maxArea, dfs(grid, i, j)); // Update max area if needed
                }
            }
        }
        return maxArea; // Return the largest island found
    }

    // DFS function to calculate the area of an island
    private int dfs(int[][] grid, int i, int j) {
        // Base case: Stop if out of bounds or in water (0)
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0; // Mark land as visited by setting it to water (0)

        // Explore all four directions and sum up the total area
        int area = 1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
        for (int[] direction : directions) {
            area += dfs(grid, i + direction[0], j + direction[1]);
        }

        return area; // Return total area of the island
    }
}