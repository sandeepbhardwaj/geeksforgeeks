package com.koko.array;

import java.util.HashMap;
import java.util.Map;


public class TwoSum {

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
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		// store target-num[i] as key and index as value
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {

			//check if (target-num[i]) is already exit
			if (map.containsKey(nums[i])) {
				return new int[]{map.get(nums[i]), i};
			}

			// for num[0]=2 , 7 as key and 0 as value {7,0}
			map.put(target - nums[i], i);
		}
		return null;
	}

	/**
	 * 167. Two Sum II - Input array is sorted
	 * Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such that
	 * they add up to a specific target number.
	 * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2,
	 * where 1 <= answer[0] < answer[1] <= numbers.length.
	 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
	 * <p>
	 * Example 1:
	 * Input: numbers = [2,7,11,15], target = 9
	 * Output: [1,2]
	 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
	 * <p>
	 * Example 2:
	 * Input: numbers = [2,3,4], target = 6
	 * Output: [1,3]
	 * <p>
	 * Example 3:
	 * Input: numbers = [-1,0], target = -1
	 * Output: [1,2]
	 *
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum_II(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;

		while (numbers[left] + numbers[right] != target) {
			if (numbers[left] + numbers[right] > target)
				right--;
			else
				left++;
		}
		return new int[]{left + 1, right + 1};
	}

}