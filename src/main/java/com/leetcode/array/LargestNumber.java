package com.leetcode.array;

import java.util.Arrays;

/**
 * 179. Largest Number
 * <p>
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * <p>
 * Example 1:
 * Input: nums = [10,2]
 * Output: "210"
 * <p>
 * Example 2:
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * <p>
 * Example 3:
 * Input: nums = [1]
 * Output: "1"
 * <p>
 * Example 4:
 * Input: nums = [10]
 * Output: "10"
 */
public class LargestNumber {
	public static void main(String[] args) {
		//int[] nums =new int[]{3,30,34,5,9};
		int[] nums = new int[]{10, 2};
		System.out.println(largestNumber(nums));
	}

	public static String largestNumber(int[] nums) {
		String[] array = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);

		Arrays.sort(array, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

		StringBuilder sb = new StringBuilder();
		for (String num : array) {
			sb.append(num);
		}
		return sb.toString().startsWith("00") ? "0" : sb.toString();
	}
}