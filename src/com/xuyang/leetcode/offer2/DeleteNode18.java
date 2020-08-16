package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/1 11:40
 * 剑指 Offer 18. 删除链表的节点
 */
public class DeleteNode18 {
    //给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
    //
    //返回删除后的链表的头节点。
    public ListNode deleteNode(ListNode head, int val) {
        //一个用于输出，一个用于遍历
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //头结点是要删除的点，直接删除
        if (head.val == val) {
            return head.next;
        }
        while (head != null && head.next != null) {
            if (head.next.val == val) {//删除
                head.next = head.next.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public static ListNode deleteNode2(ListNode head, ListNode val) {
        if (head == null || val == null) {
            return null;
        }
        if (val.next != null) {   // 待删除节点不是尾节点
            ListNode next = val.next;
            val.val = next.val;
            val.next = next.next;
        } else if (head == val) {   // 待删除节点只有一个节点，此节点为头节点
            head = null;
        } else {   // 待删除节点为尾节点
            ListNode cur = head;
            while (cur.next != val) {
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }

}
