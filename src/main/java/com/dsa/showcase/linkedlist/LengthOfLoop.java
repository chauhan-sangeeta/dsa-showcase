package com.dsa.showcase.linkedlist;

import com.dsa.showcase.util.ListNode;

public class LengthOfLoop {
    public static void main(String[] args) {
        LengthOfLoop solution = new LengthOfLoop();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        // Creating a loop for testing
        head.next.next.next.next = head.next; // 4 -> 2 creates a loop
        int loopLength = solution.countListNodesinLoop(head);
        System.out.println("Length of the loop: " + loopLength); // Expected output: 3 (2 -> 3 -> 4)
    }
    // Function to find the length of a loop in the linked list.
    public int countListNodesinLoop(ListNode head) {
        ListNode slow = hasCycle(head);
        ListNode start=slow;// Store the starting point of the loop
        int count=0;// Initialize count to 0
        while(start!=null){
            count++;
            start=start.next;// Move to the next node
            if(start==slow){// If we reach the starting point again, we have counted the loop length
                return count;
            }
        }
        return 0;
    }
    public ListNode hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast!=null && fast==slow)
                return fast;
        }
        return null;
    }
}