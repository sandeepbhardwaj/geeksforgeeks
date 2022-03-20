package com.koko.binarytree;

import com.koko.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderWithOrderByValue {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			result.add(new ArrayList<>());
			return result;
		}

		//adding height and list of Pair as value
		Map<Integer, List<Pair>> map = new TreeMap<>();

		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0, 0));

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();

			List<Pair> list = map.getOrDefault(pair.hd, new ArrayList<>());
			list.add(pair);
			map.put(pair.hd, list);

			if (pair.node.left != null) queue.add(new Pair(pair.node.left, pair.hd - 1, pair.level + 1));
			if (pair.node.right != null) queue.add(new Pair(pair.node.right, pair.hd + 1, pair.level + 1));
		}

		for (int key : map.keySet()) {
			List<Pair> list = map.get(key);

			//comparator to sort values if are on same level
			list.sort((a, b) -> (a.level == b.level) ? Integer.compare(a.node.val, b.node.val) : Integer.compare(a.level, b.level));

			List<Integer> sortedList = list.stream().map(e -> e.node.val).collect(Collectors.toList());

			result.add(sortedList);
		}
		return result;
	}


	class Pair {
		TreeNode node;
		int hd;
		int level;

		Pair(TreeNode node, int hd, int level) {
			this.node = node;
			this.hd = hd;
			this.level = level;
		}
	}
}
