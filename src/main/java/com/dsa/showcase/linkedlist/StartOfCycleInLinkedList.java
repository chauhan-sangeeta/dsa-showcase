package com.dsa.showcase.linkedlist;

import com.dsa.showcase.util.ListNode;
/*142. Linked List Cycle II
Solved
        Medium
Topics
conpanies icon
Companies
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.



Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.


Constraints:

The number of the nodes in the list is in the range [0, 104].
        -105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.


Follow up: Can you solve it using O(1) (i.e. constant) memory?*/
public class StartOfCycleInLinkedList {
    public static void main(String[] args) {
        StartOfCycleInLinkedList solution = new StartOfCycleInLinkedList();
        ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        head.next.next.next.next = head.next; // Creating a cycle for testing
        ListNode startOfCycle = solution.detectCycle(head);
        if (startOfCycle != null) {
            System.out.println("Start of cycle at node with value: " + startOfCycle.val); // Expected output: 2
        } else {
            System.out.println("No cycle detected.");
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = hasCycle(head);
        ListNode start=head;
        while(slow!=null && slow!=start){
            slow=slow.next;
            start=start.next;
        }
        return slow;
    }
    private ListNode hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast != null && fast == slow) {
                return slow; // Cycle detected
            }
        }
        return null; // No cycle
    }
}