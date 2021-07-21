package com.koko.misc;

/**
 * 172. Factorial Trailing Zeroes
 * <p>
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 * <p>
 * Example 1:
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * <p>
 * Example 2:
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * <p>
 * Example 3:
 * Input: n = 0
 * Output: 0
 */
public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int result = 0;
		for (int i = 5; i <= n; i = i * 5) {
			result = result + n / i;
		}
		return result;
	}
}
