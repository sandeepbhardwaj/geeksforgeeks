package com.koko.array;

/**
 * 43. Multiply Strings
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also
 * represented as a string.
 * <p>
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * <p>
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 */
public class MultiplyStrings {
	/*
            9   9
            9   9
       -----------------
	             8  1
	          8  1
	          8  1
	       8  1
       -----------------
           9  8  0  1
    */
	public String multiply(String num1, String num2) {
		int m = num1.length();
		int n = num2.length();

		int[] result = new int[n + m]; //array is 0 indexed

		//reverse loop we do multiply from right to left
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

				int sum = result[i + j + 1] + mul;

				result[i + j + 1] = sum % 10; //store at last index
				result[i + j] = result[i + j] + sum / 10; // store at second last index
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int num : result) {
			//Not to add leading zeros
			if (sb.length() != 0 || num != 0)
				sb.append(num);
		}

		return sb.length() == 0 ? "0" : sb.toString();
	}
}
