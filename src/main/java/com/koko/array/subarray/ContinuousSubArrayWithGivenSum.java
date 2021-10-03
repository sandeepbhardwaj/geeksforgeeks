package com.koko.array.subarray;

public class ContinuousSubArrayWithGivenSum {

	private static int[] sum(int[] nums, int sum) {
		int left = 0;
		int right = 0;
		int current_sum = 0;

		while (right < nums.length && left <= right) {
			current_sum += nums[right];

			while (current_sum > sum) {
				current_sum -= nums[left];
				left++;
			}

			if (current_sum == sum) {
				return new int[]{left, right};
			}

			right++;
		}
		return new int[]{-1, -1};
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

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 7, 21};
		int[] output = sum(arr, 28);

		for (int i : output) {
			System.out.print(i + " ");
		}
	}

}
