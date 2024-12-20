package com.koko.matrix;

/**
 * 48. Rotate Image
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 */

/**
 * clockwise rotate
 * first swap the symmetry (i.e. transpose the matrix), then reverse each row
 * 1 2 3     1 4 7     7 4 1
 * 4 5 6  => 2 5 8  => 8 5 2
 * 7 8 9     3 6 9     9 6 3
 * <p>
 * anti-clockwise rotate
 * first swap the symmetry (i.e. transpose the matrix), then reverse each col
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		//Step 1: transpose n*n matrix
		for (int i = 0; i < n; i++) {
			//j < i – all th elements till diagonal
			for (int j = 0; j < i; j++) {
				//swap
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		//Step 2: reverse the elements
		for (int i = 0; i < n; i++) {
			for (int left = 0, right = n - 1; left < right; left++, right--) {
				//swapping first element with last element
				int temp = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = temp;
			}
		}
	}
}
