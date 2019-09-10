package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 * <p>
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input: [4,3,2,7,8,2,3,1]
 * <p>
 * Output: [5,6]
 */
public class FindAllNumbersDisappearedInAnArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> results = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]);

			// negate the output
			nums[val - 1] = -Math.abs(nums[val - 1]);
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				results.add(i + 1);
			}

		}
		return results;
	}
}
