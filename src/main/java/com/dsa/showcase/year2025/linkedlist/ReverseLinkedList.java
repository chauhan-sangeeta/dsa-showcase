package com.dsa.showcase.year2025.linkedlist;

import com.dsa.showcase.year2025.util.ListNode;
/*
206. Reverse Linked List
        Solved
Easy
        Topics
conpanies icon
Companies
Given the head of a singly linked list, reverse the list, and return the reversed list.



        Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is the range [0, 5000].
        -5000 <= Node.val <= 5000


Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?*/
public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversedHead = solution.reverseList(head);
        head=reversedHead; // Reset head to the reversed list for demonstration
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }

        // Tail Recursive Example
        ListNode tailReversedHead = solution.tailRecursiveReverseList(head);
        head=tailReversedHead; // Reset head to the tail reversed list for demonstration
        System.out.println("\nTail Recursive Reversed List:");
        while (tailReversedHead != null) {
            System.out.print(tailReversedHead.val + " ");
            tailReversedHead = tailReversedHead.next;
        }

        // Head Recursive Example
        ListNode headReversedHead = solution.headRecursiveReverseList(head);
        System.out.println("\nHead Recursive Reversed List:");
        while (headReversedHead != null) {
            System.out.print(headReversedHead.val + " ");
            headReversedHead = headReversedHead.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode next=null;
        ListNode prev=null;
        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode tailRecursiveReverseList(ListNode head) {
        return tailRecursiveReverseList(null,head);
    }
    public ListNode tailRecursiveReverseList(ListNode prev, ListNode curr) {
        if(curr==null){
            return prev;
        }
        ListNode next = curr.next;// save next node
        curr.next=prev;// reverse the link
        return tailRecursiveReverseList(curr,next);// recursive call with new prev and next
    }

    public ListNode headRecursiveReverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;// base case: if head is null or only one node, return head
        }
        ListNode newHead = headRecursiveReverseList(head.next);// recursive call to reverse the rest of the list
        head.next.next=head;// set the next node's next to current head
        head.next=null;// to avoid cycle in first node
        return newHead;
    }
}