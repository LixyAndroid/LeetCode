package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/2 23:03
 * 剑指 Offer 25. 合并两个排序的链表
 */
public class MergeTwoLists25 {
    //输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
    //伪头节点
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        /* 可以去掉，当然面试的时候可以写，然后在优化去掉
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
         */

        //伪头结点，temp 去遍历
        ListNode res = new ListNode(0);
        ListNode temp = res;


        while (l1 != null && l2 != null) {

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

        return res.next;
    }

    //递归
    public static ListNode merge2(ListNode list1, ListNode list2) {

        //递归结束条件，递归的使用一定先想递归结束条件
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode mergeNode = list1;
        if (list1.val < list2.val) {
            mergeNode.next = merge2(list1.next, list2);
        } else {
            //不能少了这句
            mergeNode = list2;
            mergeNode.next = merge2(list1, list2.next);
        }

        return mergeNode;


    }
}
