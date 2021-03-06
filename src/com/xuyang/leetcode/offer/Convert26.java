package com.xuyang.leetcode.offer;

import java.util.ArrayList;

/**
 * @author Li Xuyang
 * @date 2020/3/20 17:25
 * 二叉搜索树与双向链表
 */
public class Convert26 {

    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        midTraversal(pRootOfTree, list);

        return modify(list);
    }


    //中序遍历
    public void midTraversal(TreeNode pRootOfTree, ArrayList<TreeNode> list) {

        if (pRootOfTree.left != null) {
            midTraversal(pRootOfTree.left, list);
        }

        list.add(pRootOfTree);

        if (pRootOfTree.right != null) {
            midTraversal(pRootOfTree.right, list);
        }
    }

    //遍历list,修改指针
    public TreeNode modify(ArrayList<TreeNode> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }




    TreeNode pre = null;

    public TreeNode convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        convert2(pRootOfTree.right);
        if (pre == null)
            pre = pRootOfTree;
        else {
            pRootOfTree.right = pre;
            pre.left = pRootOfTree;
            pre = pRootOfTree;
        }
        convert2(pRootOfTree.left);
        return pre;
    }


}
