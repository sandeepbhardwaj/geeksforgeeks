package com.leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * <p>
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder
 * is the inorder traversal of the same tree, construct and return the binary tree.
 */
public class BinaryTreeFromPreorderAndInorderTraversal {
	int preOrderIndex;
	Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		preOrderIndex = 0;

		for (int i = 0; i < inorder.length; i++) {
			inOrderIndexMap.put(inorder[i], i);
		}
		return buildTree(preorder, 0, inorder.length - 1);
	}

	private TreeNode buildTree(int[] preorder, int left, int right) {
		if (left > right)
			return null;

		int rootValue = preorder[preOrderIndex++];
		TreeNode root = new TreeNode(rootValue);

		//left array from => 0 to ROOT_INDEX-1
		root.left = buildTree(preorder, left, inOrderIndexMap.get(rootValue) - 1);
		//right array from => ROOT_INDEX+1 to right
		root.right = buildTree(preorder, inOrderIndexMap.get(rootValue) + 1, right);
		return root;
	}
}
