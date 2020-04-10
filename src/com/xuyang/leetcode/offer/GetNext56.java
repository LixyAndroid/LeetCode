package com.xuyang.leetcode.offer;

import java.util.ArrayList;

/**
 * @author Li Xuyang
 * @date 2020/4/10 20:56
 * 二叉树的下一个结点
 */
public class GetNext56 {

    //给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
    // 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

    /*

    既然给了二叉树的某个结点，
    且二叉树存储着指向父结点的指针（next），那我们可以先找到根节点，再对树进行中序遍历，最后根据中序遍历结果找到给定结点的下一结点
     */

    static ArrayList<TreeLinkNode> list = new ArrayList<>();
    public TreeLinkNode getNext(TreeLinkNode pNode) {

        TreeLinkNode per = pNode;
        while (per.next!=null){
            per = per.next;
        }

        InOrder(per);
        for (int i = 0; i < list.size(); i++) {
            if (pNode==list.get(i)){
                return i==list.size()-1?null:list.get(i+1);
            }
        }
        return null;
    }

    //中序
    static void InOrder(TreeLinkNode pNode){
        if (pNode!=null){
            InOrder(pNode.left);
            list.add(pNode);
            InOrder(pNode.right);
        }
    }
}
