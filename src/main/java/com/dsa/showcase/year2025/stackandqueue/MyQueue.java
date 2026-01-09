package com.dsa.showcase.year2025.stackandqueue;

class MyQueue {

    int front, rear,capacity;
    int arr[] = new int[100005];
  
    MyQueue() {
        front = 0;
        rear = 0;
        capacity=100005;
    }

    // Function to push an element x in a queue.
    void push(int x) {
        // Your code here
        if(this.rear==this.capacity){
            return;
        }
        arr[this.rear++]=x;
    }

    // Function to pop an element from queue and return that element.
    int pop() {
        if(this.front==this.rear)return -1;
        return arr[this.front++];
    }
}