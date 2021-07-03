package com.koko.misc;

import java.util.Arrays;

public class MeanderingArray {

	public static void main(String[] args) {
		int[] testArr = {-1, 1, 2, 3, -5};
		System.out.println(Arrays.toString(arrangeLargeSmall(testArr)));
	}

	public static int[] arrangeLargeSmall(int[] arr) {
		// sort the array
		Arrays.sort(arr);

		int[] outputArr = new int[arr.length];

		int left = 0;
		int right = arr.length - 1;

		int k = 0;
		while (k < arr.length - 1) {
			// adding largest
			outputArr[k] = arr[right--];
			k++;
			// adding smallest
			outputArr[k] = arr[left++];
			k++;
		}

		if (left == right) {
			outputArr[k] = arr[left];
		}

		return outputArr;
	}
}
