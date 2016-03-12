package com.example.leetcode;
// 快速排序
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
            // 找出第一个大于等于target的数
            while(nums[first] < target && first < end) {
                first++;
            }
            // 找出第一个小于等于target小的数
            while(nums[last] > target && last > start) {
                last--;
            }
            // 交换start与end对应的值
            if (first < last) {
                swap(nums, first, last);
            } else {
                break;
            }
        }
        // 交换第start个与第last个的位置
        swap(nums, start, last);

        // 对[start, last-1] 和[last+1, end]调用快速排序
        quickSort(nums, start, last-1);
        quickSort(nums, last+1, end);
    }
}
