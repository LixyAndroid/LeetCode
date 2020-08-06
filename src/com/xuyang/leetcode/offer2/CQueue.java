package com.xuyang.leetcode.offer2;


import java.util.Stack;

/**
 * @author Li Xuyang
 * @date 2020/8/6 21:17
 * 剑指 Offer 09. 用两个栈实现队列
 */
public class CQueue {
    //用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
    // 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
    //1,stackIn只负责进入
    //2,stackOut只负责取出
    //3,只有stackOut为空时才把stackIn的所有元素倾倒进stackOut中，这样顺序就不会乱了
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;


    public CQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        if (stackOut.isEmpty()) { //当栈Out为空当时候再去push
            while (!stackIn.isEmpty()) {
                //这么加就是有序，若是不判空，继续加就乱了顺序，所以只能在stackOut的时候再去push
                stackOut.push(stackIn.pop());
            }
        }
        if (stackOut.isEmpty()) {
            return -1;
        } else {
            return stackOut.pop();
        }
    }
}
