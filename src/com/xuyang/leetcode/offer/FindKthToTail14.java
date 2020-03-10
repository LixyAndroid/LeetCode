package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/10 10:47
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail14 {

    //核心还是双指针，一快一慢
    //输入一个链表，输出该链表中倒数第k个结点。
    public static ListNode findKthToTail(ListNode head, int k) {
        ListNode fastNode = head;
        ListNode slowNode = head;


        if (k < 1) {
            throw new IllegalArgumentException("Not exist");
        }

        for (int i = 0; i < k; i++) {

            if (fastNode.next == null) {
                throw  new  IllegalArgumentException("Not exist");
            }
            fastNode = fastNode.next;
        }
        while (fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        return slowNode;

    }


    //输入一个链表，输出该链表中倒数第k个结点。
    public static ListNode findKthToTail2(ListNode head, int k) {
        ListNode resNode = head;


        int i = 0;

        while (head != null) {
            i++;
            head = head.next;
            if (i > k) {
                resNode = resNode.next;

            }


        }
        if (i < k || k < 1) {

            throw new IllegalArgumentException("Not exist");
        }

        return resNode;

    }


    public static void main(String[] args) {
        ListNode[] ln = new ListNode[6]; // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        for (int i = 0; i < ln.length; i++) {
            ln[i] = new ListNode(0);
            ln[i].val = i + 1;
            if (i > 0)
                ln[i - 1].next = ln[i];
        }

        System.out.println(findKthToTail(ln[0], 9).val);

        System.out.println(findKthToTail2(ln[0], 3).val);
    }
}
