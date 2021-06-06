package com.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();

		String path = "";
		return preOrder(root, path, result);
	}

	public List<String> preOrder(TreeNode node, String path, List<String> result) {
		if (node == null)
			return result;

		// validate for leaf node
		if (node.left == null && node.right == null) {
			path += node.val;
			result.add(new String(path));
		}

		path = path + node.val + "->";
		preOrder(node.left, path, result);
		preOrder(node.right, path, result);
		return result;
	}

}
