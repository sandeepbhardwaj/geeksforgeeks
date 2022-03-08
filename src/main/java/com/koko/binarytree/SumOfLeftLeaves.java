package com.koko.binarytree;

import com.koko.TreeNode;

/**
 * 404. Sum of Left Leaves
 */
public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;

		return sumOfLeftLeaves(root, false);
	}

	int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null && isLeft) {
			return root.val;
		}
		return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
	}
}
