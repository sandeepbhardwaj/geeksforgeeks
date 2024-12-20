package com.koko.binarysearch;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * <p>
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 */
public class FirstAndLastPositionOfElementInSortedArray {
	public static int[] searchRange(int[] nums, int target) {
		int start = elementIndex(nums, target, 0, nums.length - 1, true);

		if (start == -1) {
			return new int[]{-1, -1};
		}
		int end = elementIndex(nums, target, 0, nums.length - 1, false);

		return new int[]{start, end};
	}

	private static int elementIndex(int[] nums, int target, int low, int high, boolean isSearchForStartIndex) {
		int index = -1;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (nums[mid] == target) {
				index = mid;
				if (isSearchForStartIndex) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{8, 8};
		int target = 8;
		System.out.println(Arrays.toString(searchRange(nums, target)));
	}
}