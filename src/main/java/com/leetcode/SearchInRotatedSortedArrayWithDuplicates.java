package com.leetcode;

/**
 * 81. Search in Rotated Sorted Array II
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 */
public class SearchInRotatedSortedArrayWithDuplicates {

	public boolean search(int[] nums, int target) {

		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (nums[mid] == target)
				return true;

			// if none of the part is sorted
			if (nums[low] == nums[mid] && nums[high] == nums[mid]) {
				++low;
				--high;
			}
			//left part is sorted
			else if (nums[low] <= nums[mid]) {
				if (nums[low] <= target && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			//second half is sorted
			else {
				if (nums[mid + 1] <= target && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}

		}
		return false;
	}
}