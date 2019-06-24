package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode output = null;
		int carry = 0;

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