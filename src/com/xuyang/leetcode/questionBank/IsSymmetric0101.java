package com.xuyang.leetcode.questionBank;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Li Xuyang
 * @date 2020/5/31 10:46
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class IsSymmetric0101 {
    /*

    递归的难点在于：找到可以递归的点 为什么很多人觉得递归一看就会，一写就废。 或者说是自己写无法写出来，关键就是你对递归理解的深不深。

对于此题： 递归的点怎么找？从拿到题的第一时间开始，思路如下：

1.怎么判断一棵树是不是对称二叉树？ 答案：如果所给根节点，为空，那么是对称。如果不为空的话，当他的左子树与右子树对称时，他对称

2.那么怎么知道左子树与右子树对不对称呢？在这我直接叫为左树和右树 答案：如果左树的左孩子与右树的右孩子对称，左树的右孩子与右树的左孩子对称，那么这个左树和右树就对称。

仔细读这句话，是不是有点绕？怎么感觉有一个功能A我想实现，但我去实现A的时候又要用到A实现后的功能呢？

当你思考到这里的时候，递归点已经出现了： 递归点：我在尝试判断左树与右树对称的条件时，发现其跟两树的孩子的对称情况有关系。

想到这里，你不必有太多疑问，上手去按思路写代码，函数A（左树，右树）功能是返回是否对称
     */

    //给定一个二叉树，检查它是否是镜像对称的。

    //如果一个树的左子树与右子树镜像对称，那么这个树是对称的。
    public boolean isSymmetric(TreeNode root) {
        return checkMirror(root, root);

    }

    private boolean checkMirror(TreeNode p, TreeNode q) {
        //树同时为空
        if (p == null && q == null) {
            return true;
        }
        //只有一个为空
        if (p == null || q == null) {
            return false;
        }

        //都非空的情况
        return (p.val == q.val) && checkMirror(p.left, q.right) && checkMirror(p.right, q.left);

    }

    //迭代
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        //推入跟结点两遍
        q.add(root);
        q.add(root);

        /*
        poll,peek,element的共同点：
    都是返回队列中的首个元素
    不同点：

    poll：将首个元素从队列中弹出，如果队列是空的，就返回null
    peek：查看首个元素，不会移除首个元素，如果队列是空的就返回null
    element：查看首个元素，不会移除首个元素，如果队列是空的就抛出异常NoSuchElementException
         */
        while (!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1==null&&t2==null){
                continue;
            }
            if (t1==null||t2==null){
                return false;
            }
            if (t1.val!=t2.val){
                return false;
            }

            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
