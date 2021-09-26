package com.koko.array.subarray;

/**
 * Given an array of integers of size ‘n’. Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the
 * array.
 * <p>
 * Input  : arr[] = {100, 200, 300, 400}
 * k = 2
 * Output : 700
 * <p>
 * Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
 * k = 4
 * Output : 39
 * We get maximum sum by adding subarray {4, 2, 10, 23}
 * of size 4.
 * <p>
 * Input  : arr[] = {2, 3}
 * k = 3
 * Output : Invalid
 * There is no subarray of size 3 as size of whole
 * array is 2.
 * <p>
 * Ref : https://www.geeksforgeeks.org/window-sliding-technique/
 */
public class MaxSumSubArrayOfSizeK {
	private static int maxSubArrayOfSizeK(int[] nums, int k) {
		int max_sum = Integer.MIN_VALUE;

		// two pointers for holding window size
		int left = 0, right = 0;

		int current_sum = 0;
		while (right < nums.length) {
			current_sum += nums[right];

			//if window is smaller than k , increase window size
			if (right - left + 1 < k) {
				right++;
			} else if (right - left + 1 == k) { // window is equal to k
				max_sum = Math.max(max_sum, current_sum);

				current_sum -= nums[left];
				left++;
				right++;
			}

		}
		return max_sum;
	}


	//brute force
	private static int maxSubArrayOfSizeK_1(int[] nums, int k) {
		int max_sum = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length - k + 1; i++) {
			int sum = 0;
			for (int j = 0; j < k; j++) {
				sum += nums[i + j]; // i+j to point to correct objects
			}
			max_sum = Math.max(max_sum, sum);
		}
		return max_sum;
	}

	public static void main(String[] args) {
		int[] nums = {1, 4, 2, 10, 23, 3, 1, 0, 20};
		System.out.println(maxSubArrayOfSizeK(nums, 4));
	}
}
