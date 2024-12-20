package com.koko.array;

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
	// Mark the found element correct position -ve
	// all non negative index+1 are missing values
	public List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> results = new ArrayList<>();

		// negate the value if found
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;

			// negate the output
			nums[index] = -Math.abs(nums[index]);
		}

		// if value at index is positive then add to result
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				results.add(i + 1);
			}
		}
		return results;
	}
}
