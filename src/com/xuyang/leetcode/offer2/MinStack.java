package com.xuyang.leetcode.offer2;


import java.util.Stack;

/**
 * @author Li Xuyang
 * @date 2020/8/16 16:20
 * 剑指 Offer 30. 包含min函数的栈
 */
public class MinStack {
    //定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
    /**
     * initialize your data structure here.
     */

    Stack<Integer> minStack;
    Stack<Integer> helperStack;

    public MinStack() {
        minStack = new Stack<>();
        helperStack = new Stack<>();

    }

    public void push(int x) {
        minStack.push(x);
        if (helperStack.isEmpty() || x <= helperStack.peek()) {
            helperStack.push(x);
        }
    }

    public void pop() {
        if (minStack.pop().equals(helperStack.peek())) {
            helperStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
    }

    //只是拿到最小值，但部弹出栈
    public int min() {
        return helperStack.peek();
    }
}
