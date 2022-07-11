package com.koko.matrix;

import java.util.Arrays;

/**
 * 73. Set Matrix Zeroes
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * <p>
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class SetMatrixZeroes {

	//Brute force solution will work only for +ve numbers, Assuming all the elements in the matrix are non-negative
	public static void setZeroesBruteForce(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				// if value is zero then set entire row  to -1
				if (matrix[i][j] == 0) {

					//mark the current cell to -1
					matrix[i][j] = -1;

					//set entire row to -1, keep row constant and move col index
					int tempCol = 0;
					while (tempCol < col) {
						if (matrix[i][tempCol] != 0) {
							matrix[i][tempCol] = -1;
						}
						tempCol++;
					}


					//set entire col to -1, keep col constant and move row index
					int tempRow = 0;
					while (tempRow < row) {
						if (matrix[tempRow][j] != 0) {
							matrix[tempRow][j] = -1;
						}
						tempRow++;
					}

				}

			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] <= 0) {
					matrix[i][j] = 0;
				}
			}
		}

	}

	//optimized approach
	public static void setZeroes(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		//dummy array
		int[] rows_arr = new int[row];
		int[] col_arr = new int[col];

		Arrays.fill(rows_arr, -1);
		Arrays.fill(col_arr, -1);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (matrix[i][j] == 0) {
					rows_arr[i] = 0;
					col_arr[j] = 0;
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (rows_arr[i] == 0 || col_arr[j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

	}

	public static void main(String args[]) {
		int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
		setZeroes(arr);
		System.out.println("The Final Matrix is ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
