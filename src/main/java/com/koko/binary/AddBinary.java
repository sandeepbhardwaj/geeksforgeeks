package com.koko.binary;

/**
 * 67. Add Binary
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * <p>
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {
	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();

		int i = a.length() - 1;
		int j = b.length() - 1;

		int carry = 0;

		while (i >= 0 && j >= 0) {
			int sum = carry + (a.charAt(i) - '0') + (b.charAt(j) - '0');
			sb.append(sum % 2);
			carry = sum / 2;

			i--;
			j--;
		}

		while (i >= 0) {
			int sum = carry + (a.charAt(i) - '0');
			sb.append(sum % 2);
			carry = sum / 2;
			i--;
		}

		while (j >= 0) {
			int sum = carry + (b.charAt(j) - '0');
			sb.append(sum % 2);
			carry = sum / 2;
			j--;
		}

		if (carry != 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
	}

	public String addBinary2(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (j >= 0) sum += b.charAt(j--) - '0';
			if (i >= 0) sum += a.charAt(i--) - '0';
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0) sb.append(carry);
		return sb.reverse().toString();
	}
}
