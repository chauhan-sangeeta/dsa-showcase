package com.dsa.showcase.stackandqueue;
/*155. Min Stack
Solved
        Medium
Topics
conpanies icon
Companies
        Hint
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.



Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
        [[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2


Constraints:

        -231 <= val <= 231 - 1
        Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.*/
public class MinStackUsingLinkedList {

    ListNode head;

    public MinStackUsingLinkedList() {

    }

    public static void main(String[] args) {
        MinStackUsingLinkedList minStack = new MinStackUsingLinkedList();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Minimum: " + minStack.getMin()); // Returns -3.
        minStack.pop();
        System.out.println("Top: " + minStack.top()); // Returns 0.
        System.out.println("Minimum: " + minStack.getMin()); // Returns -2.
    }

    public void push(int val) {
        if (head == null) {
            head = new ListNode(val, val, null);
        } else
            head = new ListNode(val, Math.min(val, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

class ListNode {
    int val;
    int min;
    ListNode next;

    ListNode(int val, int min, ListNode next) {
        this.val = val;
        this.min = min;
        this.next = next;

    }
}

