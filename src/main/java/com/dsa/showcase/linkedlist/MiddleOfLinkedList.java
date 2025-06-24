package com.dsa.showcase.linkedlist;

import com.dsa.showcase.util.ListNode;
/*876. Middle of the Linked List
        Solved
Easy
        Topics
conpanies icon
Companies
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.



Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.


        Constraints:

The number of nodes in the list is in the range [1, 100].
        1 <= Node.val <= 100*/
public class MiddleOfLinkedList {
    public static void main(String[] args) {
        MiddleOfLinkedList solution = new MiddleOfLinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode middle = solution.middleNode(head);
        System.out.println("Middle node value: " + middle.val); // Expected output: 3
    }
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}