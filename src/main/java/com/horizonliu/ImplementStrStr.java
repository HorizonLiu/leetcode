package com.horizonliu;

/**
 * https://leetcode.com/problems/implement-strstr/
 *
 * @author horizonliu
 * @date 2020/4/12 7:27 下午
 */
public class ImplementStrStr {

    public static void main(String[] args) {


    }

    private static int strStr(String haystack, String needle) {
        if (haystack == null || haystack.isEmpty()
                || needle == null || needle.isEmpty()
                || haystack.length() < needle.length()) {
            return 0;
        }

        // https://www.cnblogs.com/zhangtianq/p/5839909.html -- kmp算法
        return haystack.indexOf(needle);
    }

}
