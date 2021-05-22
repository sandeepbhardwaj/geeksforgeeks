package com.leetcode.linkedlist;

import com.leetcode.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * <p>
 * Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * <p>
 * Example 3:
 * Input: head = [1,2,3,4,5], k = 1
 * Output: [1,2,3,4,5]
 * <p>
 * Example 4:
 * Input: head = [1], k = 1
 * Output: [1]
 */
public class ReverseNodesInkGroups {

	public ListNode reverseKGroup(ListNode head, int k) {

		if (head == null)
			return head;

		ListNode r = null;
		ListNode q = null; // holds the reversed linked list
		ListNode p = head; //hold the next node

		int count = 0; //to keep track of sub list
		while (count < k && p != null) {
			r = q;
			q = p;
			p = p.next;

			//reverse the link
			q.next = r;

			//increment count
			count++;
		}

		//m.imp why head , because head becomes tail of sublist
		if (p != null) {
			head.next = reverseKGroup(p, k);
		}

		return q;
	}


	/**
	 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
	 *
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup2(ListNode head, int k) {

		if (head == null)
			return head;

		//code to validate - If the number of nodes is not a multiple of k then left-out nodes, in the end,
		//should remain as it is.
		ListNode temp = head;
		int i = 0;
		while (i < k && temp != null) {
			temp = temp.next;
			i++;
		}
		if (temp == null && i < k)
			return head;

		ListNode r = null;
		ListNode q = null; // holds thre reversed linked list
		ListNode p = head; //hold the next node

		int count = 0; //to keep track of sub list

		while (count < k && p != null) {
			r = q;
			q = p;
			p = p.next;

			//reverse the link
			q.next = r;

			//increment count
			count++;
		}

		//m.imp why head , bcoz head becomes tail of sublist
		if (p != null) {
			head.next = reverseKGroup(p, k);
		}
		return q;
	}
}
