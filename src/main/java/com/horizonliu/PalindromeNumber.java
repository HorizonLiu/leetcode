package com.horizonliu;


/**
 * https://leetcode.com/problems/palindrome-number/
 * <p>
 * 回文数
 *
 * @author horizonliu
 * @date 2020/1/18 5:16 下午
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println("is Palindrome Number: " + isPalindrome(-121));
    }

    private static boolean isPalindrome(int x) {
        // 负数一定不是回文串
        // 1. 最简单的方法当然是将数字转化成字符串再进行
        // 2. 计算得到每一位的数组再进行比较
        // 3. 采用Reverse Integer 进行反转，看反转前后的数是否相等
        return useReverseInt(x);
    }

    // 判断反转前后两数是否相等
    private static boolean useReverseInt(int num) {
        if (num < 0) {
            return false;
        } else if (num == 0) {
            return true;
        } else {
            return num == reverseInt(num);
        }

    }

    // num一定为正数
    private static int reverseInt(int num) {
        int res = 0;
        while (num != 0) {

            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            }

            int mod = num % 10;
            num /= 10;
            res = res * 10 + mod;
        }
        return res;
    }

}

