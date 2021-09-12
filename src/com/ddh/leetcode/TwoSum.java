package com.ddh.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
        //Arrays.stream(twoSum(numbers, 50)).forEach(System.out::println);
        findLHS(numbers);
    }

    /**
     * 求最长和谐子串
     *Input: [1,3,2,2,5,2,3,7]
     * Output: 5
     * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
     * @param nums
     * @return
     */

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        countForNum.forEach((key, value) -> System.out.println(key + " : " + value));

        int longest = 0;

        for (int key : countForNum.keySet()) {
            if (countForNum.containsKey(key + 1)) {
                longest = Math.max(longest, countForNum.get(key + 1) + countForNum.get(key));
            }
        }

        return 0;
    }

    /**
     * 在有序数据中找出两数，使得两数之和等于target
     *
     * @param numbers 有序数组
     * @param target  目标值
     * @return 结果
     */
    private static int[] twoSum(int[] numbers, int target) {

        if (numbers == null) return null;
        int first = 0;
        int last = numbers.length - 1;
        while (first < last) {
            int sum = numbers[first] + numbers[last];
            if (sum == target) {
                System.out.println(first + "     " + last);
                return new int[]{first + 1, last + 1};
            } else if (sum > target) {
                last--;
            } else {
                first++;
            }
        }
        return null;

    }

    /**
     * 判断一个非负整数是否为两个整数的平方和。
     *
     * @param target 目标数据
     * @return 是否存在这样一个数
     */
    private static boolean judgeSquareSum(int target) {
        if (target < 0) return false;
        int i = 0, j = (int) Math.sqrt(target);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == target) {
                return true;
            } else if (powSum > target) {
                j--;
            } else {
                i++;
            }

        }
        return false;

    }


    /**
     * 判断数组中是否包含重复元素
     *
     * @param nums
     * @return
     */
    public boolean containDuplicate(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }
        return sets.size() < nums.length;

    }

}
