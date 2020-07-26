package com.horizonliu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @author horizonliu
 * @date 2020/7/26 5:44 下午
 */
public class MediumLongestSubStringWithoutRepeatCh {

    /**
     * 解法一：暴力解法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringBruce(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        int maxLen = 0;
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j <= len; ++j) {
                if (allUnique(s, i, j)) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }

        return maxLen;
    }

    public boolean allUnique(String s, int begin, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = begin; i < end; ++i) {
            if (set.contains(s.charAt(i))) {
                return false;
            } else {
                set.add(s.charAt(i));
            }
        }
        return true;
    }

    /**
     * 解法二： 使用set+滑动窗口概念
     * 假设[i,j)内的字符串为无重复字符子串，其中的字符为set<char>存储，开始时i=j=0
     * 若!set.contains(s[j])， 则说明将s[j]放入set中也不重复，故不重复子串扩张为[i,j+1)
     * 若set.contains(s[j])， 则说明将s[j]放入set中重复，此时需要压缩子串长度，需移除掉set中s[i]元素，并执行i=i+1操作
     *
     * @param s 原始字符串
     * @return
     */
    public int lengthOfLongestSubStringUseSet(String s) {
        if (s == null) {
            return 0;
        }

        int maxLen = 0, strLen = s.length(), i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < strLen && j < strLen) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLen = Math.max(maxLen, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return maxLen;
    }

    /**
     * 还是使用滑动窗口的概念，但不用set存储，而使用Map<char,int>存储。其中key为字符，value为该字符在字符串中的索引
     *
     * @param s 原始字符串
     * @return
     */
    public int lengthOfLongestSubStringUseMap(String s) {

        if (s == null) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, strLen = s.length();

        for (int i = 0, j = 0 ; j < strLen; ++j) {
            if (map.containsKey(s.charAt(j))) {
                i =  Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j + 1);
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }

}
