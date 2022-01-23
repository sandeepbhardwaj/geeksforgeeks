package com.koko.array;

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
	 * here number of swapping is large
	 *
	 * @param nums
	 */
	public static void moveZeroes2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int index = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[index++] = num;
			}
		}

		while (index < nums.length) {
			nums[index++] = 0;
		}
	}

	/**
	 * intresting solution O(n)
	 *
	 * @param nums
	 */
	public void moveZeroes3(int[] nums) {
		int snowBallSize = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				snowBallSize++;
			} else if (snowBallSize > 0) {
				int t = nums[i];
				nums[i] = 0;
				nums[i - snowBallSize] = t;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1};
		moveZeroes2(arr);
		for (int element : arr) {
			System.out.print(" " + element);
		}
	}
}
