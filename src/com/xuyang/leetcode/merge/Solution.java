package com.xuyang.leetcode.merge;

/**
 * @author Li Xuyang
 * @date 2020/3/8 13:08
 * 应该想到归并排序
 */
public class Solution {


    /**
     * 非递归
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     *
     * @param nA 第一个有序链表
     * @param nB 第二个有序链表
     * @return 合并后的有序链表头
     */


    public static Node merge(Node nA, Node nB) {
        //如果第一个链表为空，返回第二个链表
        //如果第二个链表为空，返回第一个链表
        if (nA == null) {
            return nB;
        } else if (nB == null) {
            return nA;
        }

        //创建一个临时结点，用于添加元素方便
        Node mergeHead = new Node();
        //用于指向合并后的链表的尾结点
        Node temp = mergeHead;
        //当两个链表都不为空都时候进行合并
        while (nA != null && nB != null) {

            //下面都操作合并较小都元素
            if (nA.value < nB.value) {
                //temp的下个指针指向nA,nA后移
                temp.next = nA;
                nA = nA.next;
            } else {
                //temp的下个指针指向nB,nB后移

                temp.next = nB;
                nB = nB.next;
            }
            //将指针移动到合并后都链表都结尾，这一步很关键，不好想,相当于拼接
            temp = temp.next;

        }

        //比较容易出错
        //下面两个if有且只有一个if的内容会执行
        //如果第一个链表元素未处理完，将其接到合并链表到最后一个结点之后
        if (nA != null) {
            temp.next = nA;
        }

        //如果第二个链表元素未处理完，将其接到合并链表到最后一个结点之后

        if (nB != null) {
            temp.next = nB;
        }

        //返回处理结果
        return mergeHead.next;
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     * 递归解法，不推荐，递归调用到时候会有方法入栈，需要更多到内存
     * @param nA 第一个有序链表
     * @param nB 第二个有序链表
     * @return 合并后到有序链表到表头
     */

    public static Node merge2(Node nA, Node nB) {


        if (nA == null){
            return nB;
        }

        if (nB == null){
            return  nA;
        }


        //记录两个链表中头部比较小到结点
        Node mergeHead = nA;

        if (mergeHead.value< nB.value){
            mergeHead.next = merge2(nA.next,nB);
        }else {
            mergeHead = nB;
            mergeHead.next = merge2(nA,nB.next);
        }

        return mergeHead;


    }

    /**
     * 输出链表到元素值
     *
     * @param head 链表到头结点
     */
    public static void printList(Node head) {

        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {

        Node head = new Node();

        Node nA = new Node();
        nA.value = 1;

        nA.next = new Node();
        nA.next.value = 2;

        nA.next.next = new Node();
        nA.next.next.value = 3;

        nA.next.next.next = new Node();
        nA.next.next.next.value = 4;

        nA.next.next.next.next = new Node();
        nA.next.next.next.next.value = 5;

        Node nB = new Node();
        nB.value = 1;

        nB.next = new Node();
        nB.next.value = 3;

        nB.next.next = new Node();
        nB.next.next.value = 5;

        nB.next.next.next = new Node();
        nB.next.next.next.value = 6;

        nB.next.next.next.next = new Node();
        nB.next.next.next.next.value = 7;


       // head = merge(nA, nB);
        head = merge2(nA, nB);

        printList(head);

    }

}
