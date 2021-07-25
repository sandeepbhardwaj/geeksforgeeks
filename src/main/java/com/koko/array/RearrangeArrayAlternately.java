package com.koko.array;

import java.util.Arrays;

/**
 * Rearrange Array Alternately
 * <p>
 * Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first
 * element should be max value, second should be min value, third should be second max, fourth should be second min and
 * so on.
 * <p>
 * Example 1:
 * Input:
 * N = 6
 * arr[] = {1,2,3,4,5,6}
 * Output: 6 1 5 2 4 3
 * Explanation: Max element = 6, min = 1,
 * second max = 5, second min = 2, and
 * so on... Modified array is : 6 1 5 2 4 3.
 */
public class RearrangeArrayAlternately {

	public static void rearrange(int arr[], int n) {
		int maxIndex = n - 1;
		int minIndex = 0;
		int max = arr[n - 1] + 1;

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				arr[i] = (arr[maxIndex] % max) * max + arr[i];
				maxIndex--;
			} else {
				arr[i] = (arr[minIndex] % max) * max + arr[i];
				minIndex++;
			}
		}

		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] / max;
		}

		Arrays.stream(arr).forEach(System.out::println);
	}

	public static void main(String[] args) {
		int n = 6;
		int arr[] = {1, 2, 3, 4, 5, 6};
		rearrange(arr, n);
	}

}
