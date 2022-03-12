package com.koko.binarytree;

import com.koko.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeIterativeTraversal {

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

			if (node.right != null) stack.push(node.right);
			if (node.left != null) stack.push(node.left);
		}
		return result;
	}


	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();

		if (root == null)
			return result;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;

		while (!stack.isEmpty() || current != null) {
			//loop to go extreme left
			while (current != null) {
				stack.add(current);
				current = current.left;
			}

			//get the element from stack
			TreeNode node = stack.pop();
			result.add(node.val);

			//get the right of node if its null the above loop will not execute
			//and we will pop the element from stack
			current = node.right;
		}

		return result;
	}


	/**
	 * Simple solution
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversalUsingTwoStack(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();

		//add root to stack1
		stack1.add(root);

		while (!stack1.isEmpty()) {
			TreeNode node = stack1.pop();

			//add node to stack2
			stack2.add(node);

			//add left first and then right
			if (node.left != null) stack1.add(node.left);
			if (node.right != null) stack1.add(node.right);

		}

		//stack2 holds the result;
		while (!stack2.isEmpty()) {
			result.add(stack2.pop().val);
		}

		return result;
	}

	/**
	 * Using single stack
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Stack<TreeNode> stack = new Stack<>();

		//add root to stack
		stack.add(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();

			//add node value to front
			result.add(0, node.val);

			//add left first and then right
			if (node.left != null) stack.add(node.left);
			if (node.right != null) stack.add(node.right);
		}
		return result;
	}
}
