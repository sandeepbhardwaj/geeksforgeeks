package com.koko.dp;

/**
 * Subset Sum Problem
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal
 * to given sum.
 * <p>
 * Example 1:
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output: True
 * There is a subset (4, 5) with sum 9.
 * <p>
 * Example 2:
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
 * Output: False
 * There is no subset that add up to 30
 */
public class SubSetSumProblem {

	public static boolean isSubsetSumRecursion(int[] set, int sum, int n) {
		if (sum == 0)
			return true;
		if (n == 0)
			return false;

		/*
		check if sum can be obtained  by any of the following
        (a) including the last element
        (b) excluding the last element
        */
		if (set[n - 1] <= sum) {
			return isSubsetSumRecursion(set, sum - set[n - 1], n - 1) || isSubsetSumRecursion(set, sum, n - 1);
		} else { // If last element is greater than sum, then ignore it
			return isSubsetSumRecursion(set, sum, n - 1);
		}
	}

	public static boolean isSubsetSumDP(int[] set, int sum, int n) {
		int i, j;
		boolean[][] dp = new boolean[sum + 1][n + 1];
		//i represent sum and j represents n
		for (i = 0; i <= sum; i++) {
			for (j = 0; j <= n; j++) {
				if (i == 0) {
					dp[i][j] = Boolean.TRUE;
				} else if (j == 0) {
					dp[i][j] = Boolean.FALSE;
				} else if (set[j - 1] <= i) {
					dp[i][j] = dp[i][j - 1] || dp[i - set[j - 1]][j - 1];
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		//last element of matrix
		return dp[sum][n];
	}

	public static void main(String[] args) {
		int[] set = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		System.out.println("isSubsetSum using recursion :" + isSubsetSumRecursion(set, sum, set.length));

		System.out.println("isSubsetSum using recursion :" + isSubsetSumDP(set, sum, set.length));
	}
}
