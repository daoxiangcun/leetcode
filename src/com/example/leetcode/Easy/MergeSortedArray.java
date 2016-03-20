package com.example.leetcode.Easy;

/**
 * leetcode 88. Easy
 * 88. Merge Sorted Array
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 将nums2中的数字从头到尾依次插入nums1中
        int nums1Len = m;
        for(int i = 0; i < n; i++) {
            int value = nums2[i];
            // 插入到nums1中
            if (nums1Len == 0 || value >= nums1[nums1Len-1]) {
                nums1[nums1Len] = value;
                nums1Len++;
            } else {
                for (int j = 0; j < nums1Len; j++) {
                    if (value < nums1[j]) {
                        //在第j个位置插入value
                        for(int k = nums1Len - 1; k >= j; k--) {
                            nums1[k+1] = nums1[k];
                        }
                        nums1[j] = value;
                        nums1Len++;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 0, 3, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {-1, 1, 1, 1, 2, 3};
        merge(nums1, 3, nums2, 6);
        for(int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }
}