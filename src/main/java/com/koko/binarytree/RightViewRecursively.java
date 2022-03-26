package com.koko.binarytree;

import com.koko.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 */
public class RightViewRecursively {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		rightView(root, 0, result);

		return result;
	}


	public void rightView(TreeNode node, int level, List<Integer> result) {
		if (node == null) return;

		if (result.size() == level) {
			result.add(node.val);
		}

		rightView(node.right, level + 1, result);
		rightView(node.left, level + 1, result);
	}
}
