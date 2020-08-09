package com.xuyang.leetcode.offer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Li Xuyang
 * @date 2020/8/9 16:46
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 */
public class LevelOrder332 {
    //请实现一个函数按照之字形顺序打印二叉树，
    // 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
    /*
    方法一：层序遍历 + 双端队列
    利用双端队列的两端皆可添加元素的特性，设打印列表（双端队列） tmp ，并规定：
        奇数层 则添加至 tmp 尾部 ，
        偶数层 则添加至 tmp 头部 。
    算法流程：
        1, 特例处理： 当树的根节点为空，则直接返回空列表 [] ；
        2,初始化： 打印结果空列表 res ，包含根节点的双端队列 deque ；
        3,BFS 循环： 当 deque 为空时跳出；
            1,新建列表 tmp ，用于临时存储当前层打印结果；
            2,当前层打印循环： 循环次数为当前层节点数（即 deque 长度）；
                1,出队： 队首元素出队，记为 node；
                2,打印： 若为奇数层，将 node.val 添加至 tmp 尾部；否则，添加至 tmp 头部；
                3,添加子节点： 若 node 的左（右）子节点不为空，则加入 deque ；
            3,将当前层结果 tmp 转化为 list 并添加入 res ；
        4,返回值： 返回打印结果列表 res 即可；
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }


        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();

            for (int i = queue.size(); i > 0; i--) {

                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) {//偶数层 -》队列头部
                    tmp.addLast(node.val);
                } else { //奇数层 -》 队列尾部
                    tmp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            res.add(tmp);

        }
        return res;

    }
}
