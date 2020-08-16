package com.xuyang.leetcode.offer2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/7/6 22:18
 * 二叉树的深度
 */
public class MaxDepth55 {

    // DFS, 深度优先遍历
    /*
    算法解析：
    终止条件： 当 root 为空，说明已越过叶节点，因此返回 深度 00 。
    递推工作： 本质上是对树做后序遍历。
    计算节点 root 的 左子树的深度 ，即调用 maxDepth(root.left)；
    计算节点 root 的 右子树的深度 ，即调用 maxDepth(root.right)；
    返回值： 返回 此树的深度 ，即 max(maxDepth(root.left), maxDepth(root.right)) + 1。
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //BFS, 层序遍历
    //树的层序遍历/广度优先搜索往往利用队列实现。
    // 关键：每遍历一层，则计数器+1，直到遍历完成，则可得到树的深度。

    /*
    特例处理： 当 root 为空，直接返回 深度 0 。
    初始化： 队列 queue （加入根节点 root ），计数器 res = 0。
    循环遍历： 当 queue 为空时跳出。
    初始化一个空列表 tmp ，用于临时存储下一层节点；
    遍历队列： 遍历 queue 中的各节点 node ，并将其左子节点和右子节点加入 tmp；
    更新队列： 执行 queue = tmp ，将下一层节点赋值给 queue；
    统计层数： 执行 res += 1 ，代表层数加 1；
    返回值： 返回 res 即可。
     */
    public int maxDepth2(TreeNode root) {

        List<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }}, tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            //这里容易出错！！
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            queue = tmp;
            res++;
        }
        return res;
    }

    //主要学习树的层序遍历
    public int maxDepth3(TreeNode root) {

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            List<TreeNode> temp = new LinkedList<>();
            //把一层都加入到temp
            for (TreeNode node : queue) {
                if (node.left != null) {
                    temp.add(node.left);
                }

                if (node.right != null) {
                    temp.add(node.right);
                }

            }
            queue = temp;
            res += 1;


        }
        return res;
    }

}
