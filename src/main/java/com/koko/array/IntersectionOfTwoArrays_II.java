package com.koko.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 350. Intersection of Two Arrays II
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
 * appear as many times as it shows in both arrays and you may return the result in any order.
 * <p>
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * <p>
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * <p>
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into
 * the memory at once?
 * link : https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/282372/Java-solution-with-all-3-follow-up-questions
 */
public class IntersectionOfTwoArrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            int freq = map.getOrDefault(i, 0);
            map.put(i, freq + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.get(i) != null && map.get(i) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
