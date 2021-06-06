package com.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSum_II {

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> result = new ArrayList<>();
		findPaths(root, targetSum, new ArrayList<Integer>(), result);
		return result;
	}

	private void findPaths(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
		if (root == null)
			return;

		currentPath.add(root.val);

		//leaf node and sum found
		if (root.left == null && root.right == null && targetSum == root.val) {
			result.add(new ArrayList<>(currentPath));
			return;
		}

		findPaths(root.left, targetSum - root.val, new ArrayList<Integer>(currentPath), result);
		findPaths(root.right, targetSum - root.val, new ArrayList<Integer>(currentPath), result);
	}

}
