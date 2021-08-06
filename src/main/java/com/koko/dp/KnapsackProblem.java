package com.koko.dp;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in
 * the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights
 * associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the
 * maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 */
public class KnapsackProblem {
	// Driver code
	public static void main(String args[]) {
		int val[] = new int[]{60, 100, 120};
		int wt[] = new int[]{10, 20, 30};
		int W = 50;
		int n = val.length;
	}
}
