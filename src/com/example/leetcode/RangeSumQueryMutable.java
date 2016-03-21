package com.example.leetcode;
/**
 * leetcode 307. Medium
 * Range Sum Query - Mutable
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

   The update(i, val) function modifies nums by updating the element at index i to val.
   Example:
   Given nums = [1, 3, 5]

   sumRange(0, 2) -> 9
   update(1, 2)
   sumRange(0, 2) -> 8
   Note:
   The array is only modifiable by the update function.
   You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 */
public class RangeSumQueryMutable {
    public static class NumArray {
        private int[] datas;
        public NumArray(int[] nums) {
           datas = nums;
        }

        private boolean ensureIndexValid(int index) {
            return index >= 0 && index < datas.length;
        }

        void update(int i, int val) {
            if (datas != null && i < datas.length) {
                datas[i] = val;
            }
        }

        public int sumRange(int i, int j) {
            int result = 0;
            if (ensureIndexValid(i) && ensureIndexValid(j)) {
                for(int index = i; index <= j; index++) {
                    result += datas[index];
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
         NumArray numArray = new NumArray(nums);
         int value = numArray.sumRange(0, 1);
         System.out.println(value);
         numArray.update(1, 10);
         value = numArray.sumRange(1, 2);
         System.out.println(value);
    }

}
