package com.koko.binarytree;

public class HasPathSum {

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;

		//if on leaf node and remaining sum is zero
		if (root.left == null && root.right == null && targetSum - root.val == 0)
			return true;
		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
	}

}
