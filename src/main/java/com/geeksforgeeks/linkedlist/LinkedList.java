package com.geeksforgeeks.linkedlist;

public class LinkedList<T>
{
	private Node head;
	private int size;

	public void add(T value)
	{
		Node node=new Node(value);
		if (head == null)
		{
			head = node;
			size++;
			return;
		}

		Node current = head;
		while (current.next != null)
		{
			current = current.next;
		}
		current.next = node;
		size++;
	}

	public void display()
	{
		Node current = head;
		while (current != null)
		{
			System.out.print(current.value);
			current = current.next;
		}
	}

	public void reverseListIteratively()
	{
		Node tempHead=null;
		while(head!=null)
		{
			Node current=head;
			head=head.next;
			current.next=tempHead;
			tempHead=current;
		}
		head=tempHead;
	}
	
	class Node
	{
		Node next;
		T value;

		public Node(T value)
		{
			this.value = value;
		}
	}

	public int getSize()
	{
		return size;
	}

	public Node getHead()
	{
		return head;
	}

}
