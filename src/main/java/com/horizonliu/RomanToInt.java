package com.horizonliu;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数转整形
 * https://leetcode.com/problems/roman-to-integer/
 *
 * @author horizonliu
 * @date 2020/1/18 5:47 下午
 */
public class RomanToInt {
    public static void main(String[] args) throws Exception {
        System.out.println("roman to int res : " + romanToInt2("III"));
    }

    /**
     * 这种方法思路很明确
     * 从左到右依次遍历，index = 0
     * 1. 若当前字符比后一个字符大，直接加上当前字符； index + 1
     * 2. 若当前字符比后一个字符小，判断是否是罗马数字中的六种情况，若不是，输入的罗马字符串不合法；否则 减去当前字符+下一个字符； index + 2
     * <p>
     * 缺点：要用一个map存罗马字母和数字的映射关系、且每次都要从map中查找该罗马字符对应的数字是多少。
     *
     * @param roman 输入的罗马数字
     * @return
     * @throws Exception
     */
    private static int romanToInt(String roman) throws Exception {
        if (roman == null || roman.isBlank()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0, index = 0;
        int len = roman.length();
        for (; index < len - 1; ) {
            char currChar = roman.charAt(index);
            char nextChar = roman.charAt(index + 1);
            if (map.get(currChar) >= map.get(nextChar)) {
                res += map.get(currChar);
                ++index;
            } else {
                switch (currChar) {
                    case 'I':
                        if (nextChar != 'V' && nextChar != 'X') {
                            // 不合法输入
                            throw new Exception("invalid input");
                        }
                        break;
                    case 'X':
                        if (nextChar != 'L' && nextChar != 'C') {
                            // 不合法输入
                            throw new Exception("invalid input");
                        }
                        break;
                    case 'C':
                        if (nextChar != 'D' && nextChar != 'M') {
                            // 不合法输入
                            throw new Exception("invalid input");
                        }
                        break;
                    default:
                        // 不合法输入
                        throw new Exception("invalid input");
                }
                res += map.get(nextChar) - map.get(currChar);
                index += 2;
            }
        }

        if (index == len - 1) {
            res += map.get(roman.charAt(index));
        }
        return res;
    }

    /**
     * @param roman 罗马字符串
     * @return
     */
    private static int romanToInt2(String roman) {
        int res = 0;
        if (roman == null || roman.isBlank()) {
            return res;
        }

        int len = roman.length();
        int index = 0;

        for (; index < len; ++index) {
            char currChar = roman.charAt(index);
            // 保证不越界
            char nextChar = 'A';
            if (index < len - 1) {
                nextChar = roman.charAt(index + 1);
            }
            switch (currChar) {
                case 'M':
                    res += 1000;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'I':
                    res += 1;
                    if (nextChar == 'V') {
                        res += 3;
                        ++index;
                    } else if (nextChar == 'X') {
                        res += 8;
                        ++index;
                    }
                    break;
                case 'X':
                    res += 10;
                    if (nextChar == 'L') {
                        res += 30;
                        ++index;
                    } else if (nextChar == 'C') {
                        res += 80;
                        ++index;
                    }
                    break;
                case 'C':
                    res += 100;
                    if (nextChar == 'D') {
                        res += 300; // 500-100-100 多加的100
                        ++index;
                    } else if (nextChar == 'M') {
                        res += 800;
                        ++index;
                    }
                    break;
                default:
                    // 非法输入
                    return 0;
            }

        }
        return res;
    }
}
