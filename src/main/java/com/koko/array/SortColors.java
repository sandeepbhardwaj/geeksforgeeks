package com.koko.array;

/**
 * 75. Sort Colors
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color
 * are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 * <p>
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 */
public class SortColors {
	public void sortColors(int[] nums) {
		int low = 0;
		int mid = 0;
		int high = nums.length - 1;

		while (low <= mid && mid <= high) {
			if (nums[mid] == 0) {
				//swap with low
				nums[mid] = nums[low];
				nums[low] = 0; //can assign 0 directly
				low++;
				mid++;
			} else if (nums[mid] == 1) {
				mid++;
			} else if (nums[mid] == 2) {
				//swap with high
				nums[mid] = nums[high];
				nums[high] = 2; // can assign 2 directly
				high--;
			}
		}
	}

}
