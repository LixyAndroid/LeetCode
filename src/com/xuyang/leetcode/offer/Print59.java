package com.xuyang.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Li Xuyang
 * @date 2020/4/11 15:44
 * 按之字形顺序打印二叉树
 */
public class Print59 {

    /*
    主要的方法与BFS写法没什么区别
    BFS里是每次只取一个，而我们这里先得到队列长度size，这个size就是这一层的节点个数，
    然后通过for循环去poll出这size个节点，这里和按行取值二叉树返回ArrayList<ArrayList<Integer>>这种题型的解法一样，之字形取值的核心思路就是通过两个方法：
    list.add(T): 按照索引顺序从小到大依次添加
    list.add(index, T): 将元素插入index位置，index索引后的元素依次后移,这就完成了每一行元素的倒序，或者使用Collection.reverse()方法倒序也可以
     */
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        LinkedList<TreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean rev = true;
        q.add(pRoot);
        while (!q.isEmpty()){

            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node==null){
                    continue;
                }
                if (rev){
                    list.add(node.val);
                }else {
                    //在0的位置加node.val，原先的元素后移
                    list.add(0,node.val);
                }
                //和add方法差不多。但是
                // offer属于 offer in interface Deque<E>，add 属于 add in interface Collection<E>。
                //   当队列为空时候，使用add方法会报错，而offer方法会返回false。
                //   作为List使用时,一般采用add / get方法来 压入/获取对象。
                //   作为Queue使用时,才会采用 offer/poll/take等方法作为链表对象时,offer等方法相对来说没有什么意义这些方法是用于支持队列应用的。
               // 当队列为空时候，使用add方法会报错，而offer方法会返回false。
                q.offer(node.left);
                q.offer(node.right);
            }
            if (list.size()!=0){
                res.add(list);
            }
            rev = !rev;

        }

        return res;

    }
}
