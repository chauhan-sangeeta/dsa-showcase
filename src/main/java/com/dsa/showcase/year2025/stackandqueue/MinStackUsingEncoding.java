package com.dsa.showcase.year2025.stackandqueue;

import java.util.Stack;
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
public class MinStackUsingEncoding {

    Stack<Long> st;
    long min;

    public MinStackUsingEncoding() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push((long) val);
            min = val;
        } else if (val <= min) {
            st.push(2L * val - min);  // safe long arithmetic
            min = val;
        } else {
            st.push((long) val);
        }
    }

    public void pop() {
        long val = st.pop();
        if (val <= min) {
            min = 2 * min - val;
        }
    }

    public int top() {
        long val = st.peek();
        return (val <= min) ? (int) min : (int) val;
    }

    public int getMin() {
        return (int) min;
    }
}
