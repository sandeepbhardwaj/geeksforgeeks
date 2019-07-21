package com.leetcode;

/**
 * 283. Move Zeroes
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the
 * non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int left = 0;
		int right = 0;

		while (left <= right && right < nums.length) {
			if (nums[left] == 0 && nums[right] == 0) {
				right++;
				continue;
			}

			if (nums[left] == 0) {
				int temp = nums[right];
				nums[right] = nums[left];
				nums[left] = temp;

				left++;
				right++;
				continue;
			}

			//if left is not zero
			left++;
			right++;
		}

	}
}
