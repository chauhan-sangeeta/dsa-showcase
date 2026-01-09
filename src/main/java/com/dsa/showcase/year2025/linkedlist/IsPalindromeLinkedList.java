package com.dsa.showcase.year2025.linkedlist;

import com.dsa.showcase.year2025.util.ListNode;

public class IsPalindromeLinkedList {
    public static void main(String[] args) {
        IsPalindromeLinkedList solution = new IsPalindromeLinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        boolean result = solution.isPalindrome(head);
        System.out.println("Is the linked list a palindrome? " + result); // Expected output: true
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode mid = middleNode(head);
        ListNode secondHalfStart = reverseList(mid);

        // Check palindrome
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean isPalindrome = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore original list
        reverseList(secondHalfStart);

        return isPalindrome;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}
