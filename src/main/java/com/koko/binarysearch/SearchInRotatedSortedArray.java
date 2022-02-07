package com.koko.binarysearch;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4 Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 */
public class SearchInRotatedSortedArray {
	public static int search(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return -1;

		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (nums[mid] == target)
				return mid;

			// low ..............mid-1, mid, mid+1.............high

			// first half is sorted
			// V.V.IMP why we are considering mid here not mid-1 ?
			// if we do mid-1 it may throw IndexOutOfBoundsException if [mid] points to 0
			if (nums[low] <= nums[mid]) {
				// element in b/w low and mid
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			// second half is sorted
			else {
				// element in b/w low and mid
				if (target >= nums[mid + 1] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
		int result = search(nums, 3);
		System.out.println(result);
	}
}