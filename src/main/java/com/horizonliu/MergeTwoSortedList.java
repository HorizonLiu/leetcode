package com.horizonliu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author horizonliu
 * @date 2020/4/12 4:55 下午
 */
public class MergeTwoSortedList {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(5);
//        ListNode l2 = new ListNode(5);
//        ListNode res = addTwoNumbers(l1, l2, 0);
//        while (res != null) {
//            System.out.print(res.val + "->");
//            res = res.next;
//        }

        int[] A = new int[]{2, 1, 5};
        int K = 806;
        List<Integer> resSum = addToArrayForm(A, K);
        for (Integer ele : resSum) {
            System.out.print(ele + " ");
        }
    }

    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/
     *
     * @param l1 链表一
     * @param l2 链表二
     * @return 两链表排序后的结果
     */
    private static ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        // 有其中一个链表为空，直接返回非空链表
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        // 两个链表都不为空 -- 采用递归方法计算
        ListNode resHead;
        if (l1.val <= l2.val) {
            resHead = l1;
            l1 = l1.next;
        } else {
            resHead = l2;
            l2 = l2.next;
        }
        resHead.next = mergeTwoSortedList(l1, l2);
        return resHead;
    }

    /**
     * 两链表求和 https://leetcode.com/problems/add-two-numbers/
     *
     * @param l1  链表一
     * @param l2  链表二
     * @param add 进位
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int add) {

        ListNode resHead = new ListNode(0);
        if (l1 == null && l2 == null) {
            // 进位非0
            if (add != 0) {
                resHead.val = add;
                return resHead;
            } else {
                // 进位为0
                return null;
            }
        }
        // 其中一个链表都不为空
        int sum, mod, div;
        sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
        mod = sum % 10;
        div = sum / 10;
        resHead.val = mod;
        resHead.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, div);
        return resHead;
    }

    /**
     * https://leetcode.com/problems/add-to-array-form-of-integer/
     * 求两个数组的和 -- 方法一
     */
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int len = A.length;
        int add = 0, sum;
        for (int index = len - 1; index >= 0; --index) {
            sum = A[index] + add;
            if (K != 0) {
                sum += K % 10;
                K /= 10;
            }
            // 进位
            add = sum / 10;
            res.add(sum % 10);
        }

        while (K != 0 || add != 0) {
            sum = (K % 10) + add;
            K /= 10;
            add = sum / 10;
            res.add(sum % 10);
        }
        // 反转链表 fixme: 能不能不反转
        len = res.size();
        for (int index = 0; index < len / 2; ++index) {
            int tmp = res.get(index);
            res.set(index, res.get(len - index - 1));
            res.set(len - index - 1, tmp);
        }
        return res;
    }

    /**
     * https://leetcode.com/problems/add-to-array-form-of-integer/
     * 求两个数组的和 -- 方法二
     */
    public static List<Integer> addToArrayForm2(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int sum, add = 0, index = A.length - 1;
        for (; index >= 0 && K != 0; --index) {
            sum = A[index] + (K % 10) + add;
            add = sum / 10;
            // 用A[index]保存计算好的值
            A[index] = sum % 10;
            K /= 10;
        }
        // 若A[]还未结束
        while (index >= 0) {
            sum = A[index] + add;
            add = sum / 10;
            A[index] = sum % 10;
            index--;
        }
        // 若K!=0
        while (K != 0) {
            sum = K % 10 + add;
            add = sum / 10;
            // 从前插数字
            res.add(0, sum % 10);
            K /= 10;
        }
        // 若进位add不为0
        if (add != 0) {
            res.add(0, add);
        }
        for (int ele : A) {
            res.add(ele);
        }
        return res;
    }
}
