package com.leetcode.matrix;

/**
 * 867. Transpose Matrix
 * <p>
 * Given a 2D integer array matrix, return the transpose of matrix.
 * <p>
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 */
public class TransposeMatrix {

	/**
	 * If matrix is m*n and m!=n , then it can't be be done without using extra space
	 *
	 * @param matrix
	 * @return
	 */
	public int[][] transpose(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;

		int[][] result = new int[column][row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				//swap A[i,j]=A[j,i]
				result[j][i] = matrix[i][j];
			}
		}
		return result;
	}


	/**
	 * If matrix is Symmetric m*n i.e m==n , then it can be be done without using extra space
	 *
	 * @param matrix
	 * @return
	 */
	public int[][] transposeSymmetricMatrix(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;

		//if matrix is n*n then we can use j=i condition to improve performance
		for (int i = 0; i < row; i++) {
			for (int j = i; j < column; j++) { // M.Imp Why j= i ?
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		return matrix;
	}
}
