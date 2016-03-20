package com.example.leetcode.Medium;
/**
 * leetcode 209.Medium
 * 209. Minimum Size Subarray Sum
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
 *
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        int min = minSubArrayLen(3, nums);
        System.out.println(min);
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;
        while(start < nums.length && end < nums.length) {
            // end往后走直到[start,end]之间的和大于s
            while(sum < s && end < nums.length) {
                sum += nums[end];
                end++;
            }
            while(sum >= s && start <= end) {
                min = Math.min(min, end-start);
                sum -= nums[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
