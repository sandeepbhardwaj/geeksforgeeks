package leetcode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 */
public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode slowPtr = head;
		ListNode fastPtr = head;

		for (int i = 0; i < n; i++) {
			fastPtr = fastPtr.next;
		}

		// for single node
		if (fastPtr == null) {
			head = head.next;
			return head;
		}

		while (fastPtr.next != null) {
			fastPtr = fastPtr.next;
			slowPtr = slowPtr.next;
		}

		slowPtr.next = slowPtr.next.next;

		return head;
	}
}