package com.xuyang.leetcode.questionBank;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Li Xuyang
 * @date 2020/6/26 22:28
 * 移除重复节点
 */
public class RemoveDuplicateNodes0201 {

    //编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

    /*
    方法一：哈希表
我们对给定的链表进行一次遍历，并用一个哈希集合（HashSet）来存储所有出现过的节点。
由于在大部分语言中，对给定的链表元素直接进行「相等」比较，实际上是对两个链表元素的地址（而不是值）进行比较。
因此，我们在哈希集合中存储链表元素的值，方便直接使用等号进行比较。
具体地，我们从链表的头节点head 开始进行遍历，遍历的指针记为pos。由于头节点一定不会被删除，因此我们可以枚举待移除节点的前驱节点，减少编写代码的复杂度。

     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        //对于重复的题特别好用
        Set<Integer> occurred = new HashSet<>();
        occurred.add(head.val);
        //相当于一个指针，操作指针实现对元素的删除等操作
        ListNode pos = head;
        //枚举前驱结点
        while (pos.next != null) {
            //当前待删除的结点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }

        }
        pos.next = null;
        return head;
    }

    /*
    时间换空间，不推荐
    不幸的是，在保证方法一时间复杂度 O(N)O(N) 的前提下，是不存在这样的方法的。因此我们需要增加时间复杂度，
    使得我们可以仅使用常数的空间来完成本题。一种简单的方法是，我们在给定的链表上使用两重循环，
    其中第一重循环从链表的头节点开始，枚举一个保留的节点，这是因为我们保留的是「最开始出现的节点」。第二重循环从枚举的保留节点开始，到链表的末尾结束，将所有与保留节点相同的节点全部移除。
    方法二的细节部分与方法一类似。第一重循环枚举保留的节点本身，而为了编码方便，第二重循环可以枚举待移除节点的前驱节点，
    方便我们对节点进行移除。这样一来，我们使用「时间换空间」的方法，就可以不使用临时缓冲区解决本题了。
     */
    public ListNode removeDuplicateNodes2(ListNode head) {
        ListNode ob = head;
        while (ob != null) {
            ListNode oc = ob;
            while (oc.next != null) {
                if (oc.next.val == ob.val) {
                    oc.next = oc.next.next;
                } else {
                    oc = oc.next;
                }
            }
            ob = ob.next;
        }
        return head;
    }



}
