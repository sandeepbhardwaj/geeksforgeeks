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

	public static boolean isSubsetSumRecursion(int[] set, int n, int sum) {
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
			return isSubsetSumRecursion(set, n - 1, sum - set[n - 1]) || isSubsetSumRecursion(set, n - 1, sum);
		} else { // If last element is greater than sum, then ignore it
			return isSubsetSumRecursion(set, n - 1, sum);
		}
	}

	public static boolean isSubsetSumDP(int[] set, int n, int sum) {
		int i, j;
		boolean[][] dp = new boolean[n + 1][sum + 1];
		//i represent n and j represents sum
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= sum; j++) {
				if (i == 0) { // n==0
					dp[i][j] = Boolean.FALSE;
				} else if (j == 0) { //sum==0
					dp[i][j] = Boolean.TRUE;
				} else if (set[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		//last element of matrix
		return dp[n][sum];
	}

	public static void main(String[] args) {
		int[] set = {3, 34, 4, 12, 5, 2};
		int sum = 11;
		System.out.println("isSubsetSum using recursion :" + isSubsetSumRecursion(set, set.length, sum));

		System.out.println("isSubsetSum using recursion :" + isSubsetSumDP(set, set.length, sum));
	}
}
