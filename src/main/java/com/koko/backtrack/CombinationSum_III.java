package com.koko.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_III {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		int target = n;

		backtrack(1, new ArrayList<>(), result, n, k);
		return result;
	}

	private void backtrack(int start, List<Integer> current, List<List<Integer>> result, int target, int k) {
		if (current.size() == k && target == 0) {
			result.add(new ArrayList<Integer>(current));
			return;
		}

		for (int i = start; i <= 9; i++) {
			current.add(i);
			backtrack(i + 1, current, result, target - i, k);
			current.remove(current.size() - 1);
		}
	}
}
