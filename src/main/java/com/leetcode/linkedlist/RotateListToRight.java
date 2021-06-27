package com.leetcode.linkedlist;

import com.leetcode.ListNode;

/**
 * 61. Rotate List
 * <p>
 * Given the head of a linked list, rotate the list to the right by k places.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * <p>
 * Example 2:
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 */
public class RotateListToRight {
	public ListNode rotateRight(ListNode head, int k) {

		if (head == null || head.next == null) {
			return head;
		}

		//calculate k if list size is 10 and k is 100 then no need to rotate
		k = k % size(head); //is used for reminder

		if (k == 0) return head;

		//Use two pointer approach
		ListNode slowPtr = head;
		ListNode fastPtr = head;

		//move fastPtr to k nodes
		//1->2->3, k=2 :=> fastPtr on 3 after loop completion
		//1->2->3->4->5 :=> fastPtr on 3 after loop completion
		while (fastPtr.next != null && k > 0) {
			fastPtr = fastPtr.next;
			k--;
		}

		//Now move both the pointers
		//1->2->3->4->5 :=> fastPtr on 5 and slowPtr on 3 after loop completion
		while (fastPtr.next != null) {
			fastPtr = fastPtr.next;
			slowPtr = slowPtr.next;
		}

		//Now rotate
		//1->2->3->4->5 :=> fastPtr on 5 and slowPtr on 3 after loop completion
		ListNode newHead = slowPtr.next; // 3->4 : 4 becomes new head
		slowPtr.next = null; //break the link 1->2->3  4->5
		fastPtr.next = head; // 4->5->1->2->3
		return newHead;
	}

	private int size(ListNode head) {
		int count = 0;
		ListNode current = head;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}
}
