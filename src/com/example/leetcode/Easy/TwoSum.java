package com.example.leetcode.Easy;

import java.util.HashMap;
import java.util.Map.Entry;
/**
 * leetcode 1. Easy
 *1. Two Sum
 *Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> valueDiffMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            valueDiffMap.put(diff, i);
        }
        for(Entry<Integer, Integer> entry : valueDiffMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        int[] indexes = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int diff = target - value;
            //System.out.print("i=" + i + ",value:" + value + ", diff:" + diff);
            if (valueDiffMap.containsKey(value)) {
                int diffIndex = valueDiffMap.get(value);
                if (diffIndex != i) {
                    indexes[0] = i;
                    indexes[1] = diffIndex;
                    return indexes;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, -3, -4, -5};
        int target = -8;
        int[] result = twoSum(nums, target);
        if (result != null) {
            System.out.print("result:" + "index:" + result[0] + "," + result[1]);
        }
    }
}