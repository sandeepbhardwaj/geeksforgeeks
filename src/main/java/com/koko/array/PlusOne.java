package com.koko.array;

/**
 * 66. Plus One
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array
 * contains a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * <p>
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * <p>
 * Example 3:
 * Input: digits = [0]
 * Output: [1]
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int n = digits.length;

		for (int i = n - 1; i >= 0; i--) {
			//if digit is less than 9
			if (digits[i] < 9) {
				//increment last number by one and return
				digits[i]++;
				return digits;
			}

			//if digit is 9
			digits[i] = 0;
		}

		//this will execute if all digits are 9
		int[] result = new int[n + 1];
		result[0] = 1;

		return result;

	}
}
