package com.koko.array;

/**
 * 45. Jump Game II
 * <p>
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * You can assume that you can always reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 */
public class MinimumJump_2 {

	public static void main(String[] args) {
		int[] nums = new int[]{2, 3, 1, 1, 4};
		System.out.println(jump(nums));
	}

	public static int jump(int[] nums) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + nums[i]);

			//jump end if i=curEnd then increment the jumps and assign new curEnd
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}

			System.out.println("i:" + i + " element:" + nums[i] + " jumps:" + jumps + " curEnd:" + curEnd + " curFarthest:" + curFarthest);
		}
		return jumps;
	}
}
