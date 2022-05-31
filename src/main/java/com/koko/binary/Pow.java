package com.koko.binary;

/**
 * 50. Pow(x, n)
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * <p>
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * <p>
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * <p>
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Pow {
	public double myPow_1(double x, int n) {
		double ans = 1.0;

		for (int i = 0; i < Math.abs(n); i++) {
			ans = ans * x;
		}

		//if n is negative then divide 1/ans
		if (n < 0) ans = 1 / ans;
		return ans;
	}

	/**
	 * Using Binary Exponentiation
	 */
	public static double myPow(double x, int n) {
		double ans = 1.0;

		long temp_n = n;
		// make it positive
		if (temp_n < 0) temp_n = temp_n * -1;

		while (temp_n > 0) {
			if (temp_n % 2 == 1) {
				ans = ans * x;
				temp_n = temp_n - 1;
			} else {
				x = x * x;
				temp_n = temp_n / 2;
			}
		}

		if (n < 0) ans = 1.0 / ans;
		return ans;

	}

	public static void main(String[] args) {
		System.out.println(myPow(2, 4));

	}


}
