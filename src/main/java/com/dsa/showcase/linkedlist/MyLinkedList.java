package com.dsa.showcase.linkedlist;
/*707. Design Linked List
        Solved
Medium
        Topics
conpanies icon
Companies
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.


Example 1:

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
        [[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3


Constraints:

        0 <= index, val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.*/
public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(2);
        linkedList.addAtIndex(1, 3); // List becomes 1->3->2
        System.out.println(linkedList.get(1)); // Returns 3
        linkedList.deleteAtIndex(1); // List becomes 1->2
        System.out.println(linkedList.get(1)); // Returns 2
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private ListNode tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Get the value at the given index.
     */
    public int get(int index) {
        ListNode node = getNodeAt(index);
        return node != null ? node.val : -1;
    }

    /**
     * Add a node at the head.
     */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    /**
     * Add a node at the tail.
     */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    /**
     * Add a node at the given index.
     * If index == current length, insert at tail.
     * If index > current length, do nothing.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        ListNode nextNode = getNodeAt(index);
        if (nextNode == null) {
            // Possibly add at tail only if index == current length
            ListNode prevNode = getNodeAt(index - 1);
            if (prevNode != null && prevNode.next == null) {
                addAtTail(val);
            }
            return;
        }

        ListNode newNode = new ListNode(val);
        ListNode prevNode = nextNode.prev;

        // Link new node between prevNode and nextNode
        if (prevNode != null) {
            prevNode.next = newNode;
            newNode.prev = prevNode;
        }

        newNode.next = nextNode;
        nextNode.prev = newNode;
    }

    /**
     * Delete node at given index.
     */
    public void deleteAtIndex(int index) {
        ListNode node = getNodeAt(index);
        if (node == null) return;

        if (node == head) head = node.next;
        if (node == tail) tail = node.prev;

        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
    }

    /**
     * Helper method to get node at index.
     * Optimized to traverse from head or tail based on index.
     */
    private ListNode getNodeAt(int index) {
        if (index < 0) return null;

        ListNode curr;
        int i;

        // Try forward traversal
        curr = head;
        i = 0;
        while (curr != null && i < index) {
            curr = curr.next;
            i++;
        }

        return curr;
    }
}
