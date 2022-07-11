package com.koko.linkedlist;

import com.koko.ListNode;

public class ReverseLinkedList_II {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode r = null;
		ListNode q = null;
		ListNode p = head;

		while (left > 1) {
			q = p;
			p = p.next;
			left--;
			right--;
		}

		// The two pointers that will fix the final connections.
		ListNode con = q, tail = p;

		while (right > 0) {
			r = q;
			q = p;
			p = p.next;

			//reverse the link
			q.next = r;

			//increment count
			right--;
		}

		if (con != null) {
			con.next = q;
		} else {
			head = q;
		}

		tail.next = p;
		return head;
	}
}
