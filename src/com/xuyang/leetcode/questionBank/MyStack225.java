package com.xuyang.leetcode.questionBank;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Li Xuyang
 * @date 2020/8/16 22:54
 *  用队列实现栈
 */
public class MyStack225 {
    /*
    使用队列实现栈的下列操作：

    push(x) -- 元素 x 入栈
    pop() -- 移除栈顶元素
    top() -- 获取栈顶元素
    empty() -- 返回栈是否为空
    注意:

    你只能使用队列的基本操作-- 也就是push to back, peek/pop from front, size, 和is empty这些操作是合法的。
    你所使用的语言也许不支持队列。你可以使用 list 或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
    你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。

     */
    /** Initialize your data structure here. */
    Deque<Integer> deque;

    public MyStack225() {
        deque = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int pop =  deque.getLast();
        deque.removeLast();
        return pop;
    }

    /** Get the top element. */
    public int top() {
        return deque.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }


    int[] data;
    int maxSize;
    int top;

    public void Stack(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
        top = -1;

    }

    /**
     * 依次加入数据
     *
     * @param data 要加入的数据
     * @return 添加是否成功
     */

    public boolean push2(int data) {
        if (top + 1 == maxSize) {
            System.out.println("栈已满！");
            return false;

        }
        //添加
        this.data[++top] = data;
        return true;

    }

    /**
     * 从栈中取出数据
     * @return
     * @throws Exception
     */

    public int pop2() throws Exception {

        if (top == -1) {
            throw new Exception("栈已空！");
        }

        return this.data[top--];

    }




}
