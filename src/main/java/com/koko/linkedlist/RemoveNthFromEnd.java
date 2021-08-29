package com.koko.linkedlist;

import com.koko.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note:
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

        while (n > 0) {
            fastPtr = fastPtr.next;
            n--;
        }

        // The head need to be removed, do it.
        if (fastPtr == null) {
            head = head.next;
            return head;
        }

        while (fastPtr.next != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }

        slowPtr.next = slowPtr.next.next; // the one after the h1 need to be removed

        return head;
    }

    public ListNode removeNthFromEndUsingFakeHead(ListNode head, int n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode slowPtr = fakeHead;
        ListNode fastPtr = fakeHead;

        while (n > 0) {
            fastPtr = fastPtr.next;
            n--;
        }
        while (fastPtr.next != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = slowPtr.next.next;
        return fakeHead.next;
    }
}