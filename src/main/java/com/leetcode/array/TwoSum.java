package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

	/**
	 * two sum in single pass
	 * @param nums
	 * @param target
	 * @return
	 */
    public int[] twoSum(int[] nums, int target) {
    	// store target-num[i] as key and index as value
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

        	//check if (target-num[i]) is already exit
        	if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }

        	// for num[0]=2 , 7 as key and 0 as value {7,0}
            map.put(target - nums[i], i);
        }
        return null;
    }

}