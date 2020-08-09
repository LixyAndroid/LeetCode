package com.xuyang.leetcode.offer2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/8/9 12:29
 * 剑指 Offer 37. 序列化二叉树
 */
public class Codec {
    //请实现两个函数，分别用来序列化和反序列化二叉树。
    //前序遍历
    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;

    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));