package com.xuyang.leetcode.offer2;

import com.xuyang.leetcode.offer.HasSubtree17;

/**
 * @author Li Xuyang
 * @date 2020/7/30 23:38
 * 重点！！！ 剑指 Offer 24. 反转链表
 */
public class ReverseList24 {

    //我清晰记得，以前在数据结构课上，老师和我们说：涉及到链表的操作，一定要在纸上把过程先画出来，再写程序。
    //
    //现在想想，这句话简直就是真理！
    //双指针
    //定义两个指针： pre 和 cur ；pre 在前 cur 在后。
    //每次让 pre 的 next 指向 cur ，实现一次局部反转
    //局部反转完成之后， pre 和 cur 同时往前移动一个位置
    //循环上述过程，直至 pre 到达链表尾部

    public ListNode reverseList(ListNode head) {
        //cur用来输出，pre用来遍历
        ListNode pre = null, cur = head;
        while (cur != null) {
            //存下一位
            ListNode temp = cur.next;
            //反转
            cur.next = pre;
            pre = cur;
            //遍历
            cur = temp;
        }
        return pre;
    }

    //递归
    //使用递归函数，一直递归到链表的最后一个结点，该结点就是反转后的头结点，记作 ret .
    //此后，每次函数在返回的过程中，让当前结点的下一个结点的 nextnext 指针指向当前节点。
    //同时让当前结点的 next 指针指向 NULL ，从而实现从链表尾部开始的局部反转
    //当递归函数全部出栈后，链表反转完成。

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //递归到最后
        ListNode ret = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }
}
