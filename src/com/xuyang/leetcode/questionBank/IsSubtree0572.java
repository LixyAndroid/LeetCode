package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/5/7 10:45
 * 另一个树的子树
 */
public class IsSubtree0572 {

    //给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
    // s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

    /*

    看到题目描述，首先判断一个树是否是另一棵树的子树，
    很明显想到可以用递归，但是两棵树完全相同也可以看做一棵树是另一棵树的子树。
    所以自然而然想到用一个判断两棵树是否相同的递归函数。
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {

        //t为null，一定都是true
        if (t==null){
            return true;
        }
        //这里t不一定为null,只要s为null,只要s为null,肯定为false
        if (s==null){
            return false;
        }

        return isSubtree(s.left,t)||isSubtree(s.right,t)||isSameTree(s,t);
    }

    //判断两棵树是否完全相同
    public boolean isSameTree(TreeNode s,TreeNode t){

        if (s==null&&t==null){
            return true;
        }
        if (s==null||t==null){
            return false;
        }
        if (s.val!=t.val){
            return false;
        }

        return isSameTree(s.left,t.left)&&isSameTree(s.right,t.right);

    }
}
