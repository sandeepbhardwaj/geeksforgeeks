package com.leetcode;

/**
 * 206. Reverse Linked List
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode next = null;
		ListNode current = head;

		while (current != null) {
			//hold the current next
			next = current.next;

			//added the reverse list to current next
			current.next = prev;
			prev = current;

			//moved the current to next node
			current = next;

		}
		return prev;
	}
}