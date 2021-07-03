package com.koko;

/**
 * 136. Single Number
 * <p>
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1] Output: 1 Example 2:
 * <p>
 * Input: [4,1,2,1,2] Output: 4
 */
public class SingleNumber {
	public static int singleNumber(int[] nums) {
		int result = 0;

		for (int num : nums) {
			result ^= num;
		}
		return result;
	}


	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 2, 3, 3, 4};

		System.out.println("Result :" + singleNumber(nums));
	}
}
