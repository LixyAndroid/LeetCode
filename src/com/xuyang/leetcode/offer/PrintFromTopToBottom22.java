package com.xuyang.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Li Xuyang
 * @date 2020/3/18 21:46
 * 从上往下打印二叉树
 */
public class PrintFromTopToBottom22 {

    //从上往下打印出二叉树的每个节点，同层节点从左至右打印。


    /*
    在Java中Queue是和List、Map同等级别的接口，LinkedList中也实现了Queue接口，该接口中的主要函数有：
    容量不够或队列为空时不会抛异常：offer（添加队尾元素）、peek（访问队头元素）、poll（访问队头元素并移除）
    容量不够或队列为空时抛异常：add、element（访问队列元素）、remove（访问队头元素并移除）
     */
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            result.add(temp.val);

            // 如果左子结点不为空，则左子结点添加至队尾

            if (temp.left != null) {
                queue.offer(temp.left);
            }

            // 如果右子结点不为空，则右子结点添加至队尾

            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        TreeNode root = new TreeNode(0);
        root.val = 8;
        root.left = new TreeNode(0);
        root.left.val = 6;
        root.left.left = new TreeNode(0);
        root.left.left.val = 5;
        root.left.right = new TreeNode(0);
        root.left.right.val = 7;
        root.right = new TreeNode(0);
        root.right.val = 10;
        root.right.left = new TreeNode(0);
        root.right.left.val = 9;
        root.right.right = new TreeNode(0);
        root.right.right.val = 11;
        ArrayList<Integer> printList1 = new ArrayList<>();
        printList1 = printFromTopToBottom(root);
        System.out.println(printList1);

        //         1
        //        /
        //       3
        //      /
        //     5
        //    /
        //   7
        //  /
        // 9
        TreeNode root2 = new TreeNode(0);
        root2.val = 1;
        root2.left = new TreeNode(0);
        root2.left.val = 3;
        root2.left.left = new TreeNode(0);
        root2.left.left.val = 5;
        root2.left.left.left = new TreeNode(0);
        root2.left.left.left.val = 7;
        root2.left.left.left.left = new TreeNode(0);
        root2.left.left.left.left.val = 9;
        ArrayList<Integer> printList2 = new ArrayList<>();
        printList2 = printFromTopToBottom(root2);
        System.out.println(printList2);


        // 0
        //  \
        //   2
        //    \
        //     4
        //      \
        //       6
        //        \
        //         8
        TreeNode root3 = new TreeNode(0);
        root3.val = 0;
        root3.right = new TreeNode(0);
        root3.right.val = 2;
        root3.right.right = new TreeNode(0);
        root3.right.right.val = 4;
        root3.right.right.right = new TreeNode(0);
        root3.right.right.right.val = 6;
        root3.right.right.right.right = new TreeNode(0);
        root3.right.right.right.right.val = 8;
        ArrayList<Integer> printList3 = new ArrayList<>();
        printList3 = printFromTopToBottom(root3);
        System.out.println(printList3);

        // 1
        TreeNode root4 = new TreeNode(0);
        root4.val = 1;

        ArrayList<Integer> printList4 = new ArrayList<>();
        printList4 = printFromTopToBottom(root4);
        System.out.println(printList4);

        // null

        ArrayList<Integer> printList5 = new ArrayList<>();
        printList5 = printFromTopToBottom(null);
        System.out.println(printList5);

    }
}
