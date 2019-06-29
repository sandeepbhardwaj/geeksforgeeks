package com.leetcode;

import java.util.*;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		//contains value and its index
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		//find the number
		for (int i = 0; i < nums.length; i++) {
			int find = target - nums[i];

			//second condition is most important to discard the same element
			if (map.containsKey(find) && map.get(find) != i) {
				return new int[]{i, map.get(find)};
			}

		}
		return null;
	}
}