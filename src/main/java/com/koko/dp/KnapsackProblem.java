package com.koko.dp;

import java.util.Arrays;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in
 * the knapsack.
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights
 * associated with n items respectively.
 * Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum
 * of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 */
public class KnapsackProblem {

	/**
	 * @param wt
	 * @param val
	 * @param w
	 * @param n
	 * @return
	 */
	public static int knapsackRecursion(int[] wt, int[] val, int w, int n) {
		//base condition either weight is zero or there is no value
		if (n == 0 || w == 0)
			return 0;

		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included
		if (wt[n - 1] <= w)
			return Math.max(val[n - 1] + knapsackRecursion(wt, val, w - wt[n - 1], n - 1), knapsackRecursion(wt, val, w, n - 1));
		else // if(wt[n-1]>w)
			return knapsackRecursion(wt, val, w, n - 1);
	}

	/**
	 * Memoization Technique (an extension of recursive approach)
	 *
	 * @param wt
	 * @param val
	 * @param w
	 * @param n
	 * @param dp
	 * @return
	 */
	public static int knapsackRecursionMemoization(int[] wt, int[] val, int w, int n, int[][] dp) {
		//base condition either weight is zero or there is no value
		if (n == 0 || w == 0)
			return 0;

		if (dp[n][w] != -1)
			return dp[n][w];

		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included
		if (wt[n - 1] <= w)
			return dp[n][w] = Math.max(val[n - 1] + knapsackRecursionMemoization(wt, val, w - wt[n - 1], n - 1, dp), knapsackRecursionMemoization(wt, val, w, n - 1, dp));
		else // if(wt[n-1]>w)
			return dp[n][w] = knapsackRecursionMemoization(wt, val, w, n - 1, dp);
	}

	// Driver code
	public static void main(String[] args) {
		int val[] = new int[]{60, 100, 120};
		int wt[] = new int[]{10, 20, 30};
		int w = 50;
		int n = val.length;

		int result = knapsackRecursion(wt, val, w, n);
		System.out.println("Max total value in knapsack :" + result);

		// Declare the table dynamically
		int dp[][] = new int[n + 1][w + 1];

		// Loop to initially filled the table with -1
		Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

		System.out.println("Max total value in knapsack :" + knapsackRecursionMemoization(wt, val, w, n, dp));
	}
}
