package com.koko.binarytree;

import com.koko.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeViewRecursive {
	List<Integer> result = new ArrayList<>();

	public List<Integer> rightSideView(TreeNode root) {
		rightView(root, 0);
		return result;
	}

	public void rightView(TreeNode node, int level) {
		if (node == null)
			return;

		if (result.size() == level) {
			result.add(node.val);
		}
		rightView(node.right, level + 1); // for left view pass left first and then right
		rightView(node.left, level + 1);
	}
}
