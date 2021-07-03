package com.koko.linkedlist;

public class LinkedList<E> {
	private Node<E> head = null;

	public static void main(String[] arg) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Node<Integer> head = list.getHead();
		System.out.println("List before reverse");
		list.display(head);

		System.out.println("\nList after reverseIteratively");
		head = list.reverseIteratively(head);
		list.display(head);

		System.out.println("\nList after reverseRecursively");
		head = list.reverseRecursively(head);
		list.display(head);
	}

	Node<E> getHead() {
		return head;
	}

	public void add(E e) {
		Node<E> node = new Node<>(e, null);
		if (head == null) {
			head = node;
		} else {
			Node<E> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}

	public void display(Node<E> head) {
		Node<E> current = head;
		while (current != null) {
			System.out.print(current.data + "-> ");
			current = current.next;
		}
		System.out.print("NULL\n");
	}

	/**
	 * Reverse a list iteratively using sliding pointers
	 *
	 * @param head
	 * @return head of reversed list
	 */
	public Node<E> reverseIterativelyUsingSlidingPointers(Node<E> head) {
		Node<E> r = null;
		Node<E> q = null;
		Node<E> p = head;

		while (p != null) {
			//sliding pointers
			r = q;
			q = p;
			p = p.next;

			//reverse the link
			q.next = r;
		}
		return q;
	}

	/**
	 * Reverse a list iteratively
	 *
	 * @param head
	 * @return head of reversed list
	 */
	public Node<E> reverseIteratively(Node<E> head) {
		Node<E> prev = null;
		Node<E> current = head;

		while (current != null) {
			Node<E> next = current.next; // getting the next Node
			current.next = prev; // reverse the list
			prev = current; // prev holds the reversed list
			current = next;
		}
		return prev;
	}

	/**
	 * Reverse a list recursively
	 *
	 * @param head
	 * @return head of reversed list
	 */
	public Node<E> reverseRecursively(Node<E> head) {
		// base case
		if (head == null || head.next == null)
			return head;

		//just holding the last node or tail or head of reverse list
		//       (3)								   2 -> 3
		Node<E> reverseList = reverseRecursively(head.next);
		// reverse the list
		head.next.next = head;
		// remove pointer
		head.next = null;

		return reverseList;
	}

	/**
	 * Detect loop in a list
	 *
	 * @param head
	 * @return true/false
	 */
	public boolean detectLoop(Node<E> head) {
		Node<E> slowPtr = head;
		Node<E> fastPtr = head;

		while (fastPtr != null || fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if (slowPtr == fastPtr) {
				return true;
			}
		}
		return false;
	}

	static class Node<E> {
		E data;
		Node<E> next;

		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}// end of node class
}
