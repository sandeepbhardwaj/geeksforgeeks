package com.leetcode;

import java.util.Arrays;

/**
 * 189. Rotate Array
 * <p>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArray {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
    }

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return;

        for (int i = 0; i < k; i++) {
            int j = nums.length - 1;

            int temp = nums[j];
            for (; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;

            Arrays.stream(nums).forEach(System.out::print);
            System.out.println();
        }
    }
}
