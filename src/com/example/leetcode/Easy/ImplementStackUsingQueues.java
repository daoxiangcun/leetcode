package com.example.leetcode.Easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode:225. Easy
 * Implement Stack using Queues
 *Implement the following operations of a stack using queues.

 *push(x) -- Push element x onto stack.
 *pop() -- Removes the element on top of the stack.
 *top() -- Get the top element.
 *empty() -- Return whether the stack is empty.
  Notes:
  You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
  Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
  You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack stack1 = new MyStack();
        stack1.push(1);
        stack1.push(2);
        int top = stack1.top();
        System.out.println(top);
        stack1.pop();
        stack1.pop();
        boolean empty = stack1.empty();
        System.out.println(empty);
    }

    static class MyStack {
        Queue<Integer> oneQueue = new LinkedList<Integer>();
        Queue<Integer> twoQueue = new LinkedList<Integer>();
        Queue<Integer> dataQueue = oneQueue; // 指向保存数据 的队列
        Queue<Integer> tmpQueue = twoQueue;  // 指向用作中转的队列

        public MyStack() {

        }

        // Push element x onto stack.
        public void push(int x) {
            dataQueue.offer(x);
        }

        // Removes the element on top of the stack.
        public void pop() {
            // 从dataQueue中将除最后一个数据外的所有数据转移到tmpQueue中
            if(!dataQueue.isEmpty()) {
                int size = dataQueue.size();
                for(int i = 0; i < size-1; i++) {
                    tmpQueue.offer(dataQueue.poll());
                }
                dataQueue.poll();
                // 此时tmpQueue变成了dataQueue,dataQueue变成了tmpQueue
                Queue<Integer> swap = dataQueue;
                dataQueue = tmpQueue;
                tmpQueue = swap;
            }
        }

        // Get the top element.
        public int top() {
            // 从dataQueue中将除最后一个数据外的所有数据转移到tmpQueue中
            if(!dataQueue.isEmpty()) {
                int size = dataQueue.size();
                for(int i = 0; i < size-1; i++) {
                    tmpQueue.offer(dataQueue.poll());
                }
                // 将最后一个数加到tmpQueue中
                int topValue = dataQueue.poll();
                tmpQueue.offer(topValue);
                // 此时tmpQueue变成了dataQueue,dataQueue变成了tmpQueue
                Queue<Integer> swap = dataQueue;
                dataQueue = tmpQueue;
                tmpQueue = swap;
                return topValue;
            }
            return -1;
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return dataQueue.isEmpty();
        }
    }
}
