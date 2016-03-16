package com.example.leetcode;

import java.util.HashMap;

/**
 * leetcode 219, Easy
 * 219. Contains Duplicate II
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 *
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 1};
        int k = 1;
        boolean contain = containsNearbyDuplicate(nums, k);
        System.out.println(contain);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int data = nums[i];
            if (map.containsKey(data)) {
                if (Math.abs(i - map.get(data)) <= k) {
                    return true;
                } else {
                    map.put(data, i);
                }
            } else {
                map.put(data, i);
            }
        }
        return false;
    }
}
