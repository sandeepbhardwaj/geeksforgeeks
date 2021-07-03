package com.koko.array;

import java.util.*;

/**
 * 15. 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * <p>
 * Input: nums = []
 * Output: []
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: []
 */
public class ThreeSum {

	/**
	 * Using two sum problem
	 *
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> set = new HashSet<>();

		// nums.length - 1 to avoid IndexOutOfBoundException, j=i+1
		for (int i = 0; i < nums.length - 1; i++) {
			// excluding first element and calculate target then sub problem becomes twosum
			int target = 0 - (nums[i]);

			// store target-num[i] as key and index as value
			Map<Integer, Integer> map = new HashMap<>();

			for (int j = i + 1; j < nums.length; j++) {
				//check if (target-num[j]) is already exit
				if (map.containsKey(nums[j])) {
					List<Integer> r = new ArrayList<>();
					//1st element
					r.add(nums[i]);
					// 2nd element :- map.get(nums[j]) returns index of element, nums[map.get(nums[j])] returns element
					r.add(nums[map.get(nums[j])]);
					//3rd element
					r.add(nums[j]);

					//sort the triplets
					Collections.sort(r);
					//set will remove duplicate triplets
					set.add(r);
				}
				map.put(target - nums[j], j);
			}
		}

		return new ArrayList<>(set);
	}
}
