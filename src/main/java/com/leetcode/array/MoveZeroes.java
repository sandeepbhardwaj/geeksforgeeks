package com.leetcode.array;

/**
 * 283. Move Zeroes
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0] Note:
 * <p>
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations.
 */
public class MoveZeroes {

	/**
	 * sliding window technique
	 *
	 * @param nums
	 */
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

			// if left is not zero
			left++;
			right++;
		}
	}

	/**
	 * here number of swapping is large
	 *
	 * @param nums
	 */
	public void moveZeroes2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int insertPos = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[insertPos++] = num;
			}
		}

		while (insertPos < nums.length) {
			nums[insertPos++] = 0;
		}
	}
}
