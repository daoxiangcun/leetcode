package com.example.leetcode;

import java.util.ArrayList;

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
