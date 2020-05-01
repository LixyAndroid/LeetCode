package com.xuyang.leetcode.offer;


/**
 * @author Li Xuyang
 * @date 2020/3/10 20:41
 */
public class Merge16 {


    //输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

    //非递归
    public  static ListNode merge(ListNode list1,ListNode list2){

        if (list1==null){
            return  list2;
        }else  if (list2==null){
            return list1;
        }

        ListNode resNode = new  ListNode(0);
        ListNode temp =  resNode;
        while (list1!= null && list2!=null){
            if (list1.val<list2.val){
                temp.next = list1;
                list1 =list1.next;
            }else {
                temp.next = list2;
                list2 = list2.next;
            }

            //后移，重要
            temp = temp.next;
        }

        if (list1!=null){
            temp.next = list1;
        }
        if (list2!=null){
            temp.next = list2;
        }

        return resNode.next;
    }

    //递归
    public  static ListNode merge2(ListNode list1,ListNode list2){

        if (list1==null){
            return  list2;
        }else  if (list2==null){
            return list1;
        }

        ListNode mergeNode = list1;
        if (list1.val<list2.val){

            mergeNode.next = merge2(list1.next,list2);
        }else {
            //不能少了这句
            mergeNode = list2;
            mergeNode.next = merge2(list1,list2.next);
        }

        return  mergeNode;




    }

    /**
     * 输出链表到元素值
     *
     * @param head 链表到头结点
     */
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {

        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 10 };

        ListNode[] ln1 = new ListNode[arr1.length];
        for (int i = 0; i < ln1.length; i++) {
            ln1[i] = new ListNode(0);
            ln1[i].val = arr1[i];
            if (i > 0)
                ln1[i - 1].next = ln1[i];
        }
// 定义链表2
        ListNode[] ln2 = new ListNode[arr2.length];
        for (int i = 0; i < ln1.length; i++) {
            ln2[i] = new ListNode(0);
            ln2[i].val = arr2[i];
            if (i > 0)
                ln2[i - 1].next = ln2[i];
        }

        ListNode resNode = new ListNode(0);

        resNode = merge(ln1[0], ln2[0]);

        printList(resNode);

    }

}
