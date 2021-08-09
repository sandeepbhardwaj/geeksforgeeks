package com.koko.binarytree;

/**
 * 543. Diameter of Binary Tree
 * <p>
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <p>
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <p>
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBTree {
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		// if diameter pass through root node
		int maxDepth = maxDepth(root.left) + maxDepth(root.right);

		// if diameter pass through internal node
		int maxDiameter = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));

		return Math.max(maxDepth, maxDiameter);
	}

	private int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

}
