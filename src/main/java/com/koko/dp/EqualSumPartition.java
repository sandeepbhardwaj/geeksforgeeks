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

		return isSubsetSumDP(nums, nums.length, (int) sum / 2);
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
		int[] nums = {1, 5, 11, 5};
		System.out.println("Is array can be partitioned into equal sum subset ?: " + canPartition(nums));
	}
}
