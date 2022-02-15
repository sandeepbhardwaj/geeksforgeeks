package com.koko.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class Subsets {


	public static void backtrack1(int start, List<Integer> current, int[] nums, List<List<Integer>> result) {
		// add current to result;
		result.add(new ArrayList<>(current));

		for (int i = start; i < nums.length; i++) {
			//add current element to list
			current.add(nums[i]);

			//backtrack for next element
			backtrack1(i + 1, current, nums, result);
			current.remove(current.size() - 1);
		}

	}

	public static void backtrack(int index, List<Integer> current, int[] nums, List<List<Integer>> result) {

		if (index == nums.length) {
			// add current to result;
			result.add(new ArrayList<>(current));
			return;
		}

		//add current element to list
		current.add(nums[index]);

		//include the  next element
		backtrack(index + 1, current, nums, result);

		//remove the last element
		current.remove(current.size() - 1);

		//back track with removed element
		backtrack(index + 1, current, nums, result);
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		backtrack(0, new ArrayList<>(), nums, result);
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2};
		System.out.println(subsets(nums));
	}
}
