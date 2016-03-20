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
        Queue<Integer> dataQueue = oneQueue; // ָ�򱣴����� �Ķ���
        Queue<Integer> tmpQueue = twoQueue;  // ָ��������ת�Ķ���

        public MyStack() {

        }

        // Push element x onto stack.
        public void push(int x) {
            dataQueue.offer(x);
        }

        // Removes the element on top of the stack.
        public void pop() {
            // ��dataQueue�н������һ�����������������ת�Ƶ�tmpQueue��
            if(!dataQueue.isEmpty()) {
                int size = dataQueue.size();
                for(int i = 0; i < size-1; i++) {
                    tmpQueue.offer(dataQueue.poll());
                }
                dataQueue.poll();
                // ��ʱtmpQueue�����dataQueue,dataQueue�����tmpQueue
                Queue<Integer> swap = dataQueue;
                dataQueue = tmpQueue;
                tmpQueue = swap;
            }
        }

        // Get the top element.
        public int top() {
            // ��dataQueue�н������һ�����������������ת�Ƶ�tmpQueue��
            if(!dataQueue.isEmpty()) {
                int size = dataQueue.size();
                for(int i = 0; i < size-1; i++) {
                    tmpQueue.offer(dataQueue.poll());
                }
                // �����һ�����ӵ�tmpQueue��
                int topValue = dataQueue.poll();
                tmpQueue.offer(topValue);
                // ��ʱtmpQueue�����dataQueue,dataQueue�����tmpQueue
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
