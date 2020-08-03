package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/3 21:37
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class GetKthFromEnd22 {
    /*
    输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
    例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     */

    //计算链表长度
    public ListNode getKthFromEnd(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        for (int i = 0; i < len - k; i++) {

            head = head.next;
        }

        return head;
    }

    //双指针
    //这个思路要学会，两个指针相差k
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode former = head;
        ListNode latter = head;
        for (int i = 0; i < k; i++) {
            //判空
            if (former == null) {
                return null;
            }
           former = former.next;

        }

        while (former != null) {
            former = former.next;
            latter = latter.next;
        }

        return latter;
    }

}
