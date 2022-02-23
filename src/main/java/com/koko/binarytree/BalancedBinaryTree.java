package com.koko.binarytree;

import com.koko.TreeNode;

/**
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		// for single node or no node
		if (root == null || (root.left == null && root.right == null))
			return true;

		if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
			return true;
		} else {
			return false;
		}
	}

	private int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
