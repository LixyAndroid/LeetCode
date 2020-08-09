package com.xuyang.leetcode.offer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Li Xuyang
 * @date 2020/8/9 17:17
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 */
public class LevelOrder232 {

    //从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
    //需要分层
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            for (int i = queue.size(); i > 0; i--) { //一层

                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }


            }

            res.add(list);
        }
        return res;

    }
}
