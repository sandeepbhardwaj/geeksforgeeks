package com.koko.linkedlist;

import com.koko.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null && headB == null) {
			return null;
		}

		ListNode a = headA;
		ListNode b = headB;

		//if a & b have different len, then we will stop the loop after second iteration
		while (a != b) {
			//for the end of first iteration, we just reset the pointer to the head of another linkedlist
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}
}
