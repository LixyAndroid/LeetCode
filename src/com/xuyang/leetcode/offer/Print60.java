package com.xuyang.leetcode.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author Li Xuyang
 * @date 2020/4/11 16:06
 * 把二叉树打印成多行
 */
public class Print60 {

    //从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

    /*


    层序遍历的模板是用一个队列，入队每次遇到的非空结点，出队当前最前结点，直到队列为空，遍历完成
    现在为了保存层数信息，我们添加了map，每次入队新的结点，map 保存 <结点,层数> 的 <K,V> 对
    关于相同层数如何入 lists，前面也讨论这就不赘述了
     */

    ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();

        if (pRoot == null) {
            return lists;
        }
        /*
        ArrayDeque是Deque接口的一个实现，使用了可变数组，所以没有容量上的限制。
        同时，ArrayDeque是线程不安全的，在没有外部同步的情况下，不能再多线程环境下使用。
         ArrayDeque是Deque的实现类，可以作为栈来使用，效率高于Stack；
        也可以作为队列来使用，效率高于LinkedList。
         需要注意的是，ArrayDeque不支持null值。
         */
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(pRoot);
        map.put(pRoot, 0);
        while (!queue.isEmpty()) {
            pRoot = queue.pollLast();
            int deep = map.get(pRoot);
            if (pRoot.left != null) {
                queue.addFirst(pRoot.left);
                map.put(pRoot.left, deep + 1);
            }

            if (pRoot.right != null) {
                queue.addFirst(pRoot.right);
                map.put(pRoot.right, deep + 1);
            }

            if (lists.size() <= deep) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(pRoot.val);
                lists.add(list);
            } else {
                ArrayList<Integer> list = lists.get(deep);
                list.add(pRoot.val);
            }
        }
        return lists;
    }

}
