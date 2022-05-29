package com.koko.array;

import java.util.Arrays;

/**
 * 31. Next Permutation
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * <p>
 * For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
 * More formally, if all the permutations of the array are sorted in one container according to their lexicographical
 * order, then the next permutation of that array is the permutation that follows it in the sorted container.
 * If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in
 * ascending order).
 * <p>
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger
 * rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 * <p>
 * The replacement must be in place and use only constant extra memory.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * <p>
 * Example 2:
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * <p>
 * Example 3:
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 */
public class NextPermutation {
	public static void nextPermutation(int[] nums) {
		//Step:-1 find the first decreasing sequence from end
		int i = nums.length - 2; // second last element

		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}


		//find number just greater than element and swap the two numbers
		// 1 1 5 4 1 >> 1 4 5 1 1
		if (i >= 0) {
			int j = nums.length - 1; // last element

			// compare 1 element with j to find out just greater element
			while (nums[j] <= nums[i]) {
				j--;
			}

			swap(nums, i, j);
		}


		// reverse the rest of the elements
		// 1 4 1 1 5
		reverse(nums, i + 1);

	}

	private static void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = {1, 1, 5, 4, 1};
		nextPermutation(nums);

		Arrays.stream(nums).forEach(n -> System.out.print(n + " ,"));
	}
}
