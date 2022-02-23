package com.koko.binarytree;

import com.koko.TreeNode;

/**
 * 617. Merge Two Binary Trees
 * <p>
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are
 * overlapped while the others are not.
 * <p>
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up
 * as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * Output:
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * <p>
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 */
public class MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		if (t1 == null && t2 == null) return null;

		int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
		TreeNode newNode = new TreeNode(val);

		newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
		newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

		return newNode;

	}

	public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
		//if check is important
		if (root1 == null)
			return root2;
		if (root2 == null)
			return root1;

		root1.val = root1.val + root2.val;

		root1.left = mergeTrees1(root1.left, root2.left);
		root1.right = mergeTrees1(root1.right, root2.right);
		return root1;
	}
}
