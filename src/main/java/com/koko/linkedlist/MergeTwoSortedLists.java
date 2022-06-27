package com.koko.linkedlist;

import com.koko.ListNode;

/**
 * 21. Merge Two Sorted Lists
 * <p>
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes
 * of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//fakeHead is helpful to avoid so many initial condition for first node.
		ListNode fakeHead = new ListNode(0);
		ListNode current = fakeHead;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			//current always points to tail of merged list
			current = current.next;
		}

		if (l1 != null) {
			current.next = l1;
		}
		if (l2 != null) {
			current.next = l2;
		}
		return fakeHead.next;
	}

	public ListNode mergeTwoListsRecursively(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		ListNode handler;
		if (l1.val < l2.val) {
			handler = l1;
			handler.next = mergeTwoLists(l1.next, l2);
		} else {
			handler = l2;
			handler.next = mergeTwoLists(l1, l2.next);
		}

		return handler;
	}
}
