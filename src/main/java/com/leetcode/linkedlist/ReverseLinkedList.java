package com.leetcode.linkedlist;

import com.geeksforgeeks.linkedlist.LinkedList;
import com.leetcode.ListNode;

/**
 * 206. Reverse Linked List
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

    /**
     * Reverse a list iteratively using sliding pointers
     *
     * @param head
     * @return head of reversed list
     */
    public ListNode reverseIterativelyUsingSlidingPointers(ListNode head) {
        ListNode r = null;
        ListNode q = null;
        ListNode p = head;

        while (p != null) {
            //sliding pointers
            r = q;
            q = p;
            p = p.next;

            //reverse the link
            q.next = r;
        }
        return q;
    }

    // 1->2->3->NULL
    public ListNode reverseListRecursively(ListNode head) {
        // base case
        if (head == null || head.next == null)
            return head;

        //just holding the last node or tail or head of reverse list
        //       (3)								   2 -> 3
        ListNode reverseList = reverseListRecursively(head.next);
        // reverse the list
        head.next.next = head;
        // remove pointer
        head.next = null;

        return reverseList;
    }
}