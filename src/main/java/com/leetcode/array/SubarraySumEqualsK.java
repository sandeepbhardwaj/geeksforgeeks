package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * <p>
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1: Input:nums = [1,1,1], k = 2 Output: 2
 *
 * @author sandeep
 */
public class SubarraySumEqualsK {

	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(subarraySum(nums, 0));
	}

	public static int subarraySum(int[] nums, int k) {
		// map contains sum and its frequency
		Map<Integer, Integer> preSum = new HashMap<>();

		// this default value needed when we found sum-k=0
		preSum.put(0, 1);

		int sum = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			// if sum-k present in map increment the count
			count += preSum.getOrDefault(sum - k, 0);

			// add the sum in map and increment the frequency by 1
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);

		}
		return count;
	}

}
