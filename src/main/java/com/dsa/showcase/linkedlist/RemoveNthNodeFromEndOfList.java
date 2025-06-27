package com.dsa.showcase.linkedlist;

import com.dsa.showcase.util.ListNode;

/*19. Remove Nth Node From End of List
        Solved
Medium
        Topics
conpanies icon
Companies
        Hint
Given the head of a linked list, remove the nth node from the end of the list and return its head.



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
        0 <= Node.val <= 100
        1 <= n <= sz


Follow up: Could you do this in one pass?*/
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2; // Remove the 2nd node from the end
        ListNode result = solution.removeNthFromEnd(head, n);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && n-- > 0) {// move fast pointer n steps ahead
            fast = fast.next;
        }
        while (fast != null) {// move both pointers until fast reaches the end
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (slow == head)
            return slow.next;
        prev.next = slow.next;
        return head;

    }
}