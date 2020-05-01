package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/5/1 17:19
 * 反转链表
 */

public class MergeTwoLists0021 {

    //
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        //创建一个结点
        ListNode mergeNode = new ListNode(0);

        ListNode temp = mergeNode;

        while (l1 != null && l2 != null) {
            //这里是个if else 的关系
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;

        }

        if (l1 != null) {
            temp.next = l1;
        }


        if (l2 != null) {
            temp.next = l2;
        }


        return mergeNode.next;

    }

    //递归
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode listNode = l1;

        //都递归了还循环什么
        if (l1.val < l2.val) {
            mergeTwoLists2(l1.next, l2);
        } else {
            listNode = l2;
            mergeTwoLists2(l1, l2.next);
        }


        return listNode;

    }

}
