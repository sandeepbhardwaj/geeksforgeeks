package com.interview.clearwater;

import java.util.List;

public class SplitArrayBasedOnSum {

	public static int split(List<Integer> arr) {
		int count = 0;
		int totalSum = 0;

		//total sum of all elements
		for (Integer i : arr) {
			totalSum += i;
		}

		int leftSum = arr.get(0);
		int rightSum = totalSum;

		for (int i = 1; i < arr.size(); i++) {
			leftSum += arr.get(i);
			rightSum = rightSum - arr.get(i);

			if (leftSum > rightSum) {
				count++;
			}
		}
		return count;
	}
}
