package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/9/21 19:34
 * 两两交换链表中的节点
 */
public class SwapPairs0024 {
    //递归
    /*

    方法一：递归
这个题目要求我们从第一个节点开始两两交换链表中的节点，且要真正的交换节点。

算法：

从链表的头节点 head 开始递归。
每次递归都负责交换一对节点。由 firstNode 和 secondNode 表示要交换的两个节点。
下一次递归则是传递的是下一对需要交换的节点。若链表中还有节点，则继续递归。
交换了两个节点以后，返回 secondNode，因为它是交换后的新头。
在所有节点交换完成以后，我们返回交换后的头，实际上是原始链表的第二个节点。
     */
    public ListNode swapPairs(ListNode head) {
        if ((head == null) || head.next == null) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;

    }

    //迭代
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);

        dummy.next = head;
        ListNode prevNode = dummy;

        while ((head != null && head.next != null)) {

            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prevNode = firstNode;
            head = firstNode.next;
        }

        return dummy.next;

    }

}
