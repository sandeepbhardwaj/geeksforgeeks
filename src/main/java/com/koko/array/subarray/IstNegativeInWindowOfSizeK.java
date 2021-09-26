package com.koko.array.subarray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * First negative integer in every window of size k
 * Given an array A[] of size N and a positive integer K, find the first negative integer for each and every
 * window(contiguous subarray) of size K.
 * <p>
 * Example 1:
 * <p>
 * Input : N = 5, A[] = {-8, 2, 3, -6, 10}, K = 2
 * Output : -8 0 -6 -6
 * Explanation :
 * First negative integer for each window of size k
 * {-8, 2} = -8
 * {2, 3} = 0 (does not contain a negative integer)
 * {3, -6} = -6
 * {-6, 10} = -6
 * <p>
 * Example 2:
 * Input : N = 8, A[] = {12, -1, -7, 8, -15, 30, 16, 28}, K = 3
 * Output : -1 -1 -7 -15 -15 0
 * <p>
 * Ref: https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1#
 */
public class IstNegativeInWindowOfSizeK {

	private static List<Integer> negativeInWindowOfSizeK(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();

		int left = 0, right = 0;

		Queue<Integer> queue = new LinkedList<>();

		while (right < nums.length) {
			queue.add(nums[right]);

			//if window is smaller than k , increase window size
			if (right - left + 1 < k) {
				right++;
			} else if (right - left + 1 == k) { // window is equal to k
				int element = 0;
				for (int e : queue) {
					if (e < 0) {
						element = e;
						break;
					}
				}
				result.add(element);

				queue.poll(); // remove first element added using left
				right++;
				left++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		//int[] nums = {-8, 2, 3, -6, 10};
		//int k=2
		int[] nums = {12, -1, -7, 8, -15, 30, 16, 28};
		int k = 3;
		System.out.println(negativeInWindowOfSizeK(nums, k));
	}
}
