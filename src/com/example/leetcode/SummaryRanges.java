package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 228. Easy
 * 228. Summary Ranges
 * Given a sorted integer array without duplicates, return the summary of its ranges.
   For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 */
public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,4,5,7};
        List<String> ranges = summaryRanges(nums);
        if (ranges != null) {
            for(String range : ranges) {
                System.out.println(range);
            }
        }
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return ranges;
        }
        if (nums.length == 1) {
            String range = String.format("%d", nums[0]);
            ranges.add(range);
            return ranges;
        }
        int p = 0, q = 1;
        while(q < nums.length) {
            if (nums[q] == nums[q-1] + 1) {
                q++;
            } else {
                if (q - p == 1) {
                    String range = String.format("%d", nums[p]);
                    ranges.add(range);
                } else {
                    String range = String.format("%d->%d", nums[p], nums[q-1]);
                    ranges.add(range);
                }
                p = q;
                q++;
            }
        }
        if (q - p == 1) {
            String range = String.format("%d", nums[p]);
            ranges.add(range);
        } else {
            String range = String.format("%d->%d", nums[p], nums[q-1]);
            ranges.add(range);
        }
        return ranges;
    }
}
