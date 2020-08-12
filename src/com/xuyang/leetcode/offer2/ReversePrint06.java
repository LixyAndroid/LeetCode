package com.xuyang.leetcode.offer2;


import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Li Xuyang
 * @date 2020/8/8 23:43
 * 剑指 Offer 06. 从尾到头打印链表
 */
public class ReversePrint06 {
    //输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    public int[] reversePrint(ListNode head) {

        //练习反转链表
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = null, pre = head;
        while (pre != null) {
            //存下一位
            ListNode temp = pre.next;
            //反转
            pre.next = cur;
            cur = pre;
            //遍历
            pre = temp;
        }

        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;

    }

    //方法二：栈 ，好方法，先进后出，实现反转打印的效果
    public int[] reversePrint2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }

        return print;

    }


    //又复习了下反转链表

    public ListNode reversePrint3(ListNode head) {

        //练习反转链表
        ListNode cur = null, pre = head;
        while (pre != null) {
            //存下一位
            ListNode temp = pre.next;
            //反转
            pre.next = cur;
            cur = pre;
            //遍历
            pre = temp;
        }
        return cur;

    }

    //递归
    public ListNode reversePrint4(ListNode head) {

        //先想递归条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = reversePrint4(head.next);
        //反转
        head.next.next = head;
        head.next = null;
        return newNode;

    }


}
