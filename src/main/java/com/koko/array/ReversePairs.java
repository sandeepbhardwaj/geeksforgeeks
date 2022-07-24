package com.koko.array;

public class ReversePairs {
	public static int reversePairs(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {

			// to make i<j
			for (int j = i + 1; j < nums.length; j++) {

				long a = nums[i];
				long b = 2 * nums[j];

				if (a > b) result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
		reversePairs(nums);
	}
}
