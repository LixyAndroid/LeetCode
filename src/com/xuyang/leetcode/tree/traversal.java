package com.xuyang.leetcode.tree;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Li Xuyang
 * date  2019/7/26 17:31
 */
public class traversal {

    //数组转换成树
    public static TreeNode arraytotree(int[] arr, int strat, int end) {

        TreeNode root = null;
        if (end >= strat) {

            root = new TreeNode();
            int mid = (strat + end + 1) / 2;

            root.data = arr[mid];
            root.lChild = arraytotree(arr, strat, mid - 1);
            root.rChild = arraytotree(arr, mid + 1, end);
        } else {
            root = null;
        }
        return root;


    }


    /**
     * 中序遍历
     *
     * @param root
     */

    public static void printTreeMidOrder(TreeNode root) {
        if (root == null) return;

        //遍历root节点的左子树

        if (root.lChild != null) {
            printTreeMidOrder(root.lChild);
        }


        System.out.print(root.data + " ");

        if (root.rChild != null) {
            printTreeMidOrder(root.rChild);
        }

    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print("数组：");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        TreeNode root;
        root = arraytotree(arr, 0, arr.length - 1);

        System.out.print("转换成树的中序遍历为：");
        printTreeMidOrder(root);
    }


}
