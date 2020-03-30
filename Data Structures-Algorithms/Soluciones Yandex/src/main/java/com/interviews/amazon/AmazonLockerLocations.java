package com.interviews.amazon;

/**
 * Suppose you are an engineer on the Amazon Student team.Your team want to
 * launch new feature called "Courses your social network have attended", that
 * lists all the courses your social network are taking, sorted by popularity. A
 * social network is defined as all direct friends and all direct friends of
 * direct friends. People 3 level deep are not part of the social circle.
 * 
 * your job is to construct a 2-d grid of the city. each element of the grid
 * should be a positive whole number that specifies the number of block to the
 * closest locker. The distance between two blocks is the sum of their
 * horizontal and vertical distance ( a move in the diagonal direction is there
 * considered a distance of 2)
 * 
 * 
 * @author Zion
 *
 */
public class AmazonLockerLocations {
	public static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates,
			int[] lockerYCoordinates) {
		if (lockerXCoordinates == null || lockerYCoordinates == null
				|| lockerXCoordinates.length != lockerYCoordinates.length) {
			return null;
		}
		int[][] grid = new int[cityWidth][cityLength];
		for (int i = 0; i < grid[0].length; i++)
			for (int j = 0; j < grid.length; j++)
				grid[j][i] = Integer.MAX_VALUE;
		// starting distance
		for (int i = 0; i < lockerXCoordinates.length; i++) {
			grid[lockerYCoordinates[i] - 1][lockerXCoordinates[i] - 1] = 0;
		}
		for (int i = 0; i < lockerXCoordinates.length; i++) {
			distance(grid, lockerYCoordinates[i], lockerXCoordinates[i]);
		}
		return grid;
	}

	// The distance between two blocks is the sum of their horizontal and
	// vertical distance
	static void distance(int[][] grid, int y, int x) {
		y = y - 1;
		x = x - 1;
		for (int i = 0; i < grid[0].length; i++)
			for (int j = 0; j < grid.length; j++) {
				if (grid[j][i] != 0) {
					int aux = grid[j][i];
					int dist = Math.abs(j - y) + Math.abs(i - x);
					if (dist < aux) {
						grid[j][i] = dist;
					}
				}
			}
	}

	static String arrayToStr(int[][] grid) {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < grid.length; y++) { // y
			for (int x = 0; x < grid[0].length; x++)
				sb.append(grid[y][x]);
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] x = { 1, 1 };
		int[] y = { 1, 1 };
		int[][] grid = getLockerDistanceGrid(3, 5, x, y);
		System.out.println(arrayToStr(grid));
		int[] x2 = { 2, 4 };
		int[] y2 = { 3, 7 };
		grid = getLockerDistanceGrid(5, 7, x2, y2);
		System.out.println(arrayToStr(grid));
	}

}
