package com.koko;

public class CommonUtils {
	public static void displayMatrix(int m, int n, int[][] t) {
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(t[i][j] + " | ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
