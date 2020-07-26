package com.horizonliu;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * @author horizonliu
 * @date 2020/3/20 7:27 下午
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] array = new int[]{-2,-1};
        System.out.println("result=" + maximumSum(array));
    }

    public static int maximumSum(int[] array) {
        int currSum = array[0], maxSum = array[0];

        for (int i = 1; i < array.length; ++i) {

            if (currSum < 0) {
                currSum = array[i];
            } else {
                currSum += array[i];
            }
            if (maxSum < currSum) {
                maxSum = currSum;
            }
        }

        return maxSum;
    }

}
