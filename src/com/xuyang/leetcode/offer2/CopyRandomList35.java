package com.xuyang.leetcode.offer2;

import java.util.HashMap;

/**
 * @author Li Xuyang
 * @date 2020/8/2 12:38
 * 剑指 Offer 35. 复杂链表的复制
 */


public class CopyRandomList35 {
    //请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
    // 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

    //复制就是深拷贝，要new出来，对每个node要创建出来
    public RandomNode copyRandomList(RandomNode head) {
        if (head==null){
            return null;
        }

        RandomNode currentNode = head;
        //1,复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        //拷贝链表，并且把链表连接起来

        while (currentNode!=null){

            RandomNode cloneNode = new RandomNode(currentNode.val);
            RandomNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        //指定随即指针
        currentNode = head;

        //2,重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while (currentNode!=null){
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }
        //拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = head;
        //用于返回的拷贝头节点
        RandomNode pCloneHead = head.next;
        while (currentNode!=null){

            //拷贝节点
            RandomNode cloneNode = currentNode.next;
            currentNode.next=cloneNode.next;
            //拷贝节点的下一个节点指向下一个原节点的下一个节点
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            //将当前节点指向下一个原节点
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }

    public static RandomNode copyRandomList2(RandomNode pHead) {

        if (pHead == null) {
            return null;
        }

        RandomNode p1 = pHead;
        RandomNode p2 = pHead;
        HashMap<RandomNode, RandomNode> map = new HashMap<>();

        //先存

        while (p1 != null) {

            map.put(p1, new RandomNode(p1.val));
            p1 = p1.next;
        }

        //处理指针
        while (p2 != null) {
            if (p2.next != null) {
                //指定next指针
                map.get(p2).next = map.get(p2.next);
            } else {
                map.get(p2).next = null;
            }
            //指定random指针
            map.get(p2).random = map.get(p2.random);
            p2 = p2.next;
        }

        return map.get(pHead);
    }


}
