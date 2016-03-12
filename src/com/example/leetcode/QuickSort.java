package com.example.leetcode;
// ��������
public class QuickSort {
    public static void main(String[] args) {
        ///int[] datas = {34,3,53,2,23,7,14,10};
        int[] datas = {49, 38, 65, 97, 76, 13, 27, 49};
        quickSort(datas, 0, datas.length-1);
        for(int i = 0; i < datas.length; i++) {
            System.out.print(datas[i] + " ");
        }
    }

    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public static void quickSort(int[] nums, int start, int end) {
        if(nums == null || nums.length == 0) {
            return;
        }
        if (nums.length == 1) {
            return;
        }
        if (start >= end) {
            return;
        }
        int first = start;
        int last = end;
        int target = nums[first];
        first = first + 1;
        while(true) {
            // �ҳ���һ�����ڵ���target����
            while(nums[first] < target && first < end) {
                first++;
            }
            // �ҳ���һ��С�ڵ���targetС����
            while(nums[last] > target && last > start) {
                last--;
            }
            // ����start��end��Ӧ��ֵ
            if (first < last) {
                swap(nums, first, last);
            } else {
                break;
            }
        }
        // ������start�����last����λ��
        swap(nums, start, last);

        // ��[start, last-1] ��[last+1, end]���ÿ�������
        quickSort(nums, start, last-1);
        quickSort(nums, last+1, end);
    }
}
