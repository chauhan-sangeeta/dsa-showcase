package com.dsa.showcase.year2025.stackandqueue;

class MyCircularQueue {

    int front, rear,capacity,size;
    int arr[] = new int[100005];
  
    MyCircularQueue() {
        front = 0;
        rear = 0;
        size=0;
        capacity=100005;
    }

    // Function to push an element x in a queue.
    void push(int x) {
        // Your code here
        if(this.size==this.capacity){
            return;
        }
        arr[rear]=x;
        rear = (rear + 1) % capacity;
        size++;
    }

    // Function to pop an element from queue and return that element.
    int pop() {
        if(this.size==0)return -1;
        int temp = arr[front];
        front = (front + 1) % capacity;
        size--;
        return temp;
    }
}