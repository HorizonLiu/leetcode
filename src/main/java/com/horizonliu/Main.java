package com.horizonliu;

/**
 * @author horizonliu
 * @date 2020/7/26 6:25 下午
 */
public class Main {

    public static void main(String[] args) {
//        MediumLongestSubStringWithoutRepeatCh ch = new MediumLongestSubStringWithoutRepeatCh();
//        System.out.println(ch.lengthOfLongestSubStringUseSet("abcabcbb"));
//        System.out.println(ch.lengthOfLongestSubStringUseMap("pwwkew"));
//        System.out.println(ch.lengthOfLongestSubstringBruce("abcabcbb"));

//        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        MediumMergeIntervals mergeIntervals = new MediumMergeIntervals();
//        mergeIntervals.merge(intervals);

//        int[][] matrix = new int[][]{
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}};
        int[][] matrix = new int[][]{{1}};
        MediumSearchIn2DMatrix searchIn2DMatrix = new MediumSearchIn2DMatrix();
        System.out.println(searchIn2DMatrix.searchMatrix(matrix, 0));
    }
}
