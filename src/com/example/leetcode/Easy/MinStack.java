package com.example.leetcode.Easy;

import java.util.ArrayList;
/**
 * leetcode 155. Easy
 * 155. Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
    private ArrayList<Integer> mDatas = new ArrayList<Integer>();
    private ArrayList<Integer> mMinDatas = new ArrayList<Integer>();

    public int getMin() {
        int topIndex = mMinDatas.size() - 1;
        return mMinDatas.get(topIndex);
    }

    public void push(int data) {
        mDatas.add(data);
        // 计算得到最小值
        int min = getMin();
        if (data < min) {
            mMinDatas.add(data);
        }
    }

    public int pop() {
        int topIndex = mDatas.size() - 1;
        int top = mDatas.get(topIndex);
        int min = getMin();
        if (min == top) {
            mMinDatas.remove(mMinDatas.size() - 1);
        }
        mDatas.remove(topIndex);
        return top;
    }

    public static void main(String[] args) {

    }
}
