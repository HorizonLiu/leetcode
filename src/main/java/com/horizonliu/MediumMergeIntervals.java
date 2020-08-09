package com.horizonliu;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/merge-intervals/
 * 给定一组区间，合并
 *
 * @author horizonliu
 * @date 2020/8/9 4:09 下午
 */
public class MediumMergeIntervals {

    /**
     * 方法一：对数组中的第一个元素进行升序排序
     *
     * @param intervals 要进行合并的数组
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 按interval的第一个元素进行升序排序
        Arrays.sort(intervals, Comparator.comparingInt(ele -> ele[0]));
        // resLen 结果数组的长度
        int len = intervals.length, resLen = len;
        for (int i = 0; i < len - 1; ++i) {
            // 合并
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = Math.min(intervals[i][0], intervals[i + 1][0]);
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
                resLen--;
                intervals[i][0] = 0;
                intervals[i][1] = -1;
            }
        }
        // 输出结果
        int[][] ans = new int[resLen][];
        for (int i = len - 1; i >= 0; --i) {
            if (intervals[i][0] <= intervals[i][1]) {
                ans[--resLen] = intervals[i];
            }
        }
        Util.printArray(ans);
        return ans;
    }
}
