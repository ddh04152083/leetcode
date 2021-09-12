package com.ddh.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 双指针类算法
 */
public class DoubblePointer {

    public static void main(String[] args) {
        Map<String ,Object> maps = new HashMap<>();

    }
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    /**
     * 反转字符串中的元音字符
     */
    private static String reverseVowels(String s) {

        if (s == null) return null;
        char[] result = new char[s.length()];
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }

        }
        return new String(result);


    }
}
