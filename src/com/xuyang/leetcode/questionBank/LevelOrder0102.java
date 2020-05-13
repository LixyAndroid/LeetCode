package com.xuyang.leetcode.questionBank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/5/13 10:32
 * 二叉树的层序遍历
 */
public class LevelOrder0102 {

    //给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
    List<List<Integer>> levels = new ArrayList<>();


    public void helper(TreeNode node, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }

        levels.get(level).add(node.val);

        if (node.left != null) {
            helper(node.left, level + 1);
        }

        if (node.right != null) {
            helper(node.left, level + 1);
        }

    }


    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return levels;
        }
        helper(root, 0);
        return levels;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        //按层遍历即可
        List<List<Integer>> lists = new ArrayList<>();

        if (root==null){
            return lists;
        }

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode remove = nodes.remove(0);
                list.add(remove.val);
                if (remove.left!=null){
                    nodes.add(remove.left);
                }
                if (remove.right!=null){
                    nodes.add(remove.right);
                }

            }
            lists.add(list);

        }
        return lists;

    }
}
