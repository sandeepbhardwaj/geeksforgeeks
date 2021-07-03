package com.koko.misc;

import java.util.Scanner;

/**
 * <pre>
 * Given an unsorted integer (positive values only) array of size �n�, we can
 * form a group of two or three only, the group should be such that the sum of
 * all elements in that group is a multiple of 3. Count all possible number of
 * groups that can be generated in this way.
 *
 * Input: arr[] = {3, 6, 7, 2, 9}
 * Output: 8 Groups are {3,6}, {3,9}, {9,6}, {7,2}, {3, 6,9}, {3, 7, 2}, {7, 2, 6}, {7, 2, 9}
 *
 * Input: 42 68 35 1 70 25 79 59 63 65 6 46 82 28 62 92 96 43 28 37 92 5 3 54 93 83 22 17 19 96 48 27 72 39 70 13 68 100 36 95 4 12 23
 *
 * Its Correct output is: 4122
 *
 * And Your Output is: 552
 *
 * </pre>
 */
public class PossibleGroups {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int noOfTestCases = sc.nextInt();

		for (int t = 0; t < noOfTestCases; t++) {
			int sizeOfArray = sc.nextInt();
			int[] arr = new int[sizeOfArray];

			for (int i = 0; i < sizeOfArray; i++) {
				arr[i] = sc.nextInt();
			}

			int group = 0;

			// one less then size of array
			for (int i = 0; i < sizeOfArray; i++) {
				int j = i + 1;
				while (j < sizeOfArray) {
					if ((arr[i] + arr[j]) % 3 == 0) {
						group++;
					}

					int k = j;
					while (k + 1 < sizeOfArray) {
						if ((arr[i] + arr[j] + arr[k + 1]) % 3 == 0) {
							group++;
						}
						k++;
					}
					j++;
				}

			}
			System.out.println(group);
		}
		sc.close();
	}
}
