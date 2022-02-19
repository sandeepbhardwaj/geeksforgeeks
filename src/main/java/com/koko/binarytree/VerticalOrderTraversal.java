package com.koko.binarytree;

import com.koko.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

	/**
	 * Vertical order traversal using Level order + HasTable
	 *
	 * @param root
	 * @return
	 */
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			result.add(new ArrayList<>());
			return result;
		}

		//adding height and list of nodes as value
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();

		Queue<QNode> queue = new LinkedList<>();

		queue.add(new QNode(root, 0));

		while (!queue.isEmpty()) {
			QNode qNode = queue.poll();

			List<Integer> list = map.getOrDefault(qNode.hd, new ArrayList<>());
			list.add(qNode.node.val);
			map.put(qNode.hd, list);

			if (qNode.node.left != null) queue.add(new QNode(qNode.node.left, qNode.hd - 1));
			if (qNode.node.right != null) queue.add(new QNode(qNode.node.right, qNode.hd + 1));
		}

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> val = entry.getValue();
			result.add(val);
		}

		return result;
	}

	/**
	 * Class to store TreeNode and horizontal distance of node form root
	 */
	class QNode {
		TreeNode node;
		int hd;

		QNode(TreeNode node, int hd) {
			this.node = node;
			this.hd = hd;
		}
	}
}