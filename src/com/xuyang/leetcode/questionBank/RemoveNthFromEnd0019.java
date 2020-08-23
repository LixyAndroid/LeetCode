package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/8/23 11:47
 * 19. 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd0019 {
    //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }
}
