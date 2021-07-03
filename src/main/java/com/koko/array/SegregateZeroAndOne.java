package com.koko.array;

public class SegregateZeroAndOne {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1};

		int start = 0;
		int end = arr.length - 1;

		while (start < end) {

			// swap
			if (arr[start] == 1 && arr[end] == 0) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;

				// increment start and decrement end
				start++;
				end--;
			}

			if (arr[start] == 1 && arr[end] != 0)
				end--;

			if (arr[start] != 1 && arr[end] == 0)
				start++;

		}

		for (int element : arr) {
			System.out.print(" " + element);
		}
	}

}
