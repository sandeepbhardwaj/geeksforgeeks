package com.koko.binarytree;

public class ChildrenSumParent {
	public static int isSumProperty(TreeNode root) {
		// for leaf node or no node
		if (root == null || (root.left == null && root.right == null))
			return 1;

		int lsum = root.left != null ? root.left.val : 0;
		int rsum = root.right != null ? root.right.val : 0;

		//check for current node and then left of node and right of node
		if ((root.val == lsum + rsum) && isSumProperty(root.left) == 1 && isSumProperty(root.right) == 1) {
			return 1;
		} else {
			return 0;
		}
	}
}
