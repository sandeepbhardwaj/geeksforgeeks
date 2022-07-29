package com.koko.misc;

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
	public static void main(String[] args) {
		System.out.println(reverse(-123));
	}

	//without using any long variable
	public static int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10; // -ve for -ve number
			x /= 10;          // -ve for -ve number
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))  // why 7 ? because due to max value
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) // why -8 ? because due to min value
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	public static int reverse1(int x) {
		long result = 0;

		// number % 10 = last digit of number ex. 123%10=3
		// number / 10 = get rid of last digit ex. 123/10 =12
		while (x != 0) {
			result = result * 10 + x % 10;
			x = x / 10;
		}

		if (Math.abs(result) > Integer.MAX_VALUE) {
			return 0;
		}
		return (int) result;
	}
}