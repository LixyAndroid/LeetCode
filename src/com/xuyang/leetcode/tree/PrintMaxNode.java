package com.xuyang.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Li Xuyang
 * date  2019/7/26 17:15
 *   题目描述 输出二叉树中每层的最大节点。
 *
 *                                             3
 *
 *                             4                                7
 *
 *              2                        1            9                    10
 *
 *
 */
public class PrintMaxNode {
    /**
     * 节点的信息
     */
    class Node{
        Node left;
        Node right;
        int val;
        public Node(int val){
            this.val=val;
        }
    }

    /**
     * 初始化二叉树，也就是上文中的二叉树
     * @return
     */
    public Node init(){
        Node head,p,p1,p2;
        p=new Node(3);
        head=p;
        p1=new Node(4);
        p.left=p1;
        p1=new Node(7);
        p.right=p1;
        p1=p.left;
        p2=new Node(2);
        p1.left=p2;
        p2=new Node(1);
        p1.right=p2;
        p1=p.right;
        p2=new Node(9);
        p1.left=p2;
        p2=new Node(10);
        p1.right=p2;
        return head;
    }


    /**
     * 打印每一层最大的节点
     * @param list
     */

    public void print(ArrayList<Node> list){
        Node max=list.get(0);
        for(int i=1;i<list.size();i++){
            if(max.val<list.get(i).val){
                max=list.get(i);
            }
        }
        System.out.println(max.val);
    }

    public static void main(String[] args){

        PrintMaxNode printMaxNode=new PrintMaxNode();
        Node head=printMaxNode.init();
        Node p=head;
        Queue<Node> queue= new LinkedList<Node>();  //队列，用于层次遍历
        ArrayList<Node> list=new ArrayList<Node>(); //用于存放每一层中的节点
        int k=0;//当前层的个数
        int y=0;//下一层的个数
        queue.offer(p);     //获取队列中第一个节点
        k++;            //当前层的个数加1
        Node p1=queue.poll();   //取出队列中的头一个节点
        while (p1!=null){       //当队列中没有元素时，退出
            k--;                //当前层的节点数减一
            list.add(p1);       //存放进list
            if(p1.left!=null){  //如果节点有做孩子，放进队列，下一层的节点数加一
                queue.offer(p1.left);
                y++;
            }
            if(p1.right!=null){ //同上
                queue.offer(p1.right);
                y++;
            }
            if(k==0){           //如果k=0,也就是说当前层的节点都没有了
                k=y;            //令k等于下一层的节点数
                y=0;            //下一层节点数初始化为0
                printMaxNode.print(list);  //可以打印这一层最大的节点了
                list.clear();       //清空list，可以存放下一层的节点
            }
            p1=queue.poll();    //再取出一个节点，循环上述操作
        }



    }



}
