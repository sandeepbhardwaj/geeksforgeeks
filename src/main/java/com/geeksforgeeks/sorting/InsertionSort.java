package com.geeksforgeeks.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 6, 1, 8, 10, 5 };

		insertionSort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int valueToInserted = arr[i];
			int hole = i;

			while (hole > 0 && arr[hole - 1] > valueToInserted) {
				arr[hole] = arr[hole - 1];
				hole--;
			}

			// insert the value
			arr[hole] = valueToInserted;
		}
	}
}
