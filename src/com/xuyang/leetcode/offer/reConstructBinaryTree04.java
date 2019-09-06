package com.xuyang.leetcode.offer;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * date  2019/9/6 22:12
 * 重建二叉树
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class reConstructBinaryTree04 {

//    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
//        return root;
//    }


    // 前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
//    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
//
//        if (startPre > endPre || startIn > endIn)
//            return null;
//        TreeNode root = new TreeNode(pre[startPre]);
//
//        for (int i = startIn; i <= endIn; i++)
//            if (in[i] == pre[startPre]) {
//                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
//                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
//                break;
//            }
//
//        return root;
//    }


    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {//找到中序遍历序列中，根结点所在位置，以便分割出左子树和右子树做递归操作
                // copyOfRange 数组截取返回一个新数组
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return node;
    }

    public static void main(String[] args) {
        preOrder(reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8},
                new int[]{4, 7, 2, 1, 5, 3, 8, 6}));
    }

    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        if (treeNode.left != null) {
            preOrder(treeNode.left);
        }
        if (treeNode.right != null) {
            preOrder(treeNode.right);
        }
    }
}
