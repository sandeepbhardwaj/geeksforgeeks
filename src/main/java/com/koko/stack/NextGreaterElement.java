package com.koko.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Given an array arr[ ] of size N having distinct elements, the task is to find the next greater element for each
 * element of the array in order of their appearance in the array.
 */
public class NextGreaterElement {

	/**
	 * Function to find the next greater element for each element of the array.
	 * Input:
	 * N = 4, arr[] = [1 3 2 4]
	 * Output:
	 * 3 4 4 -1
	 */
	public static int[] nextGreaterToRight(int[] arr, int n) {
		int[] result = new int[n];

		Arrays.fill(result, -1);
		Stack<Integer> stack = new Stack<Integer>(); // stack to keep index of elements

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				result[stack.pop()] = arr[i];
			}

			stack.push(i);
		}

		return result;
	}

	/**
	 * Given an array a of integers of length n, find the nearest smaller number for every element such that the smaller
	 * element is on left side.If no small element present on the left print -1.
	 * <p>
	 * Input: n = 3
	 * a = {1, 6, 2}
	 * Output: -1 1 1
	 */
	public static List<Integer> nextSmallerToRight(int arr[], int n) {
		int[] result = new int[n];

		// stack for holding index of smaller number
		Stack<Integer> stack = new Stack<>();

		// loop from end makes it right smallest problem
		for (int i = n - 1; i >= 0; i--) {

			while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				result[stack.pop()] = arr[i];
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}

		return Arrays.stream(result).boxed().collect(Collectors.toList());
	}

	public static void main(String[] args) {
		int arr[] = {1, 6, 2};
		nextSmallerToRight(arr, 3).forEach(result -> System.out.print(result + " "));
	}

}
