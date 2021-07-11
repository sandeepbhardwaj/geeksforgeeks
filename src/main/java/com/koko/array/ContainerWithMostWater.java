package com.koko.array;

/**
 * 11. Container With Most Water
 * <p>
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * Example:
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7] Output: 49
 * <p>
 * Idea/Proof:
 * <p>
 * The widest container (using first and last line) is a good candidate, because
 * of its width. Its water level is the height of the smaller one of first and
 * last line. All other containers are less wide and thus would need a higher
 * water level in order to hold more water. The smaller one of first and last
 * line doesn't support a higher water level and can thus be safely removed from
 * further consideration.
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int maxArea = 0;

		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));

			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}
}