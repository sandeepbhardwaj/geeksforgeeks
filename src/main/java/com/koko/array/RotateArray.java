package com.koko.array;

import java.util.Arrays;

/**
 * 189. Rotate Array
 * <p>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArray {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		rotate(nums, 3);
	}

	/**
	 * Rotate array using reversal algorithm, this algo is useful in case of very large array.
	 * Step 1: Rotate complete array
	 * Step 2: Rotate 0 to k-1 elements (k-1 ? array is 0 indexed)
	 * Step 3: Rotate k to n-1 elements (n is length of array)
	 *
	 * @param nums
	 * @param k
	 */
	public void rotateUsingReversalAlgo(int[] nums, int k) {
		k = k % nums.length;

		//reverse complete array
		reverse(nums, 0, nums.length - 1);
		//reverse k elements
		reverse(nums, 0, k - 1);
		//reverse k to n elements
		reverse(nums, k, nums.length - 1);
	}

	private void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;
		}
	}


	// left <--  --> Right
	public static void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0)
			return;

		k = k % nums.length;

		while (k > 0) {
			int j = nums.length - 1;

			//store the last element in temp
			int temp = nums[j];

			//reverse loop for right rotation
			while (j > 0) {
				//replace last with second-last element
				nums[j] = nums[j - 1];
				j--;
			}
			//now j point to zero location
			nums[j] = temp;

			k--;
			System.out.println(Arrays.toString(nums));
		}
	}
}
