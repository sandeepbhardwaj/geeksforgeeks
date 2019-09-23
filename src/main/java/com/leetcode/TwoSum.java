package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		// contains value and its index
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		// find the number
		for (int i = 0; i < nums.length; i++) {
			int find = target - nums[i];

			// second condition is most important to discard the same element
			if (map.containsKey(find) && map.get(find) != i) {
				return new int[]{i, map.get(find)};
			}

		}
		return null;
	}

}