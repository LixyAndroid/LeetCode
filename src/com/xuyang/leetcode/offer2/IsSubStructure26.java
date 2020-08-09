package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/9 09:34
 * 剑指 Offer 26. 树的子结构
 */
public class IsSubStructure26 {

    //输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
    //B是A的子结构， 即 A中有出现和B相同的结构和节点值。

    /*
    算法流程：
        名词规定：树 A 的根节点记作 节点 A ，树 B 的根节点称为 节点 B 。

        recur(A, B) 函数：

        终止条件：
        当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true ；
        当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false ；
        当节点 A 和 B 的值不同：说明匹配失败，返回 false ；
        返回值：
        判断 A 和 B 的左子节点是否相等，即 recur(A.left, B.left) ；
        判断 A 和 B 的右子节点是否相等，即 recur(A.right, B.right) ；
        isSubStructure(A, B) 函数：

        特例处理： 当 树 A 为空 或 树 B 为空 时，直接返回 false ；
        返回值： 若树 B 是树 A 的子结构，则必满足以下三种情况之一，因此用或 || 连接；
        以 节点 A 为根节点的子树 包含树 B ，对应 recur(A, B)；
        树 B 是 树 A 左子树 的子结构，对应 isSubStructure(A.left, B)；
        树 B 是 树 A 右子树 的子结构，对应 isSubStructure(A.right, B)；
        以上 2. 3. 实质上是在对树 A 做 先序遍历 。

     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    //比较每个结点
    private boolean recur(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }

        return recur(a.left, b.left) && recur(a.right, b.right);

    }
}
