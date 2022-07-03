package com.koko.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);

		List<List<Integer>> result = new ArrayList<>();
		backtrack(0, new ArrayList<>(), candidates, target, result);
		return result;
	}

	private void backtrack(int start, List<Integer> current, int[] candidates, int target, List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(current));
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1]) continue;
			// optimization: early stopping
			if (target - candidates[i] < 0) break;

			current.add(candidates[i]);
			backtrack(i + 1, current, candidates, target - candidates[i], result);
			current.remove(current.size() - 1);
		}
	}
}
