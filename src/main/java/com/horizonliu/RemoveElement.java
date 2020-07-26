package com.horizonliu;

/**
 * @author horizonliu
 * @date 2020/4/12 6:04 下午
 */
public class RemoveElement {

    public static void main(String[] args) {

        int[]  nums = new int[]{3,2,2,3};
        System.out.println("res=" + removeElement(nums, 2));
    }

    public static int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] == val) {
            return 0;
        }

        int len = 0;
        for (int index = 0; index < nums.length; ++index) {
            if (nums[index] != val) {
                nums[len++] = nums[index];
            }
        }

        return len;
    }
}
