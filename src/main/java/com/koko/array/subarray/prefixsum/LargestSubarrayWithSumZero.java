package com.koko.array.subarray.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array having both positive and negative integers. The task is to compute the length of the largest subarray
 * with sum 0.
 * <p>
 * Example 1:
 * Input: N = 8, A[] = {15,-2,2,-8,1,7,10,23}
 * Output: 5
 * Explanation: The largest subarray with sum 0 will be -2 2 -8 1 7.
 * <p>
 * https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum
 */
public class LargestSubarrayWithSumZero {
	public static int maxLen(int arr[], int n) {
		int maxLen = 0;
		int currSum = 0;

		Map<Integer, Integer> preSum = new HashMap<>();

		for (int i = 0; i < n; i++) {
			currSum += arr[i];

			// if sum is zero then full length is ans
			if (currSum == 0) {
				maxLen = Math.max(maxLen, i + 1);
			}

			if (preSum.containsKey(currSum)) {
				maxLen = Math.max(maxLen, i - preSum.get(currSum));
			} else {
				preSum.put(currSum, i);
			}
		}

		return maxLen;
	}
}
