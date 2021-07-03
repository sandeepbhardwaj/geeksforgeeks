package com.koko.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be
 * unique and you may return the result in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * <p>
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 */
public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> result = new HashSet<>();

		Set<Integer> set = new HashSet<>();

		//add all the elements in set
		for (int num : nums1)
			set.add(num);

		for (int num : nums2) {
			if (set.contains(num))
				result.add(num);
		}

		return result.stream()
				.mapToInt(Integer::intValue)
				.toArray();

	}
}
