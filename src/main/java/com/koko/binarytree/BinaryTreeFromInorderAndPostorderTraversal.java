package com.koko.binarytree;

import com.koko.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * <p>
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder
 * is the postorder traversal of the same tree, construct and return the binary tree.
 */
public class BinaryTreeFromInorderAndPostorderTraversal {
	int postOrderIndex;
	Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

	/**
	 * last element of postorder is ROOT element
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		postOrderIndex = postorder.length - 1;

		for (int i = 0; i < inorder.length; i++) {
			inOrderIndexMap.put(inorder[i], i);
		}
		return buildTree(postorder, 0, inorder.length - 1);
	}

	/**
	 * Create right tree first then left tree
	 */
	private TreeNode buildTree(int[] postorder, int left, int right) {
		if (left > right)
			return null;

		int rootValue = postorder[postOrderIndex--];
		TreeNode root = new TreeNode(rootValue);

		//because we are using post order LRN >> we are moving from right to left
		//right array from => ROOT_INDEX+1 to right
		root.right = buildTree(postorder, inOrderIndexMap.get(rootValue) + 1, right);

		//left array from => 0 to ROOT_INDEX-1
		root.left = buildTree(postorder, left, inOrderIndexMap.get(rootValue) - 1);
		return root;
	}
}
