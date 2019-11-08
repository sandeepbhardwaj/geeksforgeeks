package com.interview;

import java.util.List;

public class SplitArrayBasedOnSum {

	public static int split(List<Integer> arr) {
		int count = 0;
		int totalSum = 0;
		for (Integer i : arr) {
			totalSum += i;
		}
		int leftSum = arr.get(0);
		int rightSum = totalSum;

		for (int i = 1; i < arr.size(); i++) {
			int integer = arr.get(i);
			leftSum += integer;
			rightSum = rightSum - integer;
			if (leftSum > rightSum) {
				count++;
			}
		}
		return count;
	}
}
