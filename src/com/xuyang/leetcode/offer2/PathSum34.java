package com.xuyang.leetcode.offer2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/8/9 20:34
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class PathSum34 {
    //输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
    // 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
    /*
    算法流程：
        pathSum(root, sum) 函数：

        初始化： 结果列表 res ，路径列表 path 。
        返回值： 返回 res 即可。
        recur(root, tar) 函数：

        递推参数： 当前节点 root ，当前目标值 tar 。
        终止条件： 若节点 root 为空，则直接返回。
        递推工作：
            1，路径更新： 将当前节点值 root.val 加入路径 path ；
            2，目标值更新： tar = tar - root.val（即目标值 tar 从 sum 减至 00 ）；
            3，路径记录： 当 ① root 为叶节点 且 ② 路径和等于目标值 ，则将此路径 path 加入 res 。
            4，先序遍历： 递归左 / 右子节点。
            5，路径恢复： 向上回溯前，需要将当前节点从路径 path 中删除，即执行 path.pop() 。
     */
    //回溯法
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    private void recur(TreeNode root, int tar) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        tar -= root.val;
        //满足才加入res
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        recur(root.left, tar);
        recur(root.right, tar);
        //这里产生回溯
        path.removeLast();

    }
}
