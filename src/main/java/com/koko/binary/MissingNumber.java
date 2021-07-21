package com.koko.binary;

/**
 * 268. Missing Number
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is
 * missing from the array.
 * <p>
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 * <p>
 * Example 1:
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the
 * range since it does not appear in nums.
 * <p>
 * Example 2:
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the
 * range since it does not appear in nums.
 * <p>
 * Example 3:
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the
 * range since it does not appear in nums.
 * <p>
 * Example 4:
 * Input: nums = [0]
 * Output: 1
 * Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the
 * range since it does not appear in nums.
 */
public class MissingNumber {
	public static int missingNumber(int[] nums) {
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			res = res ^ i ^ nums[i]; // a^b^b = a
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
		System.out.println(nums);
	}
}
