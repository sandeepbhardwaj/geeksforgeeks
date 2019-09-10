package com.leetcode;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,4,5,1,2] Output: 1 Example 2:
 * <p>
 * Input: [4,5,6,7,0,1,2] Output: 0
 */
class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int mid = (low + high) / 2;

			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else if (nums[mid] < nums[high]) {
				high = mid;
			}
		}
		return nums[low];
	}
}