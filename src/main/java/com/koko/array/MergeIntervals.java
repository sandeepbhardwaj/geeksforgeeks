package com.koko.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. Merge Intervals
 * <p>
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array
 * of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * <p>
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
	public static int[][] merge(int[][] intervals) {
		// Sort by ascending starting point
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> result = new ArrayList<>();
		int[] prev = null;

		for (int[] inter : intervals) {
			//if prev is null (Ist element) OR prev end is smaller then
			if (prev == null || prev[1] < inter[0]) {
				result.add(inter);
				prev = inter;
			} else {
				//find max of end
				prev[1] = Math.max(prev[1], inter[1]);
			}
		}

		return result.toArray(new int[result.size()][2]);
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};

		int[][] result = merge(intervals);
	}
}
