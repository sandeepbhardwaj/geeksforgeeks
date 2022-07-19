package com.koko.array.subarray;

import java.util.Arrays;

/**
 * 53. Maximum Subarray - Kadane's Algorithm
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
public class MaximumSubarray {
	public static int maxSubArray(int[] nums) {
		int max_so_far = nums[0];
		int max_ending_here = nums[0];

		for (int i = 1; i < nums.length; i++) {
			max_ending_here = Math.max(max_ending_here + nums[i], nums[i]);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		return max_so_far;
	}

	public static void maxSubArrayWithIndices(int[] nums) {
		int max_so_far = nums[0];
		int max_ending_here = nums[0];
		int start = 0;
		int end = 0;

		int tempStart = 0;

		for (int i = 1; i < nums.length; i++) {
			// add current element to running sum
			max_ending_here = max_ending_here + nums[i];

			if (max_ending_here < nums[i]) {
				max_ending_here = nums[i];
				tempStart = i; // reset the temp start
			}

			if (max_ending_here > max_so_far) {
				max_so_far = max_ending_here;
				start = tempStart;
				end = i;
			}
		}

		System.out.println("Result :" + max_so_far);
		System.out.println("start:" + start + " ,end:" + end);
	}

	// Time complexity - O(n^2)
	public int maxSubArrayWithTwoLoops(int[] nums) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int sum = 0;

			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				max = Math.max(max, sum);
			}
		}
		return max;
	}


	public static void main(String[] args) {
		int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(maxSubArray(nums));
		maxSubArrayWithIndices(nums);
	}
}
