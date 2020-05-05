package com.xuyang.leetcode.questionBank;


import java.util.Stack;

/**
 * @author Li Xuyang
 * @date 2020/5/5 10:54
 * 验证二叉搜索树
 */

public class IsValidBST0098 {


    /*
    方法二：中序遍历
    思路和算法

    基于方法一中提及的性质，我们可以进一步知道二叉搜索树「中序遍历」得到的值构成的序列一定是升序的，这启示我们在中序遍历的时候实时检查当前节点的值是否大于前一个中序遍历到的节点的值即可。如果均大于说明这个序列是升序的，整棵树是二叉搜索树，否则不是，下面的代码我们使用栈来模拟中序遍历的过程。

    可能由读者不知道中序遍历是什么，我们这里简单提及一下，中序遍历是二叉树的一种遍历方式，它先遍历左子树，再遍历根节点，最后遍历右子树。而我们二叉搜索树保证了左子树的节点的值均小于根节点的值，根节点的值均小于右子树的值，因此中序遍历以后得到的序列一定是升序序列。


     */
    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack  = new Stack<>();
        double inorder = -Double.MAX_VALUE;


        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root =root.left;
            }
            root = stack.pop();
            //如果中序遍历得到节点的值小于等于前一个inorder,说明不是二叉搜素树
            if(root.val<=inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }

        return true;
    }


    //递归
    public boolean isValidBST2(TreeNode root) {
        return helper(root,null,null);
    }
    public boolean helper(TreeNode node,Integer lower,Integer upper){

        if (node==null){
            return true;
        }

        int val  = node.val;
        if (lower!=null&&val<=lower){
            return false;
        }
        if (upper!=null&&val>=upper){
            return false;
        }
        if (!helper(node.right,val,upper)){
            return false;
        }

        if (!helper(node.left,lower,val)){
            return false;
        }

        return true;

    }

}
