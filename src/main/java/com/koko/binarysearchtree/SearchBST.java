package com.koko.binarysearchtree;

import com.koko.TreeNode;

/**
 * 700. Search in a Binary Search Tree
 * You are given the root of a binary search tree (BST) and an integer val.
 * <p>
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 */
public class SearchBST {
	public TreeNode searchBST(TreeNode root, int val) {

		while (root != null && root.val != val) {
			root = val < root.val ? root.left : root.right;
		}

		return root;
	}
}
