package com.koko.binarytree;

/**
 * For every node, data value must be equal to sum of data values in left and right children.
 * Consider data value as 0 for NULL children.
 */
public class ChildrenSumParent {
	public static boolean isSumProperty(TreeNode root) {
		// for leaf node or no node
		if (root == null || (root.left == null && root.right == null))
			return true;

		int lsum = root.left != null ? root.left.val : 0;
		int rsum = root.right != null ? root.right.val : 0;

		//check for current node and then left of node and right of node
		if ((root.val == lsum + rsum) && isSumProperty(root.left) && isSumProperty(root.right)) {
			return true;
		} else {
			return false;
		}
	}
}
