package com.xuyang.leetcode.offer2;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Li Xuyang
 * @date 2020/7/28 22:52
 * 剑指 Offer 27. 二叉树的镜像
 */
public class MirrorTree27 {
    /*
    这个问题是受到 Max Howell 的 原问题 启发的 ：

谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
     */

    /*
    递归解析：
终止条件： 当节点 root 为空时（即越过叶节点），则返回 null ；
递推工作：
初始化节点 tmp ，用于暂存 root 的左子节点；
开启递归 右子节点 mirrorTree(root.right)，并将返回值作为 root 的 左子节点 。
开启递归 左子节点 mirrorTree(tmp) ，并将返回值作为 root 的 右子节点。
返回值： 返回当前节点 root ；
Q： 为何需要暂存 root 的左子节点？
A： 在递归右子节点 “root.left = mirrorTree(root.right);root.left=mirrorTree(root.right);” 执行完毕后，
 root.leftroot.left 的值已经发生改变，此时递归左子节点 mirrorTree(root.left)mirrorTree(root.left) 则会出问题。

     */
    //递归的神奇
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    /*
    方法二：辅助栈（或队列）
    利用栈（或队列）遍历树的所有节点 node，并交换每个node 的左 / 右子节点。
    算法流程：
    特例处理： 当 root 为空时，直接返回 null ；
    初始化： 栈（或队列），本文用栈，并加入根节点 root 。
    循环交换： 当栈 stack 为空时跳出；
    出栈： 记为 node ；
    添加子节点： 将 node 左和右子节点入栈；
    交换： 交换 node 的左 / 右子节点。
    返回值： 返回根节点 root 。
     */

    public TreeNode mirrorTree2(TreeNode root) {

        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>() {{
            add(root);
        }};
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

        }

        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }



}
