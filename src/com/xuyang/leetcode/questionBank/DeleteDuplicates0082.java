package com.xuyang.leetcode.questionBank;


/**
 * @author Li Xuyang
 * @date 2020/8/17 00:08
 * 删除排序链表中的重复元素 II
 */
public class DeleteDuplicates0082 {
    //给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        //注意备用头结点，头结点可能被删除
        ListNode first = new ListNode(-1);

        first.next = head;
        ListNode p = head;
        //前节点
        ListNode preNode = first;

        while (p != null && p.next != null) {

            if (p.val == p.next.val) { //两节点相等

                int val = p.val; //记录val用于判断后面节点是否重复
                while (p != null && p.val == val) {   //这一步用于跳过相等的节点，用于删除
                    p = p.next;
                }
                preNode.next = p; //删除操作，前节点的next直接等于现在的节点，把中间的节点直接跨过
            } else {
                preNode = p;
                p = p.next;
            }
        }
        return first.next;
    }

    public static void main(String[] args) {

        //-构造单链表start----
        int[] num = {2, 3, 3, 5, 7, 8, 8, 8, 9, 9, 10};
        ListNode head = new ListNode(num[0]);
        ListNode pre = head;
        for (int i = 1; i < num.length; i++) {
            ListNode node = new ListNode(num[i]);
            pre.next = node;
            pre = node;
        }
        //-构造单链表end-----

        System.out.print("删除前：");
        for (pre = head.next; pre != null; pre = pre.next) {

            System.out.print(pre.val + " ");
        }

        head = deleteDuplicates(head);
        System.out.println();
        System.out.print("删除后：");

        for (pre = head.next; pre != null; pre = pre.next) {

            System.out.print(pre.val + " ");
        }


    }
}
