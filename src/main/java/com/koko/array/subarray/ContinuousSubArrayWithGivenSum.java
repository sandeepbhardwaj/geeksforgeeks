package com.koko.array.subarray;

public class ContinuousSubArrayWithGivenSum {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 7, 21};
		int[] output = checkSum(arr, 0);

		for (int i : output) {
			System.out.print(i + " ");
		}

	}

	/**
	 * Simple sliding window technique. This will work only for array containing
	 * positive numbers only.
	 *
	 * @param arr
	 * @param sum
	 * @return index of sub array contains given sum
	 */
	public static int[] checkSum(int[] arr, int sum) {
		int left = 0;
		int right = 0;
		int curr_sum = arr[left];

		while (right < arr.length && left <= right) {
			if (curr_sum == sum) {
				return new int[]{left, right};
			}

			if (curr_sum < sum) {
				right++;
				curr_sum += arr[right];
			} else if (curr_sum > sum) {
				curr_sum -= arr[left];
				left++;
			}
		}
		return new int[]{-1, -1};
	}

}
