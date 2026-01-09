package com.dsa.showcase.year2025.recursion;

import java.util.Stack;

/*Sort a stack
Difficulty: MediumAccuracy: 69.19%Submissions: 150K+Points: 4Average Time: 20m
Given a stack, the task is to sort it such that the top of the stack has the greatest element.

        Example 1:

Input:
Stack: 3 2 1
Output: 3 2 1
Example 2:

Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
Your Task:
You don't have to read input or print anything. Your task is to complete the function sort() which sorts the elements present in the given stack. (The sorted stack is printed by the driver's code by popping the elements of the stack.)

Expected Time Complexity: O(N*N)
Expected Auxilliary Space: O(N) recursive.

Constraints:
        1<=N<=100*/
public class SortStack {
    public static void main(String[] args) {
        SortStack sortStack = new SortStack();
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        Stack<Integer> sortedStack = sortStack.sort(stack);
        System.out.println("Sorted Stack: " + sortedStack);

        // Using iterative method
        Stack<Integer> iterativeSortedStack = sortStack.sortIteration(stack);
        System.out.println("Iteratively Sorted Stack: " + iterativeSortedStack);
    }

    public Stack<Integer> sortIteration(Stack<Integer> s) {
        // add code here.
        Stack<Integer> res = new Stack<>();
        while (!s.isEmpty()) {
            int top = s.pop();
            while (!res.isEmpty() && res.peek() > top) {
                s.push(res.pop());
            }
            res.push(top);
        }
        return res;
    }

    public Stack<Integer> sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sort(s);
            sortedInsert(s, x);
        }
        return s;
    }

    public void sortedInsert(Stack<Integer> s, int x) {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }
        int temp = s.pop();
        sortedInsert(s, x);
        s.push(temp);
    }
}