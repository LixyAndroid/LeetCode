package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/4/11 15:29
 * 对称的二叉树
 */
public class IsSymmetrical57 {
    //请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

    /*
    做这种题也没太多诀窍啦技巧啦什么的，
    就是按题意先画一棵“大”一点的对称二叉树，
    然后按树的一层一层比较一下，看看怎么算是满足对称的二叉树，思路就有了。
     */
    public boolean judge(TreeNode node1,TreeNode node2){

        if (node1==null&&node2==null){
            return true;
        }else if (node1==null||node2==null){
            return false;
        }

        if (node1.val !=node2.val){
            return false;
        }else {
            return judge(node1.left,node2.right)&&judge(node1.right,node2.left);
        }
    }

    public boolean isSymmetrical(TreeNode pRoot){
        return pRoot==null||judge(pRoot.left,pRoot.right);
    }
}
