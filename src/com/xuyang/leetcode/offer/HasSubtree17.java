package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/11 15:13
 */
public class HasSubtree17 {


    //一棵大树 A，一棵小树 B，若 B 是 A 的子树，则：
    //
    // B 和 A 的结点值完全相同，它们俩的左子树、右子树所有结点的值也完全相同
    // 或者 B 的左孩子和 A 的结点值完全相同，它们俩的左子树、右子树所有结点的值也完全相同
    // 或者 B 的右孩子和 A 的结点值完全相同，它们俩的左子树、右子树所有结点的值也完全相同
    //    //子结构就是不用那么严格，图中的小框就是整棵树的子结构，只要有相同的结构树即可
    //    //图中的黄色大框也是整棵树的子结构，所以只要找到符合树的一部分树结点即可

    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null){
            return false;
        }

        return DFS(root1,root2)||hasSubtree(root1.left,root2)||hasSubtree(root1.right,root2);


    }

    public boolean DFS(TreeNode root1,TreeNode root2){
        //root2遍历完了
        if(root2==null){
            return true;
        }
        //root1遍历完还有匹配上
        if(root1 == null){
            return false;
        }

        return root1.val == root2.val&&DFS(root1.left,root2.left)&&DFS(root1.right,root2.right);
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        root1.val = 8;
        root1.right = new TreeNode(0);
        root1.right.val = 7;
        root1.left = new TreeNode(0);
        root1.left.val = 8;
        root1.left.left = new TreeNode(0);
        root1.left.left.val = 9;
        root1.left.right = new TreeNode(0);
        root1.left.right.val = 2;
        root1.left.right.left = new TreeNode(0);
        root1.left.right.left.left = new TreeNode(0);
        root1.left.right.left.left.val = 4;
        root1.left.right.left.right = new TreeNode(0);
        root1.left.right.left.right.val = 7;

        TreeNode root2 = new TreeNode(0);
        root2.val = 8;
        root2.left = new TreeNode(0);
        root2.left.val = 9;
        root2.right = new TreeNode(0);
        root2.right.val = 2;

        HasSubtree17 hasSubtree17 = new HasSubtree17();

        System.out.println(hasSubtree17.hasSubtree(root1, root2));
        System.out.println(hasSubtree17.hasSubtree(root2, root1));
        System.out.println(hasSubtree17.hasSubtree(root1, root1.left));
        System.out.println(hasSubtree17.hasSubtree(root1, null));
        System.out.println(hasSubtree17.hasSubtree(null, root2));
        System.out.println(hasSubtree17.hasSubtree(null, null));
    }



}
