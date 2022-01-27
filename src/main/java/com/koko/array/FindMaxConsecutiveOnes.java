package com.koko.array;

public class FindMaxConsecutiveOnes {
	public static int findMaxConsecutiveOnes(int[] nums) {
		int result = 0;
		int start = 0;
		int end = 0;

		while (start <= end && end < nums.length) {
			if (nums[end] == 1) {
				end++;
			} else {
				result = Math.max(result, end - start);
				end++; //move the end
				start = end; //reset the start
			}
		}
		return Math.max(result, end - start);
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 1, 0, 1, 1, 1};
		System.out.println(findMaxConsecutiveOnes(nums));
	}
}
