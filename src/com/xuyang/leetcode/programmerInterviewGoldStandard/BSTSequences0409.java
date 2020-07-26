package com.xuyang.leetcode.programmerInterviewGoldStandard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/7/26 23:38
 * 面试题 04.09. 二叉搜索树序列
 */
public class BSTSequences0409 {
    //从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。
    // 给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。

    /*
    二叉搜索树中序遍历是有序的，左中右


        能够生成同一二叉树的所有不同序列————这一题乍一看就是全排列问题，而全排列的套路无外乎递归三板斧：

        //定义好结果集
        List<...> res = ...
        void dfs(int level,...){
            //1.设定终止条件
            if(level达到遍历的最高层数) ....return;

            //2.对当前层数能够访问的元素进行遍历
            for(){
                ...
                //3.1 最关键的一步，设定访问标记，防止重复访问
                dfs(level+1,访问标记数组);
                //3.2 擦除访问标记
            }

        }

        再回到该题，我们会发现和一般的全排列是有一些区别的————加了一些额外的限定条件，即任一节点root的子节点必须再该节点之后访问，比如：


    2
   / \
  1   3
       \
        4
显然树中的节点满足了偏序关系（自反，传递，反对称），1和3因为与2相连，所以(1,3)必须在2后面，同理4和3相连所以4必须放在3后面，同时4与2具有传递性，因此4也必须在22后面。而4与1无直接或传递关系，所以可以乱序。

搞明白这一点，我们只需要将下一层能够遍历的元素找出即可。比如我们当前遍历到了4-3的位置，那下一层能遍历的节点只有两类：和当前节点无偏序关系的兄弟节点(1)以及一定排在当前节点后面的子节点(4)，那么下一层能够遍历的就为（1，4）。而具体的概括就是

同一层能够遍历的元素curSet是不存在依赖关系的
从curSet中的root出发，下一层的能够遍历的节点为curSet-{root}+{root.left,root.right}。

     */

    List<List<Integer>> reses = new LinkedList<>();
    LinkedList<Integer> res = new LinkedList<>();

    //超时间，超内存
    public List<List<Integer>> BSTSequences(TreeNode root) {

        if (root == null) {
            reses.add(res);
            return reses;
        }
        HashSet<TreeNode> curLevel = new HashSet<>();
        curLevel.add(root);
        dfs(curLevel);
        return reses;
    }

    private void dfs(HashSet<TreeNode> curLevel) {
        //当前集合没有需要遍历的元素，说明遍历到底
        if (curLevel.size() == 0) {
            reses.add(new LinkedList<>(res));
            return;
        }
        HashSet<TreeNode> nextLevel = new HashSet<>(curLevel);
        for (TreeNode t : curLevel) {
            res.add(t.val);
            //出了当前结点，其余结点下一层都可以遍历
            if (t.left != null) {
                nextLevel.add(t.left);
            }
            if (t.right != null) {
                nextLevel.add(t.right);
            }
            dfs(nextLevel);
            if (t.left != null) {
                nextLevel.remove(t.left);
            }
            if (t.right != null) {
                nextLevel.remove(t.right);
            }
            nextLevel.add(t);
            res.removeLast();
        }
    }

    public List<List<Integer>> BSTSequences2(TreeNode root) {
        if (root == null) {
            List<List<Integer>> empty = new ArrayList<>();
            empty.add(new ArrayList<>());
            return empty;
        }
        List<List<Integer>> listl = BSTSequences(root.left);
        List<List<Integer>> listr = BSTSequences(root.right);
        List<List<Integer>> merge;
        //特殊情况不用merge减少递归次数
        if ((listl.size() == 1 && listl.get(0).size() == 0) || (listr.size() == 1 && listr.get(0).size() == 0)) {
            merge = listl.get(0).size() == 0 ? listr : listl;
        } else merge = merge(listl, listr);
        for (List<Integer> list : merge) {
            list.add(0, root.val);
        }
        return merge;
    }

    public List<List<Integer>> merge(List<List<Integer>> leftList, List<List<Integer>> rightList) {
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list : leftList) {
            for (List<Integer> integers : rightList) {
                res.addAll(relativeMerge(list, integers, 0));
            }
        }
        return res;
    }

    //回溯进行相对排序。
    public List<List<Integer>> relativeMerge(List<Integer> listl, List<Integer> listr, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (listr.size() == 0) {
            res.add(listl);
            return res;
        }
        int lenl = listl.size();
        //一个长度为lenl的list首尾都可以插入，所以可以插入的点实际上是lenl+1
        for (int j = start; j <= lenl; j++) {
            listl.add(j, listr.get(0));
            Integer remove = listr.remove(0);
            res.addAll(relativeMerge(new ArrayList<>(listl), new ArrayList<>(listr), j + 1));
            listl.remove(j);
            listr.add(0, remove);
        }
        return res;
    }
}
