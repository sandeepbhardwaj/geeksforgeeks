package com.koko.matrix;

import java.util.Arrays;

public class SizeOfMaximumSubMatrixWithOne {

	private static int maxMatrixWithOne(int[][] matrix) {
		// base case for invalid matrix
		int row = matrix.length;
		if (row == 0)
			return 0;
		int col = matrix[0].length;
		if (col == 0)
			return 0;

		int max = 0;
		int temp[][] = new int[row][col];

		// loop through rows and columns
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// for first row or first column
				if (i == 0 || j == 0) {
					temp[i][j] = matrix[i][j];
				} else if (matrix[i][j] == 1) {
					// min of row,column,diagonal
					temp[i][j] = Math.min(Math.min(temp[i - 1][j], temp[i][j - 1]), temp[i - 1][j - 1]) + 1;
				} else {
					temp[i][j] = 0;
				}

				// update max
				if (max < temp[i][j]) {
					max = temp[i][j];
				}
			}
		}

		// print temp matrix
		for (int i = 0; i < row; i++) {
			System.out.println(Arrays.toString(temp[i]));
		}

		return max;
	}

	public static void main(String[] args) {
		int matrix[][] =
				{
						{0, 1, 1, 0, 1},
						{1, 1, 0, 1, 0},
						{0, 1, 1, 1, 0},
						{1, 1, 1, 1, 0},
						{1, 1, 1, 1, 1},
						{0, 0, 0, 0, 0}
				};

		System.out.println(maxMatrixWithOne(matrix));
	}

}