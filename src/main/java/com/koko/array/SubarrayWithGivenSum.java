package com.koko.array;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithGivenSum {

	public static int[] subArrayWithGivenSumWithNegative(int[] nums, int k) {
		int[] result = new int[2];

		//preSum as key and index as value
		Map<Integer, Integer> preSum = new HashMap<>();

		int currentSum = 0;

		for (int i = 0; i < nums.length; i++) {
			currentSum += nums[i];

			//check whether currentSum - k = 0, if 0 it means
			// the sub array is starting from index 0
			if (currentSum - k == 0) {
				result[0] = 0;
				result[1] = i;
				break;
			}

			if (preSum.containsKey(currentSum - k)) {
				result[0] = preSum.get(currentSum - k) + 1;
				result[1] = i;
				break;
			}

			preSum.put(currentSum, i);
		}

		return result;
	}


	public static void main(String[] args) {
		//Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
		/*int[] nums = {10, 2, -2, -20, 10};
		int k = -10;
		int[] result = subArrayWithGivenSumWithNegative(nums, k);

		System.out.println("Sum found between indexes "+result[0]+" and "+result[1]);*/

		//Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
		int[] nums = {1, 4, 20, 3, 10, 5};
		int k = 33;
		int[] result = subArrayWithGivenSumWithNegative(nums, k);

		System.out.println("Sum found between indexes " + result[0] + " and " + result[1]);
	}
}
