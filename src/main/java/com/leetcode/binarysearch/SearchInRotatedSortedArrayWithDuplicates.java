package com.leetcode.binarysearch;

/**
 * 81. Search in Rotated Sorted Array II
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0 Output: true Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3 Output: false
 * <p>
 * The only difference is that due to the existence of duplicates, we can have
 * nums[left] == nums[mid] and in that case, the first half could be out of
 * order (i.e. NOT in the ascending order, e.g. [3 1 2 3 3 3 3]) and we have to
 * deal this case separately. In that case, it is guaranteed that nums[right]
 * also equals to nums[mid], so what we can do is to check if nums[mid]==
 * nums[left] == nums[right] before the original logic, and if so, we can move
 * left and right both towards the middle by 1. and repeat.
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
			// left part is sorted
			else if (nums[low] <= nums[mid]) {
				if (nums[low] <= target && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			// second half is sorted
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