package com.xuyang.leetcode.deleteDuplication;

/**
 * @author Li Xuyang
 * date  2019/7/27 10:37
 *
 * 删除链表中重复的节点，不保留 若一个点重复，则全部删除 题目要求
 *
 */
public class Solution {


    public static ListNode deleteDuplication(ListNode pHead)
    {

        if (pHead == null){
            return null;}

        //注意备用头结点，头结点可能被删除
        ListNode first = new ListNode(-1);

        first.next = pHead;
        ListNode p = pHead;
        //前节点
        ListNode preNode = first;

        while (p != null && p.next != null){

            if (p.val == p.next.val){ //两节点相等

                int val = p.val; //记录val用于判断后面节点是否重复
                while(p != null && p.val == val){   //这一步用于跳过相等的节点，用于删除
                    p = p.next;
                }
                preNode.next = p; //删除操作，前节点的next直接等于现在的节点，把中间的节点直接跨过
            }else {
                preNode = p;
                p = p.next;
            }
        }
        return first.next;
    }







    public static void main(String[] args) {

        //-构造单链表start----
        int[] num = { 2, 3, 3, 5, 7, 8, 8, 8, 9, 9, 10 };
        ListNode head = new ListNode(num[0]);
        ListNode pre = head;
        for (int i = 1; i < num.length; i++) {
            ListNode node = new ListNode(num[i]);
            pre.next = node;
            pre = node;
        }
        //-构造单链表end-----

        System.out.print("删除前：");
        for (pre = head.next; pre !=null ; pre = pre.next) {

            System.out.print(pre.val + " ");
        }

        deleteDuplication(head);
        System.out.println();
        System.out.print("删除后：");

        for (pre = head.next; pre !=null ; pre = pre.next) {

            System.out.print(pre.val + " ");
        }


    }



}
