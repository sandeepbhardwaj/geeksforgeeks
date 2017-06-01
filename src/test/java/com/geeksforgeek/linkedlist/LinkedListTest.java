package com.geeksforgeek.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.geeksforgeeks.linkedlist.LinkedList;

public class LinkedListTest
{
	LinkedList<Integer> list;

	@Before
	public void setUp() throws Exception
	{
		list = new LinkedList<Integer>();
	}

	@Test
	public void testAdd()
	{
		list.add(2);
		list.add(4);
		list.add(3);
		list.add(7);
	}

	@Test
	public void testDisplay()
	{
		list.display();
	}
	
	@Test
	public void testSize()
	{
		list.add(2);
		list.add(4);
		Assert.assertEquals(2, list.getSize());
	}

	@Test
	public void testReverseIteratively()
	{
		list.add(2);
		list.add(4);
		list.add(3);
		list.add(7);
		list.display();
		System.out.println();
		list.reverseListIteratively();
		list.display();
	}
	
}
