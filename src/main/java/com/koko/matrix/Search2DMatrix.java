package com.koko.matrix;

/**
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the
 * following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * <p>
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 */
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int low = 0;

		int row = matrix.length;
		int col = matrix[0].length;

		int high = row * col - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			// an array convert to row * col matrix => a[x] =>matrix[x / col][x % col];
			if (matrix[mid / col][mid % col] == target) {
				return true;
			}

			if (matrix[mid / col][mid % col] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}
}
