package com.leetcode.array;

import java.util.Arrays;

/**
 * 41. First Missing Positive
 * <p>
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 * <p>
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 * <p>
 * Example 1:
 * Input: [1,2,0]
 * Output: 3
 * <p>
 * Example 2:
 * Input: [3,4,-1,1]
 * Output: 2
 * <p>
 * Example 3:
 * Input: [7,8,9,11,12]
 * Output: 1
 */
public class FirstMissingSmallestPositiveInteger {

	public static void main(String[] args) {
		int[] arr = new int[]{3, 4, -1, 1};

		System.out.println(firstMissingPositive(arr));
	}

	// once all numbers are made positive, if any number is found in range [1,N] then attach -ve sign to the
	// corresponding index. So for 1, 0th element becomes -ve, for 2 it is 1st considering 0 based index. That's all
	public static int firstMissingPositive(int[] nums) {

		int dummy = nums.length + 2;
		int size = nums.length;

		// 1. mark numbers (num < 0) and (num > n) with a special marker number dummy(n+2)
		// (we can ignore those because if all number are > n then we'll simply return 1)
		// for negative and numbers larger than length
		for (int i = 0; i < size; i++) {
			if (nums[i] <= 0 || nums[i] > size) {
				nums[i] = dummy;
			}
		}
		// note: all number in the array are now positive, and on the range 1..n+2
		System.out.println(Arrays.toString(nums));

		// 2. mark each cell appearing in the array, by converting the index for that number to negative
		for (int i = 0; i < size; i++) {
			//ignore dummy numbers
			if (nums[i] == dummy || nums[i] == -dummy) {
				continue;
			}

			int index = Math.abs(nums[i]) - 1;
			nums[index] = -Math.abs(nums[index]);
		}
		System.out.println(Arrays.toString(nums));

		// 3. find the first cell which isn't negative (doesn't appear in the array)
		for (int i = 0; i < size; i++) {
			if (nums[i] >= 0)
				return i + 1;
		}

		// 4. no positive numbers were found, which means the array contains all numbers 1..n
		return size + 1;
	}
}