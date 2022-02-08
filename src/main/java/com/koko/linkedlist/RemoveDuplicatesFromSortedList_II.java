package com.koko.linkedlist;

import com.koko.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers
 * from the original list. Return the linked list sorted as well.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * <p>
 * Example 2:
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 */
public class RemoveDuplicatesFromSortedList_II {
	public ListNode deleteDuplicates(ListNode head) {

		ListNode fakeHead = new ListNode(0, head);

		ListNode prev = fakeHead;
		ListNode current = head;

		while (current != null) {
			// if first node is also duplicate
			if (current.next != null && current.val == current.next.val) {
				// move till the end of duplicates sublist
				while (current.next != null && current.val == current.next.val) {
					current = current.next;
				}

				//prev.next point to unique element
				// prev will not move util its unique
				prev.next = current.next;
			} else {
				//if no duplicate/unique element move previous
				prev = prev.next;
			}

			current = current.next;
		}
		return fakeHead.next;
	}
}

