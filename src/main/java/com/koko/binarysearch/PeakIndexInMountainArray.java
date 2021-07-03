package com.koko.binarysearch;

/**
 * 852. Peak Index in a Mountain Array
 * <p>
 * Let's call an array A a mountain if the following properties hold:
 * <p>
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * <p>
 * Example 1:
 * <p>
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [0,2,1,0]
 * Output: 1
 */
public class PeakIndexInMountainArray {
	public int peakIndexInMountainArray(int[] A) {

		if (A == null || A.length == 0)
			return -1;

		int low = 0;
		int high = A.length - 1;

		// low should be always smaller than high to avoid ArrayIndexOutOfBoundException
		while (low < high) {
			int mid = low + (high - low) / 2;

			if (A[mid] < A[mid + 1]) { // mid is smaller than its next element
				low = mid + 1;
			} else if (A[mid] < A[mid - 1]) { // mid is smaller than its previous element
				high = mid;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
