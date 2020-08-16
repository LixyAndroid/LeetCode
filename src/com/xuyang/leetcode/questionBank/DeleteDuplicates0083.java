package com.xuyang.leetcode.questionBank;

import java.util.HashMap;

/**
 * @author Li Xuyang
 * @date 2020/8/17 00:20
 * 删除排序链表中的重复元素
 */
public class DeleteDuplicates0083 {
    //给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

    //有序无序都可以的
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ListNode p = new ListNode(-1);//加一个头结点
        p.next = head;
        ListNode pre = p;//两个一前一后临时指针
        ListNode cur = p.next;
        while (pre != null && pre.next != null) {
            if (map.containsKey(cur.val)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                map.put(cur.val, 1);
                pre = cur;
                cur = cur.next;
            }
        }
        return p.next;
    }

    /**
     * 双重循环遍历链表,时间复杂度o(n^2)
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode root = p;
        while (p != null) {
            ListNode q = p;
            while (q.next != null) {
                if (p.val == q.next.val) {
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
            }
            p = p.next;
        }
        return root;
    }

    //这是一个简单的问题，仅测试你操作列表的结点指针的能力。
    // 由于输入的列表已排序，因此我们可以通过将结点的值与它之后的结点进行比较来确定它是否为重复结点。如果它是重复的，我们更改当前结点的 next 指针，以便它跳过下一个结点并直接指向下一个结点之后的结点。
    //直接法
    public static ListNode deleteDuplicates3(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }
}
