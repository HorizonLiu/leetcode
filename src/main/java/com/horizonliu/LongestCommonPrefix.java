package com.horizonliu;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * @author horizonliu
 * @date 2020/1/18 7:12 下午
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        // 分制方法
        System.out.println("longest common prefix is : " + divideAndConquer(args));
    }

    public static String divideAndConquer(String[] args) {
        if (args == null || args.length <= 0) {
            return "";
        }

        return longestCommonPrefix(args, 0, args.length - 1);
    }

    public static String longestCommonPrefix(String[] args, int left, int right) {
        if (left == right) {
            return args[left];
        } else {
            int mid = (left + right) / 2;
            String leftPrefix = longestCommonPrefix(args, left, mid);
            String rightPrefix = longestCommonPrefix(args, mid + 1, right);
            return longestPrefixOfTwo(leftPrefix, rightPrefix);
        }
    }

    public static String longestPrefixOfTwo(String s1, String s2) {
        if (s1 == null || s2 == null ||
                s1.isBlank() || s2.isBlank()) {
            return "";
        }
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        return s1.substring(0, minLength);
    }
}
