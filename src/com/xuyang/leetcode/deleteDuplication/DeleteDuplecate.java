package com.xuyang.leetcode.deleteDuplication;

import java.util.HashMap;

/**
 * @author Li Xuyang
 * date  2019/7/27 13:17
 *
 * 删除链表重复节点(重复节点只保留一个)
 */
public class DeleteDuplecate {
    /**
     * HashMap,时间复杂度o(n)
     * @param head
     * @return
     */
    public static ListNode deleteDulp(ListNode head){
        if(head==null || head.next==null)
            return head;
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        ListNode p=new ListNode(-1);//加一个头结点
        p.next=head;
        ListNode pre=p;//两个一前一后临时指针
        ListNode cur=p.next;
        while(pre!=null && pre.next!=null){
            if(map.containsKey(cur.val)){
                pre.next=cur.next;
                cur=cur.next;
            }else{
                map.put(cur.val,1);
                pre=cur;
                cur=cur.next;
            }
        }
        return p.next;
    }
    /**
     * 双重循环遍历链表,时间复杂度o(n^2)
     * @param head
     * @return
     */
    public static ListNode deleteDulp2(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode p=head;
        ListNode root=p;
        while(p!=null){
            ListNode q=p;
            while(q.next!=null){
                if(p.val==q.next.val){
                    q.next=q.next.next;
                }else{
                    q=q.next;
                }
            }
            p=p.next;
        }
        return root;
    }

    /**
     * 新增节点
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
        DeleteDuplecate deleteDuplecate = new DeleteDuplecate();

        //链表的头指针
        ListNode head = null;

        //新增节点,第一次新增时需要返回头指针，用于定位链表
        head = deleteDuplecate.insertNode(2, head);
        deleteDuplecate.insertNode(1, head);
        deleteDuplecate.insertNode(5, head);
        deleteDuplecate.insertNode(3, head);
        deleteDuplecate.insertNode(4, head);
        deleteDuplecate.insertNode(3, head);
        deleteDuplecate.insertNode(1, head);

        System.out.println("原链表：");
        deleteDuplecate.printList(head);

        //排序链表
        head = deleteDulp(head);

        System.out.println("去重后：");
        deleteDuplecate.printList(head);
    }
}
