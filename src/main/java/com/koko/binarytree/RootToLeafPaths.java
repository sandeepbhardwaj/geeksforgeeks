package com.koko.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * <p>
 * A leaf is a node with no children.
 */
public class RootToLeafPaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		return preOrder(root, "", result);
	}

	/**
	 * Preorder traversal , visit root node first and then its children
	 *
	 * @param node
	 * @param path
	 * @param result
	 * @return
	 */
	public List<String> preOrder(TreeNode node, String path, List<String> result) {
		if (node == null)
			return result;

		//for leaf node
		if (node.left == null && node.right == null) {
			result.add(new String(path + node.val));
			return result;
		}

		if (node.left != null) preOrder(node.left, path + node.val + "->", result);
		if (node.right != null) preOrder(node.right, path + node.val + "->", result);
		return result;
	}

}
