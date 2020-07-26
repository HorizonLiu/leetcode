package com.horizonliu;

/**
 * @author horizonliu
 * @date 2020/4/12 5:21 下午
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println("res=" + removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int len = 1;
        for (int index = 1; index < nums.length; ++index) {
            if (nums[index] != nums[index - 1]) {
                nums[len++] = nums[index];
            }
        }
        return len;
    }
}
