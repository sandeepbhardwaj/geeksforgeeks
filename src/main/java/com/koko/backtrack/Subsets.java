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

	public static void backtrack_(int index, List<Integer> current, int[] nums, List<List<Integer>> result) {

		if (index == nums.length) {
			// add current to result;
			result.add(new ArrayList<>(current));
			return;
		}

		//add current element to list
		current.add(nums[index]);

		//include the  next element
		backtrack_(index + 1, current, nums, result);

		//remove the last element
		current.remove(current.size() - 1);

		//back track with removed element
		backtrack_(index + 1, current, nums, result);
	}


	public static void backtrack(int start, List<Integer> current, int[] nums, List<List<Integer>> result) {
		// add current to result;
		result.add(new ArrayList<>(current));

		for (int i = start; i < nums.length; i++) {
			//add current element to list
			current.add(nums[i]);

			// Exclude the element using i+1
			backtrack(i + 1, current, nums, result);

			// backtrack to use the
			current.remove(current.size() - 1);
		}
	}

	public static List<List<Integer>> subsetsIteratively(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		res.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			int n = res.size();
			for (int j = 0; j < n; j++) {
				List<Integer> temp = new ArrayList(res.get(j));
				temp.add(nums[i]);
				res.add(temp);
			}
		}
		return res;
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		backtrack(0, new ArrayList<>(), nums, result);
		return result;
	}


	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3};

		//System.out.println(subsetsIteratively(nums));
		System.out.println(subsets(nums));
	}
}
