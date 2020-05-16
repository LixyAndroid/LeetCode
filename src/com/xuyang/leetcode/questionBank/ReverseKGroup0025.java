package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/5/16 10:31
 * K 个一组翻转链表
 */
public class ReverseKGroup0025 {

    //给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
    //k 是一个正整数，它的值小于或等于链表的长度。
    //如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

    /*
    链表分区为已翻转部分+待翻转部分+未翻转部分
每次翻转前，要确定翻转链表的范围，这个必须通过 k 此循环来确定
需记录翻转链表前驱和后继，方便翻转完成后把已翻转部分和未翻转部分连接起来
初始需要两个变量 pre 和 end，pre 代表待翻转链表的前驱，end 代表待翻转链表的末尾
经过k此循环，end 到达末尾，记录待翻转链表的后继 next = end.next
翻转链表，然后将三部分链表连接起来，然后重置 pre 和 end 指针，然后进入下一次循环
特殊情况，当翻转部分长度不足 k 时，在定位 end 完成后，end==null，已经到达末尾，说明题目已完成，直接返回即可
时间复杂度为 O(n*K) 最好的情况为 O(n) 最差的情况未 O(n^2)
空间复杂度为 O(1) 除了几个必须的节点指针外，我们并没有占用其他空间
     */
    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode end = res;
        while (end.next!=null){
            for (int i=0;i<k&&end!=null;i++){
                end=end.next;
            }
            if (end==null){
                break;
            }


            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next=reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }

        return res.next;


    }

    public static ListNode reverse(ListNode node) {

        ListNode pre = null;
        ListNode curr = node;



        while (curr!=null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }

        return pre;


    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode res = reverseKGroup(node, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}
