package com.xuyang.leetcode.questionBank;


import java.util.Stack;

/**
 * @author Li Xuyang
 * @date 2020/5/12 21:30
 * 最小栈
 */
public class MinStack0155 {

    Stack<Integer> stack ;
    Stack<Integer> stackMin;

    /**
     * initialize your data structure here.
     */

    //设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
    //
    //push(x) —— 将元素 x 推入栈中。
    //pop() —— 删除栈顶的元素。
    //top() —— 获取栈顶元素。
    //getMin() —— 检索栈中的最小元素。
    public MinStack0155() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        //stackMin.isEmpty()是栈为空，栈内没有元素
        //stackMin.null是null,什么都没有
        if (stackMin.isEmpty()||stackMin.peek()>=x){
            stackMin.push(x);
        }else {
            stackMin.push(stackMin.peek());
        }


    }

    public void pop() {
        stack.pop();
        stackMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}
