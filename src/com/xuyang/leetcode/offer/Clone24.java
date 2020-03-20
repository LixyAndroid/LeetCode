package com.xuyang.leetcode.offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Li Xuyang
 * @date 2020/3/20 16:27
 */
public class Clone24 {
    public static RandomListNode clone(RandomListNode pHead) {

        if (pHead == null) {
            return null;
        }

        RandomListNode p1 = pHead;
        RandomListNode p2 = pHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        //先存

        while (p1 != null) {

            map.put(p1, new RandomListNode(p1.label));
            p1 = p1.next;
        }

        //处理指针
        while (p2 != null) {
            if (p2.next != null) {
                map.get(p2).next = map.get(p2.next);
            } else {
                map.get(p2).next = null;
            }

            map.get(p2).random = map.get(p2.random);
            p2 = p2.next;
        }

        return map.get(pHead);
    }


    public static RandomListNode clone2(RandomListNode pHead) {
        if (pHead==null){
            return null;
        }

        RandomListNode currentNode = pHead;
        //1,复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while (currentNode!=null){

            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;

        //2,重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while (currentNode!=null){
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }
        //拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (currentNode!=null){

            RandomListNode cloneNode = currentNode.next;
            currentNode.next=cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;


    }

    public static void main(String[] args) {
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //  |       |      /|\             /|\
        //  --------+--------               |
        //          -------------------------
        RandomListNode head = new RandomListNode(0);
        head.label = 1;
        head.next = new RandomListNode(0);
        head.next.label = 2;
        head.next.next = new RandomListNode(0);
        head.next.next.label = 3;
        head.next.next.next = new RandomListNode(0);
        head.next.next.next.label = 4;
        head.next.next.next.next = new RandomListNode(0);
        head.next.next.next.next.label = 5;

        head.random = head.next.next;
        head.next.random = head.next.next.next.next.next;
        head.next.next.next.random = head.next;

        RandomListNode tmp = head;

        RandomListNode newHead = clone(head);




        // 有指向自身的情况
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //         |       | /|\           /|\
        //         |       | --             |
        //         |------------------------|
        RandomListNode head2 = new RandomListNode(0);
        head2.label = 1;
        head2.next = new RandomListNode(0);
        head2.next.label = 2;
        head2.next.next = new RandomListNode(0);
        head2.next.next.label = 3;
        head2.next.next.next = new RandomListNode(0);
        head2.next.next.next.label = 4;
        head2.next.next.next.next = new RandomListNode(0);
        head2.next.next.next.next.label = 5;

        head2.next.random = head2.next.next.next.next;
        head2.next.next.next.random = head2.next.random;
        head2.next.next.random = head2.next.next;

        System.out.println("\n");
        tmp = head2;
        RandomListNode newHead2 = clone(head2);



        RandomListNode head3 = new RandomListNode(0);
        head3.label = 1;

        System.out.println("\n");
        tmp = head3;

        RandomListNode newHead3 = clone(head3);


        System.out.println("\n");
        RandomListNode head4 = clone(null);

    }
}
