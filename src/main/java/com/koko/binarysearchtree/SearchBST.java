package com.koko.binarysearchtree;

import com.koko.TreeNode;

public class SearchBST {
	public TreeNode searchBST(TreeNode root, int val) {

		while (root != null && root.val != val) {
			root = val < root.val ? root.left : root.right;
		}

		return root;
	}
}
