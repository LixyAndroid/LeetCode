package com.xuyang.leetcode.deleteNode;

/**
 * @author Li Xuyang
 * date  2019/7/29 10:38
 * <p>
 * 删除指定的节点
 * 方法：与下一个节点交换
 * 从链表里删除一个节点 node 的最常见方法是修改之前节点的 next 指针，使其指向之后的节点。
 * <p>
 * 因为，我们无法访问我们想要删除的节点 之前 的节点，我们始终不能修改该节点的 next 指针。
 * 相反，我们必须将想要删除的节点的值替换为它后面节点中的值，然后删除它之后的节点。
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void deleteNode(ListNode node) {
        //删除节点了val 为next的val
        node.val = node.next.val;
        //删除的下一个，等于下下一个
        node.next = node.next.next;
    }


    /**
     * 新增节点
     *
     * @param data
     */
    public ListNode insertNode(int data, ListNode head) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            return head;
        }
        ListNode curNode = head;
        //循环找到当前链表的尾节点
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        //尾节点的指针指向新增加的节点
        curNode.next = node;
        return head;
    }

    /**
     * 打印链表
     */
    public void printList(ListNode head) {
        ListNode curNode = head;
        //循环遍历到尾节点
        while (curNode != null) {
            System.out.print(curNode.val + "  ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //链表的头指针
        ListNode head = null;

        //新增节点,第一次新增时需要返回头指针，用于定位链表
        head = solution.insertNode(2, null);
        solution.insertNode(5, head);
        solution.insertNode(3, head);
        solution.insertNode(4, head);
        solution.insertNode(1, head);

        System.out.println("原链表：");
        solution.printList(head);

        //head为2,顺序为上述插入的顺序，head.next为5，所以就把5删除了，
        // 同理传入只head，就把2给删除了,head.next.next就把3给删除了
        deleteNode(head.next);

        System.out.println("删除后：");
        solution.printList(head);
    }
}
