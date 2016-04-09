package com.example.leetcode.Medium;

public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int value : nums) {
            if (value <= min) {
                min = value;
            } else if (value <= secondMin) {
                secondMin = value;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        boolean has = increasingTriplet(nums);
        System.out.println(has);
    }
}
