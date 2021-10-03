package com.koko.array.subarray;

import java.util.*;

/**
 * 239. Sliding Window Maximum
 * <p>
 * Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.
 * <p>
 * Example
 * Input 1: A = [1, 3, -1, -3, 5, 3, 6, 7] ,k = 3
 * Output: [3, 3, 5, 5, 6, 7]
 * <p>
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * Example 3:
 * Input: nums = [1,-1], k = 1
 * Output: [1,-1]
 * <p>
 * Example 4:
 * Input: nums = [9,11], k = 2
 * Output: [11]
 * <p>
 * Example 5:
 * Input: nums = [4,-2], k = 2
 * Output: [4]
 */
public class SlidingWindowMaximum {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();

		int left = 0;
		int right = 0;
		// creating the max heap ,to get max element always
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		while (right < nums.length) {
			queue.add(nums[right]);

			if (right - left + 1 < k) {
				right++;
			} else if (right - left + 1 == k) {
				result.add(queue.peek());

				queue.remove(nums[left]);
				left++;
				right++;
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		int[] nums={1, -1};
		int k=1;
		int[] result=maxSlidingWindow(nums,k);

		for(int e:result)
			System.out.print(" "+e);
	}
}
