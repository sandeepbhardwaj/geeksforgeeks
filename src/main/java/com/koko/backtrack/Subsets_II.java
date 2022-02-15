package com.koko.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * <p>
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * <p>
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class Subsets_II {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<>();
		backtrack(0, new ArrayList<>(), nums, result);

		return result;
	}

	public void backtrack(int index, List<Integer> current, int[] nums, List<List<Integer>> result) {
		result.add(new ArrayList<>(current));

		for (int i = index; i < nums.length; i++) {

			//skip the duplicate records
			if (i > index && nums[i] == nums[i - 1])
				continue;

			current.add(nums[i]);
			backtrack(i + 1, current, nums, result);
			current.remove(current.size() - 1);
		}
	}
}
