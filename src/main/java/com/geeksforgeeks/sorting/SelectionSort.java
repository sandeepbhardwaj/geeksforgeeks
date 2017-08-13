package com.geeksforgeeks.sorting;

/**
 * <pre>
 * Selection sort is a in-place comparison-based algorithm in which the list is
 * divided into two parts, the sorted part at the left end and the unsorted part
 * at the right end. Initially, the sorted part is empty and the unsorted part
 * is the entire list.
 * 
 * The smallest element is selected from the unsorted array and swapped with the
 * leftmost element, and that element becomes a part of the sorted array. This
 * process continues moving unsorted array boundary by one element to the right.
 * 
 * 64 25 12 22 11 // this is the initial, starting state of the array
 * 
 * 11 25 12 22 64 // sorted sublist = {11}
 * 
 * 11 12 25 22 64 // sorted sublist = {11, 12}
 * 
 * 11 12 22 25 64 // sorted sublist = {11, 12, 22}
 * 
 * 11 12 22 25 64 // sorted sublist = {11, 12, 22, 25}
 * 
 * 11 12 22 25 64 // sorted sublist = {11, 12, 22, 25, 64}
 * 
 * worst case complexities are of Ο(n2)
 * 
 * <pre>
 * 
 * @author sandeep
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 2, 6, 1, 8, 10, 5 };

		for (int i = 0; i < arr.length; i++) {

			int minIndex = i;
			// Compare all the element with this current min
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}

			// swap min with current element
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
