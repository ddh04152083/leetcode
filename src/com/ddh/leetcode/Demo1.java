package com.ddh.leetcode;

public class Demo1 {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s1 == s2);           // false
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());

        System.out.println(s3 == s4);

    }
}
