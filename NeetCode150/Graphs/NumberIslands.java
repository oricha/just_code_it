/**
 * Number of Islands
 * Given a 2D grid grid where '1' represents land and '0' represents water, count and return the number of islands.
 * An island is formed by connecting adjacent lands horizontally or vertically and is surrounded by water. You may assume water is surrounding the grid (i.e., all the edges are water).
 * Example 1:
 *
 * Input: grid = [
 *     ["0","1","1","1","0"],
 *     ["0","1","0","1","0"],
 *     ["1","1","0","0","0"],
 *     ["0","0","0","0","0"]
 *   ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *     ["1","1","0","0","1"],
 *     ["1","1","0","0","1"],
 *     ["0","0","1","0","0"],
 *     ["0","0","0","1","1"]
 *   ]
 * Output: 4
 * Constraints:
 *
 * 1 <= grid.length, grid[i].length <= 100
 * grid[i][j] is '0' or '1'.
 */
class NumberIslands {
    int numIslands = 0; //We need to traverse the grid and count how many separate islands exist.

    // Iterate through each cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') { // Found a new island
                    numIslands++;
                    markIsland(grid, i, j); // Mark all connected land as visited
                }
        }
    }
        return numIslands;
}

// DFS function to mark connected land as visited
private void markIsland(char[][] grid, int i, int j) {
    if (i < 0
            || j < 0
            || i >= grid.length // Out of bounds
            || j >= grid[0].length // Out of bounds
            || grid[i][j] == '0' // Already visited
    ) return;

    grid[i][j] = '0'; // Mark as visited

    // Explore all four directions using an array (reducing redundant DFS calls)
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
    for (int[] direction : directions)
        markIsland(grid, i + direction[0], j + direction[1]); // DFS recursively explore all connected land in the 4 directions
    }
}