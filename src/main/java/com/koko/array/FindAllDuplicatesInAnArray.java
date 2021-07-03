package com.koko.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 * <p>
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements that appear twice in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * <p>
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [2,3]
 */
public class FindAllDuplicatesInAnArray {

	// Marking there position negative index=(value-1), if its already negative then add in duplicate array
	// when find a number i, flip the number at position i-1 to negative.
	// if the number at position i-1 is already negative, i is the number that occurs twice.
	public static List<Integer> findDuplicates(int[] nums) {

		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			//if length is n then total index are n-1
			int index = Math.abs(nums[i]) - 1;

			//if we are able to find same index again then element is already -ver
			if (nums[index] < 0) {
				result.add(index + 1);
			}
			nums[index] = -nums[index];
		}
		return result;
	}

	public static void main(String[] args) {
		//int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
		int[] nums = new int[]{2, 1, 1};
		findDuplicates(nums).forEach(e -> System.out.print(e + " ,"));
	}
}
