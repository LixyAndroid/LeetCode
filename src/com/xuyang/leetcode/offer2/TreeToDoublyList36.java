package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/6/29 22:40
 * 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class TreeToDoublyList36 {
    /*
    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     */
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;//进行头节点和尾节点的相互指向，这两句的顺序也是可以颠倒的
        return head;
    }

    void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
        if (pre != null) {
            pre.right = cur;
        } else {       //反之，pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作。
            head = cur;
        }
        cur.left = pre;//pre是否为null对这句没有影响,且这句放在上面两句if else之前也是可以的。
        pre = cur;//pre指向当前的cur
        dfs(cur.right);//全部迭代完成后，pre指向双向链表中的尾节点
    }
}
