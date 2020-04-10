package com.xuyang.leetcode.offer;

import java.util.HashSet;

/**
 * @author Li Xuyang
 * @date 2020/4/10 20:08
 * 删除链表中重复的结点
 */
public class DeleteDuplication55 {


    //对指针又有了深层的理解
    //本题看着不难，但是不好写

    /*
    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    */

    //多次遍历，第一次遍历把重复的结点值存入 set 容器，
    // 第二次遍历，当结点值存储在 set 容器中，就删除该结点
    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        //先找出相同的结点，存入set
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                set.add(cur.val);
            }
            pre = cur;
            cur = cur.next;
        }

        //在根据相同节点删除
        //先删除头部
        while (pHead != null && set.contains(pHead.val)) {
            pHead = pHead.next;
        }

        if (pHead == null) {
            return null;
        }

        //再删除中间结点,两个指针，不过还是有疑问
        pre = pHead;
        cur = pHead.next;

        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return pHead;


    }


    /*

    遍历的同时删除
    借助辅助头结点，可避免单独讨论头结点的情况。
    设置两个结点 pre 和 cur，当 cur 和 cur.next 值相等，
    cur 一直向前走，直到不等退出循环，这时候 cur 指的值还是重复值，
    调整 cur 和 pre 的指针再次判断
     */

    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        //自己构建辅助头结点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {

            if (cur.next != null && cur.next.val == cur.val) {
                //相同结点一直前进
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                //退出循环时，cur指向重复值，也需要删除，而cur.next指向第一个不重复的值
                cur = cur.next;
                pre.next = cur;

            } else {

                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }
}
