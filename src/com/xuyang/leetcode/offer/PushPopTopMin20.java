package com.xuyang.leetcode.offer;

import java.util.Stack;

/**
 * @author Li Xuyang
 * @date 2020/4/14 18:12
 *
 */
public class PushPopTopMin20 {

    /*
    定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。

     */

    Stack<Integer> stackTotal = new Stack<Integer>();
    Stack<Integer> stackLittle = new Stack<Integer>();
    public void push(int node) {
        stackTotal.push(node);
        if(stackLittle.empty()){
            stackLittle.push(node);
        }else{
            if(node<=stackLittle.peek()){
                stackLittle.push(node);
            }else{
                stackLittle.push(stackLittle.peek());
            }
        }

    }

    public void pop() {
        stackTotal.pop();
        stackLittle.pop();
    }

    public int top() {
        return stackTotal.peek();
    }

    public int min() {
        return stackLittle.peek();
    }

}
