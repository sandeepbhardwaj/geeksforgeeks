package com.geeksforgeeks.sorting;

/**
 * Bubble sort compares each pair of adjacent items and swaps them if they are
 * in the wrong order. The pass through the list is repeated until no swaps are
 * needed, which indicates that the list is sorted.
 * 
 * <pre>
 * Time complexity of Bubble Sort :-
 * Best Case for optimize bubble sort : O(n) 
 * Average case : O(n^2) 
 * Worst Case : O(n^2)
 * </pre>
 * 
 * @author sandeep
 *
 */
public class BubbleSort {

	private static void sort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {

			// reduce the length of inner loop every time by i because no need to run loop
			// in already sorted part
			int length = arr.length - i - 1;
			for (int j = 0; j < length; j++) {

				// swap
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	private static void optimizeSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean sorted = true;
			for (int j = 0; j < arr.length - i - 1; j++) {
				// swap
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					sorted = false;
				}
			}
			// if array is already sorted then no need to loop
			if (sorted)
				break;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 6, 1, 8, 10, 5 };

		sort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println("\nOptimize Bubble sort");
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		optimizeSort(arr1);

		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

}
