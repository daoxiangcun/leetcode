package com.example.leetcode;

public class ReverseInteger {
    public static int reverse(int x) {
        boolean negative = x < 0 ? true : false;
        int absX = Math.abs(x);
        int newResult = 0;
        while(absX > 0) {
            int value = absX%10;
            absX /= 10;
            long temp = (long)newResult*10 + value;
            if (temp > Integer.MAX_VALUE) {
                return 0;
            } else {
                newResult = (int)temp;
            }
        }
        return negative ? -newResult : newResult;
    }

    public static void main(String[] args) {
        int value = 1534236469;
        int reversedValue = reverse(value);
        System.out.println(reversedValue);
    }
}
