package com.koko.matrix;

import com.koko.CommonUtils;

/**
 * 733. Flood Fill
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * <p>
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the
 * pixel image[sr][sc].
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel
 * of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color),
 * and so on. Replace the color of all of the aforementioned pixels with newColor.
 * <p>
 * Return the modified image after performing the flood fill.
 * <p>
 * Example 2:
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected
 * by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 * <p>
 * Example 2:
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
 * Output: [[2,2,2],[2,2,2]]
 */
public class FloodFill {
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		int color = image[sr][sc];
		if (color != newColor)
			dfs(image, sr, sc, color, newColor);
		return image;

	}

	public static void dfs(int[][] image, int row, int column, int color, int newColor) {
		if (row < 0 || row >= image.length || column < 0 || column >= image[0].length || image[row][column] != color) {
			return;
		}

		if (image[row][column] == color) {
			image[row][column] = newColor;
		}

		dfs(image, row - 1, column, color, newColor);
		dfs(image, row + 1, column, color, newColor);
		dfs(image, row, column - 1, color, newColor);
		dfs(image, row, column + 1, color, newColor);
	}

	public static void main(String[] args) {
		int[][] image = new int[][]
				{
						{0, 0, 0},
						{1, 1, 0}
				};

		image = floodFill(image, 1, 0, 2);
		CommonUtils.displayMatrix(image);
	}
}
