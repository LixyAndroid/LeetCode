package com.xuyang.leetcode.merge;

/**
 * @author Li Xuyang
 * @date 2020/3/8 13:04
 *
 * class Node {
 *      int value;
 *      Node next;
 *      static Node merge(Node nA, Node nB);
 * }
 * 对于Node类的对象node，当node.next为空时，表示node为末尾节点
 * nA、nB为升序链表的头结点，即nA.value <= nA. .next.value <= nA.next.next.value <= ...
 * nB 也满足这样的约束
 */
public class Node {
    int value;
    Node next;

}


