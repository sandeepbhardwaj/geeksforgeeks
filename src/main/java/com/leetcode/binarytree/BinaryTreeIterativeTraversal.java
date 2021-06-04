package com.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeIterativeTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {

			//add and move to left till end of tree
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			//once all left ends pop from stack
			current = stack.pop();
			result.add(current.val);
			//go to right tree
			current = current.right;
		}

		return result;
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			//pop root element
			TreeNode node = stack.pop();
			result.add(node.val);

			if (node.right != null)
				stack.push(node.right);

			if (node.left != null)
				stack.push(node.left);
		}
		return result;
	}
}
