package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		//Step 1. convert decimal number to binary number
		String binary = decimalToBinary(num);

		//Step 2. complement of binary number - just flip the bits
		String complement = "";
		for (char c : binary.toCharArray()) {
			char flip = (c == '0') ? '1' : '0';
			complement += flip;
		}

		//Step 3. convert complement binary number to decimal number
		int decValue = binaryToDecimal(complement);
		return decValue;
	}


	/**
	 * Code to convert decimal to Binary
	 *
	 * @param decimalNumber
	 * @return binary representation of decimal number
	 */
	public static String decimalToBinary(int decimalNumber) {
		StringBuilder binaryNumber = new StringBuilder();

		while (decimalNumber != 0) {
			binaryNumber.append(decimalNumber % 2);// to store rem
			decimalNumber = decimalNumber / 2;
		}

		return binaryNumber.reverse().toString();
	}

	/**
	 * Convert binary number to decimal number
	 *
	 * @param binaryNumber
	 * @return decimal representation of binary number
	 */
	public static int binaryToDecimal(String binaryNumber) {
		int base = 1; //2^0
		int decValue = 0;
		for (int j = binaryNumber.length() - 1; j >= 0; j--) {
			if (binaryNumber.charAt(j) == '1') {
				decValue += base;
			}
			base = base * 2; // 2^0*2=2^1, 2^0*2*2=2^2
		}
		return decValue;
	}


	public static void main(String[] args) {
		//500 - 111110100
		System.out.println("Decimal 7 to Binary :" + decimalToBinary(7));
	}
}
