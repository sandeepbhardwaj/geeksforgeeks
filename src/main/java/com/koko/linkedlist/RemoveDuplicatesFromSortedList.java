package com.koko.linkedlist;

import com.koko.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2 Output: 1->2 Example 2:
 * <p>
 * Input: 1->1->2->3->3 Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.val == current.next.val) {
				//removing duplicate breaking the link
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}
}