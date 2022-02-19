package com.koko.binarytree;

import com.koko.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. Symmetric Tree
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * But the following [1,2,2,null,3,null,3] is not:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return root == null || checkSymmetric(root.left, root.right);
	}

	private boolean checkSymmetric(TreeNode leftTree, TreeNode righTree) {
		if (leftTree == null && righTree == null) {
			return true;
		} else if (leftTree != null && righTree != null) {
			return leftTree.val == righTree.val && checkSymmetric(leftTree.left, righTree.right) && checkSymmetric(leftTree.right, righTree.left);
		}
		//if one tree is null and another is not null
		return false;
	}

	public boolean isSymmetricIterative(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> q = new LinkedList();

		q.add(root.left);
		q.add(root.right);
		while (!q.isEmpty()) {
			TreeNode left = q.poll();
			TreeNode right = q.poll();
			if (left == null && right == null)
				continue;
			if (left == null || right == null || left.val != right.val)
				return false;
			q.add(left.left);
			q.add(right.right);
			q.add(left.right);
			q.add(right.left);

		}
		return true;

	}

}
