package com.koko.binarytree;

/**
 * Diameter of BT using global variable.
 */
public class DiameterOfBTree_2 {
	int max = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return max;
	}

	private int maxDepth(TreeNode root) {
		if (root == null) return 0;

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		max = Math.max(max, left + right);

		return Math.max(left, right) + 1;
	}
}
