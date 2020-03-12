package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/12 11:03
 * 二叉树的镜像
 */
public class Mirror18 {

    //操作给定的二叉树，将其变换为源二叉树的镜像。
    /*
    输入描述:
        二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
     */

    public  static  void mirror(TreeNode root){


        //递归返回的条件
        if (root == null  || (root.left == null && root.right == null)){
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;

        mirror(left);
        mirror(right);

    }

    public static void printTree(TreeNode node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.val + " ");
            printTree(node.right);
        }
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
        printTree(root);
        System.out.println();
        mirror(root);
        printTree(root);
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
        System.out.println("\n");
        printTree(root2);
        System.out.println();
        mirror(root2);
        printTree(root2);

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
        System.out.println("\n");
        printTree(root3);
        System.out.println();
        mirror(root3);
        printTree(root3);


    }


}
