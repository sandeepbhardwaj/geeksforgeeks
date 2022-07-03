package com.koko.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * Example 2:
 * Input: n = 1, k = 1
 * Output: [[1]]
 */
public class Combinations {
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(1, new ArrayList<>(), result, n, k);
		return result;
	}

	static void backtrack(int start, List<Integer> current, List<List<Integer>> result, int n, int k) {
		if (current.size() == k) {
			result.add(new ArrayList<Integer>(current));
		}

		for (int i = start; i <= n; i++) {
			current.add(i);
			backtrack(i + 1, current, result, n, k);
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = combine(4, 2);
		result.forEach(System.out::println);
	}
}
