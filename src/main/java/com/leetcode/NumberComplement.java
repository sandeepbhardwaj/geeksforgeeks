package com.leetcode;

/**
 * 476. Number Complement
 * Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its
 * binary representation.
 * <p>
 * Example 1:
 * <p>
 * Input: num = 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010.
 * So you need to output 2.
 * Example 2:
 * <p>
 * Input: num = 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0.
 * So you need to output 0.
 */
public class NumberComplement {
	public int findComplement(int num) {
		//create binary number of num
		int[] binaryArr = new int[32];

		int i = 0;
		while (num != 0) {
			binaryArr[i] = num % 2; // to store rem
			num = num / 2;
			i++;
		}

		String binary = "";
		for (int j = i - 1; j >= 0; j--) {
			binary += binaryArr[j]; //reverse the array to get output
		}

		//complement of binary number
		String complement = "";
		for (char c : binary.toCharArray()) {
			char flip = (c == '0') ? '1' : '0';
			complement += flip;
		}

		//convert complement binary number to decimal number
		int base = 1; //2^0
		int decValue = 0;
		for (int j = complement.length() - 1; j >= 0; j--) {
			if (complement.charAt(j) == '1')
				decValue += base;
			base = base * 2;
		}
		return decValue;
	}
}
