package com.xuyang.leetcode.offer;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/3/10 15:24
 * 反转链表，重点！！！！
 */
public class ReverseList15 {

    /*
        以3个节点为例：

        用pre记录当前节点的前一个节点

        用next记录当前节点的后一个节点

        1,当前节点a不为空，进入循环，先记录a的下一个节点位置next = b;再让a的指针指向pre

        2,移动pre和head的位置，正因为刚才记录了下一个节点的位置，所以该链表没有断，我们让head走向b的位置。

        3,当前节点为b不为空，先记录下一个节点的位置，让b指向pre的位置即a的位置，同时移动pre和head

        4,当前节点c不为空，记录下一个节点的位置，让c指向b，同时移动pre和head，此时head为空，跳出，返回pre。
     */

    /**
     * 迭代
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode per = null;
        ListNode next = null;

        while (head != null) {

            // 暂存后面一个节点
            next = head.next;
            //反转
            head.next = per;
            per = head;
            //向后移动一位
            head = next;

        }

        return per;
    }

    public static ListNode reverseList2(ListNode head) {

        if (head==null || head.next ==null){
            return head;
        }
        ListNode newNode = reverseList2(head.next);
        //反转
        head.next.next = head;
        head.next = null;
        return  newNode;

    }




    // 测试
    public static void main(String[] args) {
        ListNode[] ln = new ListNode[2]; // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        for (int i = 0; i < ln.length; i++) {
            ln[i] = new ListNode(0);
            ln[i].val = i + 1;
            if (i > 0)
                ln[i - 1].next = ln[i];
        }



        ListNode testNode = reverseList2(ln[0]);
        System.out.println("=========反转前后========");

        while (testNode != null) {
            System.out.println(testNode.val);
            testNode = testNode.next;
        }
    }
}
