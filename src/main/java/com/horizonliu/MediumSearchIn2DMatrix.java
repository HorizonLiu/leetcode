package com.horizonliu;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * @author horizonliu
 * @date 2020/8/9 6:19 下午
 */
public class MediumSearchIn2DMatrix {

    /**
     * 采用两次二分
     * 第一次二分先定位到行，第二次二分再定位到列
     *
     * @param matrix 二维矩阵
     * @param target 要寻找的数字
     * @return 是否找到
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row <= 0 || matrix[0].length <= 0) {
            return false;
        }
        int column = matrix[0].length;
        int begin = 0, end = row - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            // 找到返回
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        // 没找到，此时end<begin，则在end行继续采用二分法寻找
        int queryRow = end;
        begin = 0;
        end = column - 1;
        while (queryRow >= 0 && begin <= end) {
            int mid = (begin + end) / 2;
            // 找到返回
            if (matrix[queryRow][mid] == target) {
                return true;
            } else if (matrix[queryRow][mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return false;
    }

}
