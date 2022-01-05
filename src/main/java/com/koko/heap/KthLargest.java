package com.koko.heap;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * <p>
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * <p>
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class KthLargest {
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int num : nums) {
			minHeap.add(num);

			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		return minHeap.peek();
	}

	public static int findKthSmallest(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b.compareTo(a));

		for (int num : nums) {
			maxHeap.add(num);

			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		return maxHeap.peek();
	}

	public static void main(String[] args) {
		int[] nums = new int[]{3, 2, 1, 5, 6, 4};
		int k = 2;
		System.out.println(findKthLargest(nums, k));
		System.out.println(findKthSmallest(nums, k));
	}
}
