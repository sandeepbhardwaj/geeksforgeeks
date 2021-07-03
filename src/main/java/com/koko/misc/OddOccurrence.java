package com.koko.misc;

import java.util.Scanner;

/**
 * <pre>
 * Given an array of positive integers. All numbers occur even number of times
 * except one number which occurs odd number of times. Find the number.
 *
 * Expected
 * 		Time Complexity: O(n)
 * 		Expected Auxiliary Space: Constant
 *
 * Input 1 5 8 4 4 8 23
 *
 * Output 23
 * </pre>
 *
 * @author sbha47
 */
public class OddOccurrence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();

		for (int i = 0; i < noOfTestCases; i++) {
			int sizeOfArr = sc.nextInt();

			// populate array
			int result = 0;
			for (int j = 0; j < sizeOfArr; j++) {

				result = result ^ sc.nextInt();
			}
			System.out.println(result);
		}
		sc.close();
	}
}
