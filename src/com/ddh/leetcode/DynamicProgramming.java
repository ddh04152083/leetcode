package com.ddh.leetcode;

public class DynamicProgramming {


    /**
     * 描述：有N阶楼梯，每次只能爬一阶或者两阶，求有多少种爬楼梯的方式
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }
        int pre1 = 2, pre2 = 1;
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;

    }

    /**
     * 题目描述：抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
     *
     * @param nums
     * @return
     */

    public int rob(int[] nums) {

        int pre1 = 0, pre2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(  + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;

    }
}
