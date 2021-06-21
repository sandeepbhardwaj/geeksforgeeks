package com.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;

		//directions
		int left = 0, right = column - 1, top = 0, bottom = row - 1;

		List<Integer> result = new ArrayList<>();

		while (left <= right && top <= bottom) {
			//left to right -- top fixed
			for (int i = left; i <= right; i++) {
				result.add(matrix[top][i]);
			}
			top++;

			//top to bottom -- right fixed
			for (int i = top; i <= bottom; i++) {
				result.add(matrix[i][right]);
			}
			right--;

			//right to left -- bottom fixed
			// important if check
			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					result.add(matrix[bottom][i]);
				}
			}
			bottom--;

			//bottom to up -- left fixed
			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					result.add(matrix[i][left]);
				}
			}
			left++;

		}
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]
				{
						{1, 2, 3, 4},
						{5, 6, 7, 8},
						{9, 10, 11, 12}
				};

		//Expected: [1,2,3,4,8,12,11,10,9,5,6,7]

		System.out.println(spiralOrder(matrix));
	}
}
