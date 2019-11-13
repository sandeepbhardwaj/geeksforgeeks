package com.interview;

import java.util.Arrays;

public class SizeOfMaximumSubMatrixWithOne {

	public static int solution(int[][] matrices) {
		int res = 0;

		int rows = matrices.length;
		int cols = matrices[0].length;
		System.out.println(rows + " " + cols);
		int[][] temp = new int[matrices.length][matrices[0].length];

		for (int i = 0; i < rows; i++) {
			temp[i][0] = matrices[i][0];
		}
		for (int i = 0; i < cols; i++) {
			temp[0][i] = matrices[0][i];
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrices[i][j] == 1)
					temp[i][j] = Math.min(Math.min(temp[i - 1][j], temp[i][j - 1]), temp[i - 1][j - 1]) + 1;
				else
					temp[i][j] = 0;
			}
		}
		for (int i = 0; i < rows; i++) {
			System.out.println(Arrays.toString(temp[i]));
		}
		return res;
	}

	public static void main(String[] args) {
		int M[][] = { 	{ 0, 1, 1, 0, 1 }, 
						{ 1, 1, 0, 1, 0 }, 
						{ 0, 1, 1, 1, 0 }, 
						{ 1, 1, 1, 1, 0 }, 
						{ 1, 1, 1, 1, 1 },
						{ 0, 0, 0, 0, 0 } };

		solution(M);
	}

}