package com.koko.binarytree;

import com.koko.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 */
public class BinaryTreeView {

	public List<Integer> leftSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();

		if (root == null)
			return result;

		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();

				//print first element from queue
				if (i == 0) result.add(node.val);

				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
			}
		}
		return result;
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();

		if (root == null)
			return result;

		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();

				//print last element from queue
				if (i == size - 1) result.add(node.val);

				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
			}
		}
		return result;
	}

}
