package com.horizonliu;

/**
 * @author horizonliu
 * @date 2020/8/9 4:47 下午
 */
public class Util {
    public static void printArray(int[][] intervals) {
        for (int[] interval : intervals) {
            for (int ele : interval) {
                System.out.print(ele + "    ");
            }
            System.out.println();
        }
    }
}
