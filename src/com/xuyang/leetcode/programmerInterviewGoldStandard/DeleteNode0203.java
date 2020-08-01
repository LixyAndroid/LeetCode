package com.xuyang.leetcode.programmerInterviewGoldStandard;

/**
 * @author Li Xuyang
 * @date 2020/8/1 12:27
 * 面试题 02.03. 删除中间节点
 */
public class DeleteNode0203 {
    //实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
    //杀不掉我，我就变成你，然后再干掉你，就等于杀死了自己。
    public void deleteNode(ListNode node) {
        //思路：将下一个结点的值赋给当前节点，当前节点的下一个结点为下下一个结点。
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
