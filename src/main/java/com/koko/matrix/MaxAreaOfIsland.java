package com.koko.matrix;

/**
 * 695. Max Area of Island - Depth-First Search (Recursive)
 * <p>
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * <p>
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 */
public class MaxAreaOfIsland {

	public static int maxAreaOfIsland(int[][] grid) {

		int max_area = 0;

		int row = grid.length;
		int column = grid[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				max_area = Math.max(max_area, area(i, j, grid));
			}
		}
		return max_area;
	}

	/**
	 * recursive method to call all the adjacent cells
	 *
	 * @param row
	 * @param column
	 * @param grid
	 * @return
	 */
	private static int area(int row, int column, int[][] grid) {
		//overflow cases
		// if grid is covered with water aka 0
		if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0) {
			return 0;
		}

		//mark visited cell to zero
		grid[row][column] = 0;

		//call up , down , left and right cell for area.
		return 1 + area(row - 1, column, grid)
				+ area(row + 1, column, grid)
				+ area(row, column - 1, grid)
				+ area(row, column + 1, grid);
	}

	public static void main(String[] args) {
		int[][] grid = new int[][]
				{
						{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
						{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
						{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
				};

		System.out.println(maxAreaOfIsland(grid));
	}
}