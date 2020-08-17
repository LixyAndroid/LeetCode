package com.xuyang.leetcode.offer3;

/**
 * @author Li Xuyang
 * @date 2020/8/17 10:53
 */
public class MergeTwoLists25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }

        if (l1 == null) {
            return l2;
        }

        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;

        }

        if (l1 != null) {
            tmp.next = l1;
        }

        if (l2 != null) {
            tmp.next = l2;
        }

        return res.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode mergeNode = l1;
        if (l1.val < l2.val) {
            mergeNode.next = mergeTwoLists2(l1.next, l2);
        } else {
            mergeNode = l2;
            mergeNode.next = mergeTwoLists2(l1, l2.next);
        }

        return mergeNode;
    }
}
