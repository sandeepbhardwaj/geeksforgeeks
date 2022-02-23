package com.koko.binarytree;

import com.koko.TreeNode;

/**
 * 112. Path Sum
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such
 * that adding up all the values along the path equals targetSum.
 * <p>
 * A leaf is a node with no children.
 */
public class PathSum {

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;

		//if on leaf node and remaining sum is zero
		if (root.left == null && root.right == null && targetSum - root.val == 0)
			return true;

		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
	}

}
