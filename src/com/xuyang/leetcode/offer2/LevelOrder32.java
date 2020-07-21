package com.xuyang.leetcode.offer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Li Xuyang
 * @date 2020/7/20 22:09
 * 从上到下打印二叉树
 */
public class LevelOrder32 {
    //从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>() {
            {
                add(root);
            }
        };
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }

        }

        int[] res = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

}
