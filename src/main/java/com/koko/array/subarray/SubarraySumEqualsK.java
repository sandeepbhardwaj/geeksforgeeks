package com.koko.array.subarray;

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

	/**
	 * if the cumulative sum up to two indices, say ii and jj is at a difference of k i.e.
	 * if sum[i] - sum[j] = k
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int subarraySum(int[] nums, int k) {
		int count = 0;

		// key as preSum and value as frequency
		Map<Integer, Integer> preSum = new HashMap<>();

		//for base case
		//check whether currentSum - k = 0, if 0 it means the sub array is starting from index 0
		preSum.put(0, 1);

		int currentSum = 0;
		for (int num : nums) {
			currentSum += num;

			//if currentSum-k found in map
			if (preSum.containsKey(currentSum - k)) {
				count += preSum.get(currentSum - k);
			}

			preSum.put(currentSum, preSum.getOrDefault(currentSum, 0) + 1);
		}

		return count;
	}

	/**
	 * consider every possible subarray of the given numsnums array, find the sum of the elements of each of those
	 * subarrays and check for the equality of the sum obtained with the given kk. Whenever the sum equals kk,
	 * we can increment the count used to store the required result.
	 * <p>
	 * Time complexity : O(n^2). We need to consider every subarray possible.
	 *
	 * @param nums
	 * @param k
	 * @return count
	 */
	public static int bruteForce(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == k)
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		//int[] nums = {1, 0, 1, 0, 1};
		//System.out.println(subarraySum(nums, 1));
		int[] nums = {4, 4, 4};
		System.out.println(subarraySum(nums, 4));
	}
}
