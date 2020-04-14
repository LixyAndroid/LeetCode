package com.xuyang.leetcode.offer;

import java.util.ArrayList;

/**
 * @author Li Xuyang
 * @date 2020/3/20 10:00
 * 二叉树中和为某一值的路径
 */
public class FindPath24 {


    /*
    输入一颗二叉树的根节点和一个整数，
    打印出二叉树中结点值的和为输入整数的所有路径。
    路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    (注意: 在返回值的list中，数组长度大的数组靠前)
     */

    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        list.add(root.val);
        target -= root.val;

        //这个条件很不错哦
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(list));
        }

        //因为在每一次的递归中，我们使用的是相同的result引用，所以其实左右子树递归得到的结果我们不需要关心，
        //可以简写为FindPath(root.left, target)；FindPath(root.right, target)；
        //但是为了大家能够看清楚递归的真相，此处我还是把递归的形式给大家展现了出来。
        ArrayList<ArrayList<Integer>> result1 = findPath(root.left, target);
        ArrayList<ArrayList<Integer>> result2 = findPath(root.right, target);
        list.remove(list.size() - 1);
        return result;
    }


    public static void main(String[] args) {
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        TreeNode root = new TreeNode(0);
        root.val = 10;
        root.left = new TreeNode(0);
        root.left.val = 5;
        root.left.left = new TreeNode(0);
        root.left.left.val = 4;
        root.left.right = new TreeNode(0);
        root.left.right.val = 7;
        root.right = new TreeNode(0);
        root.right.val = 12;


        FindPath24 findPath23 = new FindPath24();
        // 有两条路径上的结点和为22
        System.out.println("findPath(root, 22);");
        ArrayList<ArrayList<Integer>> result1 = findPath23.findPath(root, 22);
        System.out.println(result1);
        result1.clear();

        // 没有路径上的结点和为15
        System.out.println("findPath(root, 15);");
        ArrayList<ArrayList<Integer>> result12 = findPath23.findPath(root, 15);
        System.out.println(result12);
        result12.clear();

        // 有一条路径上的结点和为19
        System.out.println("findPath(root, 19);");
        ArrayList<ArrayList<Integer>> result2 = findPath23.findPath(root, 19);
        System.out.println(result2);
        result2.clear();

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        TreeNode root2 = new TreeNode(0);
        root2.val = 5;
        root2.left = new TreeNode(0);
        root2.left.val = 4;
        root2.left.left = new TreeNode(0);
        root2.left.left.val = 3;
        root2.left.left.left = new TreeNode(0);
        root2.left.left.left.val = 2;
        root2.left.left.left.left = new TreeNode(0);
        root2.left.left.left.left.val = 1;

        // 有一条路径上面的结点和为15
        System.out.println("findPath(root2, 15);");
        ArrayList<ArrayList<Integer>> result3 = findPath23.findPath(root2, 15);
        System.out.println(result3);
        result3.clear();
        // 没有路径上面的结点和为16
        System.out.println("findPath(root2, 16);");
        ArrayList<ArrayList<Integer>> result4 = findPath23.findPath(root2, 16);
        System.out.println(result4);
        result4.clear();

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        TreeNode root3 = new TreeNode(0);
        root3.val = 1;
        root3.right = new TreeNode(0);
        root3.right.val = 2;
        root3.right.right = new TreeNode(0);
        root3.right.right.val = 3;
        root3.right.right.right = new TreeNode(0);
        root3.right.right.right.val = 4;
        root3.right.right.right.right = new TreeNode(0);
        root3.right.right.right.right.val = 5;

        // 有一条路径上面的结点和为15
        System.out.println("findPath(root3, 15);");
        ArrayList<ArrayList<Integer>> result5 = findPath23.findPath(root3, 15);
        System.out.println(result5);
        result5.clear();
        // 没有路径上面的结点和为16
        System.out.println("findPath(root3, 16);");
        ArrayList<ArrayList<Integer>> result6 = findPath23.findPath(root, 16);
        System.out.println(result6);
        result6.clear();
        // 树中只有1个结点
        TreeNode root4 = new TreeNode(0);

        root4.val = 1;
        // 有一条路径上面的结点和为1
        System.out.println("findPath(root4, 1);");
        ArrayList<ArrayList<Integer>> result7 = findPath23.findPath(root4, 1);
        System.out.println(result7);
        result7.clear();
        // 没有路径上面的结点和为2
        System.out.println("findPath(root4, 2);");
        ArrayList<ArrayList<Integer>> result8 = findPath23.findPath(root4, 2);
        System.out.println(result8);
        result8.clear();
        // 树中没有结点
        System.out.println("findPath(null, 0);");
        ArrayList<ArrayList<Integer>> result9 = findPath23.findPath(null, 0);
        System.out.println(result9);
        result9.clear();
    }
}
