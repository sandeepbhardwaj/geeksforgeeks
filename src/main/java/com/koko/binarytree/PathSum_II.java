package com.koko.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node
 * values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 * <p>
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 */
public class PathSum_II {

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> result = new ArrayList<>();
		preOrder(root, targetSum, new ArrayList<Integer>(), result);
		return result;
	}

	private void preOrder(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
		if (root == null)
			return;

		currentPath.add(root.val);

		//leaf node and sum found
		// targetSum == root.val OR targetSum - root.val == 0
		if (root.left == null && root.right == null && targetSum == root.val) {
			result.add(new ArrayList<>(currentPath));
			return;
		}

		if (root.left != null) preOrder(root.left, targetSum - root.val, new ArrayList<Integer>(currentPath), result);
		if (root.right != null) preOrder(root.right, targetSum - root.val, new ArrayList<Integer>(currentPath), result);
	}

}
