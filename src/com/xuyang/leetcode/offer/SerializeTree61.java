package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/4/11 17:45
 * 序列化二叉树
 */
public class SerializeTree61 {
    /*
    请实现两个函数，分别用来序列化和反序列化二叉树
    二叉树的序列化是指：
    把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
    从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
    二叉树的反序列化是指：
    根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
     */

    int index = -1;

    /**
     * 分别遍历左节点和右节点，空使用#代替，节点之间，隔开
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        if (root==null){
            return "#";
        }else {
            return root.val+","+Serialize(root.left)+","+Serialize(root.right);
        }

    }

    TreeNode Deserialize(String str) {
        //将序列化之后的序列用，分隔符转化为数组
        String[] s = str.split(",");
        //索引每次加一
        index++;

        int len = s.length;
        if (index>len){
            return null;
        }

        TreeNode treeNode = null;
        //不是叶子节点 继续走 是叶子节点出递归
        if (!s[index].equals("#")){
            treeNode = new TreeNode(Integer.parseInt(s[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }

        return treeNode;
    }

    public static void main(String[] args) {


        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;

        SerializeTree61 serializeTree = new SerializeTree61();

        String str = serializeTree.Serialize(treeNode1);
        TreeNode treeNode = serializeTree.Deserialize(str);
    }
}
