package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/1 11:40
 * 剑指 Offer 18. 删除链表的节点
 */
public class DeleteNode18 {
    //给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
    //
    //返回删除后的链表的头节点。
    public ListNode deleteNode(ListNode head, int val) {
        //一个用于输出，一个用于遍历
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //头结点是要删除的点，直接删除
        if (head.val == val) {
            return head.next;
        }
        while (head != null && head.next != null) {
            if (head.next.val == val) {//删除
                head.next = head.next.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public static ListNode deleteNode2(ListNode head, ListNode val) {
        if (head == null || val == null) {
            return null;
        }
        if (val.next != null) {   // 待删除节点不是尾节点
            ListNode next = val.next;
            val.val = next.val;
            val.next = next.next;
        } else if (head == val) {   // 待删除节点只有一个节点，此节点为头节点
            head = null;
        } else {   // 待删除节点为尾节点
            ListNode cur = head;
            while (cur.next != val) {
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
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
        DeleteNode18 solution = new DeleteNode18();

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
