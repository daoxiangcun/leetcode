package com.example.leetcode.Medium;
/**
 * leetcode 162 medium
 * 162. Find Peak Element
 *
 * A peak element is an element that is greater than its neighbors.
   Given an input array where num[i] ¡Ù num[i+1], find a peak element and return its index.
   The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
   You may imagine that num[-1] = num[n] = -¡Þ.
   For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
   click to show spoilers.
   Note:
   Your solution should be in logarithmic complexity.

       Ô­Àí²Î¿¼:http://my.oschina.net/Tsybius2014/blog/526016
 */
public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left < right) {
            mid = (left + right)/2;
            if (nums[mid] < nums[mid+1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int peak = findPeakElement(nums);
        System.out.println(peak);
    }
}
