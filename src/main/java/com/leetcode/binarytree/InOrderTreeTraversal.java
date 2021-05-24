package com.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTreeTraversal {
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
}
