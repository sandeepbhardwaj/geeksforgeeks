package com.koko.misc;

/**
 * <pre>
 * Given a positive integer n, find if it can be expressed as x^y where y > 1
 * and x > 0 and x and y both are both integers.
 *
 * Input: The first line of input contains an integer T denoting the no of test
 * cases. Then T test cases follow . Each test cases contains an integer N.
 *
 * Output: For each test case in a new line print 1 if the number can be
 * expressed as x^y else print 0.
 *
 * Constraints: 1<=T<=1000 1<=n<=100
 *
 * Example: Input: 2 8 5 Output: 1 0
 *
 * <pre>
 *
 * @author Sandeep Bhardwaj
 */
public class CheckXRaisedToPowerY {

	public static void main(String[] args) {
		int num = 1;
		boolean isRaised = false;

		for (int x = 2; x < num; x++) {
			if (num == 1) {
				isRaised = true;
				break;
			}

			int count = 0;
			int temp = num;
			while (temp % x == 0) {
				temp = temp / x;
				count++;
				if (temp == 1) {
					isRaised = true;
					System.out.println("CheckPower.main() :" + isRaised + " x :" + x + "^" + count);
					break;
				} else if (num < 1) {
					isRaised = false;
					break;
				}
			}
		}
		System.out.println("CheckPower.main() :" + isRaised);
	}

}
