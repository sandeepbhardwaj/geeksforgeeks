package com.koko.linkedlist;

import com.koko.ListNode;

/**
 * 2. Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode output = null;
		int carry = 0;

		// % for reminder, / for carry
		ListNode current = null;
		while (l1 != null && l2 != null) {

			int val = (l1.val + l2.val + carry) % 10;
			carry = (l1.val + l2.val + carry) / 10;

			l1 = l1.next;
			l2 = l2.next;

			if (output == null) {
				output = new ListNode(val);
				current = output;
			} else {
				current.next = new ListNode(val);
				current = current.next;
			}
		}

		while (l1 != null) {
			int val = (l1.val + carry) % 10;
			carry = (l1.val + carry) / 10;

			l1 = l1.next;
			current.next = new ListNode(val);
			current = current.next;
		}

		while (l2 != null) {
			int val = (l2.val + carry) % 10;
			carry = (l2.val + carry) / 10;

			l2 = l2.next;
			current.next = new ListNode(val);
			current = current.next;
		}

		if (carry != 0) {
			current.next = new ListNode(carry);
		}
		return output;
	}
}