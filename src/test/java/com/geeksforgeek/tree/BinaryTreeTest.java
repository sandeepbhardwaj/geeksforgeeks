package com.geeksforgeek.tree;

import org.junit.Before;
import org.junit.Test;

import com.geeksforgeeks.tree.BinaryTree;
import com.geeksforgeeks.tree.Node;

public class BinaryTreeTest
{
	BinaryTree<Integer> binaryTree;
	
	@Before
	public void setUp() throws Exception
	{
		Node<Integer> root =new Node<>(1);
		binaryTree = new BinaryTree<Integer>(root);
	}

	@Test
	public void testlevelOrderTraversalUsingDelimiter()
	{
		Node<Integer> root=binaryTree.getRoot();
		root.left=new Node<Integer>(2);
		root.right=new Node<Integer>(3);
		
		root.left.left=new Node<Integer>(4);
		root.left.right=new Node<Integer>(5);
		
		root.right.left=new Node<Integer>(6);
		root.right.right=new Node<Integer>(7);
		
		binaryTree.levelOrderTraversalUsingDelimiter(root);
	}
}
