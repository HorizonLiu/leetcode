package com.horizonliu;

/**
 * 链表节点定义
 *
 * @author horizonliu
 * @date 2020/7/26 5:32 下午
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
