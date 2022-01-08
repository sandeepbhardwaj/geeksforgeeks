package com.koko;

public class CommonUtils {

	public static void displayMatrix(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		displayMatrix(row, column, matrix);
	}

	public static void displayMatrix(int row, int column, int[][] matrix) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(matrix[i][j] + " | ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
