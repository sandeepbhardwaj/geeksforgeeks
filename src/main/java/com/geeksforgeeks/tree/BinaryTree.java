package com.geeksforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
	Node<T> root;

	public BinaryTree(Node<T> node) {
		this.root = node;
	}

	public void levelOrderTraversalUsingDelimiter(Node<T> root) {
		if (root == null)
			return;

		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			Node<T> temp = queue.poll();
			if (temp == null) {
				System.out.println();
				if (queue.peek() != null)
					queue.add(null);
			}

			else {
				System.out.print(temp.value + " ");
				queue.add(temp.left);
				queue.add(temp.right);
			}
		}
	}

	public Node<T> getRoot() {
		return root;
	}
}
