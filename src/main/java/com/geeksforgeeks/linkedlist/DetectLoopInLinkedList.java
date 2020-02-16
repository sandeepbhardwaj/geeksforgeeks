package com.geeksforgeeks.linkedlist;

import com.geeksforgeeks.linkedlist.LinkedList.Node;

/**
 * <pre>
 * 1 > 2 > 3 > 4
 *     ^       ^
 *     |_______|
 *
 * </pre>
 *
 * @author sandeep
 */
public class DetectLoopInLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		Node<Integer> head = list.getHead();
		// create loop
		head.next.next.next = head.next;

		boolean loopFound = list.detectLoop(head);
		if (loopFound) {
			System.out.println("Loop found ...");
		} else {
			System.out.println("No loop found ...");
		}
	}
}
