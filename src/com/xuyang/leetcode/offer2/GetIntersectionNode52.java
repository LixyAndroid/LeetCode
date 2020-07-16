package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/7/16 21:23
 * 两个链表的第一个公共节点
 */
public class GetIntersectionNode52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        //可以理解为两条链表最后都指向了同一个 null （None）节点，代替了不相交的特殊情况。 非常的巧妙。
        while (node1 != node2) {
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }
        return node1;
    }
}
