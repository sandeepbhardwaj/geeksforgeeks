package com.leetcode;

/**
 * 104. Maximum Depth of Binary Tree Given a binary tree, find its maximum
 * depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7], return its depth = 3.
 */
public class MaximumDepthOfBTree {
	public int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		return Math.max(left, right) + 1;
	}
}