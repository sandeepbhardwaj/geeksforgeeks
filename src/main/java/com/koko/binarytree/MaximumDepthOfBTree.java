package com.koko.binarytree;

import com.koko.TreeNode;

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

	//"Bottom-up" Solution >> postOrder traversal | bottom_up(root)
	public int maxDepth(TreeNode root) {

		if (root == null)
			return 0;

		int left_depth = maxDepth(root.left);
		int right_depth = maxDepth(root.right);

		// +1 because root is not null so depth should be greater than 1
		return 1 + Math.max(left_depth, right_depth);

	}

	//"Top-down" Solution >> preOrder traversal | top_down(root, params)
	int maxDepth = 0;

	public void maxDepthTopDown(TreeNode root, int depth) {

		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			maxDepth = Math.max(maxDepth, depth);
		}
		maxDepthTopDown(root.left, depth + 1);
		maxDepthTopDown(root.right, depth + 1);
	}


}
