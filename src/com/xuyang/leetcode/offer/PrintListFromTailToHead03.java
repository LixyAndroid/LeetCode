package com.xuyang.leetcode.offer;

import java.util.ArrayList;

/**
 * @author Li Xuyang
 * date  2019/8/7 17:32
 * 从尾到头打印链表
 */
public class PrintListFromTailToHead03 {

    //  输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        //定义两个ArrayList list为存放listNode的各个元素，result为存放list逆序后的元素
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        //正序添加,关键性代码  只要listNode不为空就一直添加，添加完一个后 listNode = listNode.next
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        //逆序存放
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        //返回逆序
        return result;
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
            System.out.print(curNode.val + " -> ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrintListFromTailToHead03 printListFromTailToHead03 = new PrintListFromTailToHead03();

        //链表的头指针
        ListNode head = null;

        //新增节点,第一次新增时需要返回头指针，用于定位链表
        head = printListFromTailToHead03.insertNode(1, head);
        printListFromTailToHead03.insertNode(2, head);
        printListFromTailToHead03.insertNode(3, head);
        printListFromTailToHead03.insertNode(4, head);
        printListFromTailToHead03.insertNode(5, head);

        System.out.println("原链表：");
        printListFromTailToHead03.printList(head);

        ArrayList<Integer> arrayList = printListFromTailToHead03.printListFromTailToHead(head);

        System.out.println("逆序输出ArrayList：");

        System.out.println(arrayList);

        System.out.println("ArrayList每个位置上的值：");
        //foreach循环 输出值
        for (Integer integer : arrayList) {
            System.out.print(integer + "  ");
        }


    }

}
