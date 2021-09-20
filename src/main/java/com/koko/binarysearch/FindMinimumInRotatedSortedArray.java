package com.koko.binarysearch;

/**
 * 153. Find Minimum in Rotated Sorted Array (Pivot Element)
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

	/**
	 * (1) loop is left < high, which means inside the loop, left always < high
	 * (2) since we use round up for mid, and left < high from (1), high would never be the same as mid
	 * (3) Therefore, we compare mid with high, since they will never be the same from (2)
	 * (4) if nums[mid] < nums[high], we will know the minimum should be in the left part, so we are moving high.
	 * We can always make high = mid while we don't have to worry the loop will not ends. Since from (2),
	 * we know high would never be the same as mid, making high = mid will assure the interval is shrinking.
	 * <p>
	 * (5) if nums[mid] > nums[high], minimum should be in the high part, so we are moving left. Since nums[mid] > nums[high],
	 * mid can't be the minimum, we can safely move low to mid + 1, which also assure the interval is shrinking
	 */
	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		// why < not <= ? because we want to partition of array not looking for target element
		while (low < high) {
			int mid = low + ((high - low) / 2);

			if (nums[mid] < nums[high]) {
				high = mid;
			} else if (nums[mid] > nums[high]) {
				low = mid + 1;
			}
		}
		return nums[low];
	}
}