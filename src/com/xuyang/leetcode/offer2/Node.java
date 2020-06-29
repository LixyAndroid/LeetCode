package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/6/29 22:40
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
