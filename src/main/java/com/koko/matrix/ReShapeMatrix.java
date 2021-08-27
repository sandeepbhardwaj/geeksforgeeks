package com.koko.matrix;

/**
 * 566. Reshape the Matrix
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different
 * size r x c keeping its original data.
 * <p>
 * You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns
 * of the wanted reshaped matrix.
 * <p>
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as
 * they were.
 * <p>
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise,
 * output the original matrix.
 * <p>
 * Example 1:
 * Input: mat = [[1,2],[3,4]], r = 1, c = 4
 * Output: [[1,2,3,4]]
 * <p>
 * Example 2:
 * Input: mat = [[1,2],[3,4]], r = 2, c = 4
 * Output: [[1,2],[3,4]]
 */
public class ReShapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) return nums;

        int[][] result = new int[r][c];
        int row = 0, col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[row][col] = nums[i][j];
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        return result;
    }

    /**
     * We can use matrix[index / width][index % width] for both the input and the output matrix.
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape_II(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (r * c != m * n)
            return nums;
        int[][] reshaped = new int[r][c];
        for (int i = 0; i < r * c; i++)
            reshaped[i / c][i % c] = nums[i / n][i % n];
        return reshaped;
    }
}
