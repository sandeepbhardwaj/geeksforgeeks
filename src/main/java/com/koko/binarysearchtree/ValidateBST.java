package com.koko.binarysearchtree;

import com.koko.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * <p>
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
		return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean valid(TreeNode node, long minRange, long maxRange) {
		if (node == null)
			return true;

		if (node.val <= minRange || node.val >= maxRange) return false;

		return valid(node.left, minRange, node.val) && valid(node.right, node.val, maxRange);
	}
}
