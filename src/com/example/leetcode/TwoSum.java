package com.example.leetcode;

import java.util.HashMap;
import java.util.Map.Entry;

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