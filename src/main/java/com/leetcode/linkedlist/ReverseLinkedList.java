package com.leetcode.linkedlist;

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

    public ListNode reverseList(ListNode head) {
        //prev will be new head of reversed list
        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;

        while (current != null) {
            // hold the current next
            next = current.next;

            // added the reverse list to current next
            current.next = prev;
            //pointing the prev to new reversed list head
            prev = current;

            // moved the current to next node
            current = next;

        }
        return prev;
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