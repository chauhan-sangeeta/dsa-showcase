package com.dsa.showcase.year2025.linkedlist;

import com.dsa.showcase.year2025.util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class DeleteMiddleOfLinkedList {
    public static void main(String[] args) {
        DeleteMiddleOfLinkedList solution = new DeleteMiddleOfLinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = solution.deleteMiddle(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public ListNode deleteMiddle(ListNode head) {
           ListNode fast= head;
           ListNode slow = head;
           ListNode prev=slow;
           if(head.next==null)
              return null;
           while(fast!=null && fast.next!=null)
                {
                    fast=fast.next.next;
                    prev=slow;
                    slow=slow.next;
                }
                prev.next=slow.next;
                return head;
    }
}