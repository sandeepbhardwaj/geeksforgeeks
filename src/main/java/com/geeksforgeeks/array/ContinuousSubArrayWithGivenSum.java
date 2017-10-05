package com.geeksforgeeks.array;

public class ContinuousSubArrayWithGivenSum {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 7, 21 };
		int[] output = checkSum(arr, 21);

		for (int i : output) {
			System.out.println(i);
		}

	}

	public static int[] checkSum(int[] arr, int sum) {
		int i = 0;
		int j = 1;
		int total = arr[i];

		// why i<j condition ?
		while (j < arr.length || i < j) {

			if (sum > total) {
				total += arr[j];
				j++;
			} else if (sum < total) {
				total -= arr[i];
				i++;
			}

			// why j-1 in output, because j is incremented above and we check the condition
			// after that.
			if (total == sum) {
				return new int[] { i, j - 1 };
			}
		}

		return new int[] { -1 };
	}

}
