package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/4/27 10:29
 * 反转链表
 */
public class ReverseList0206 {


    /*
    反转一个单链表。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

     */


    /*
    方法一：迭代
假设存在链表 1 → 2 → 3 → Ø，我们想要把它改成 Ø ← 1 ← 2 ← 3。

在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！


     */
    public ListNode reverseList(ListNode head) {

        //用来保存
        ListNode prev = null;
        //用来遍历
        ListNode curr = head;

        while (curr != null) {
            //nextTemp 表示下一个结点，保存
            ListNode nextTemp = curr.next;
            //反转
            //将prev赋值给curr.next
            curr.next = prev;
            //将curr赋值prev
            prev = curr;
            //遍历
            curr = nextTemp;

        }
        return prev;

    }

    /*
    我们希望nk+1的下一个节点指向nk。所以,nk.next.next = nk。
     */
    public ListNode reverseList2(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next=head;
        head.next=null;
        return p;

    }
}
