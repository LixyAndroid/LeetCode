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

    public static void main(String[] args) {
        //-构造单链表start----
        int[] num = { 2, 3, 3, 5, 7, 8, 8, 8, 9, 9, 10 };
        ListNode head = new ListNode(num[0]);
        ListNode pre = head;
        for (int i = 1; i < num.length; i++) {
            ListNode node = new ListNode(num[i]);
            pre.next = node;
            pre = node;
        }
        //-构造单链表end-----



        //输出
        System.out.print("删除前：");
        for (pre = head.next; pre !=null ; pre = pre.next) {

            System.out.print(pre.val + " ");
        }

        deleteDulp(head);
        System.out.println();
        System.out.print("删除后：");

        for (pre = head.next; pre !=null ; pre = pre.next) {

            System.out.print(pre.val + " ");
        }



    }
}
