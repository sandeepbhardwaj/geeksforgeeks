package com.leetcode.array;

/**
 * 26. Remove Duplicates from Sorted Array
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length. Example 2:
 * <p>
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * Your function should return length = 5, with the first five elements of nums
 * being modified to 0, 1, 2, 3, and 4 respectively.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int unique = 1;
		for (int i = 1; i < nums.length; i++) {
			//compare previous with next
			if (nums[i] != nums[i - 1]) {
				nums[unique] = nums[i];
				unique++;
			}
		}
		return unique;
	}
}