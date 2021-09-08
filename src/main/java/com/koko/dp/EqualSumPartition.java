package com.koko.dp;

/**
 * 416. Partition Equal Subset Sum
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 * <p>
 * Example 1:
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * <p>
 * Example 2:
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class EqualSumPartition {
	public static boolean canPartition(int[] nums) {
		long sum = 0;
		for (int num : nums) {
			sum += num;
		}

		if (sum % 2 != 0)
			return false;

		return isSubsetSumDP(nums, (int) sum / 2, nums.length);
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
		int[] nums = {1, 5, 11, 5};
		System.out.println("Is array can be partitioned into equal sum subset ?: " + canPartition(nums));
	}
}
