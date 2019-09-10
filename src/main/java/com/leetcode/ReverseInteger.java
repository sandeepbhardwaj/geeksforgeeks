package com.leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123 Output: 321 Example 2:
 * <p>
 * Input: -123 Output: -321 Example 3:
 * <p>
 * Input: 120 Output: 21
 */
public class ReverseInteger {
	public int reverse(int x) {
		long result = 0;

		while (Math.abs(x) > 0) {
			result = result * 10 + x % 10;
			x = x / 10;
		}

		if (Math.abs(result) > Integer.MAX_VALUE) {
			return 0;
		}
		return (int) result;
	}
}