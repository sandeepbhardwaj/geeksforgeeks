package com.koko.binarysearchtree;

import com.koko.TreeNode;

/**
 * 701. Insert into a Binary Search Tree
 * <p>
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the
 * original BST.
 */
public class InsertInToBST {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);

		if (root.val > val) {
			root.left = insertIntoBST(root.left, val);
		} else {
			root.right = insertIntoBST(root.right, val);
		}

		return root;
	}
}
