package com.xuyang.leetcode.offer;

import java.util.Stack;

/**
 * @author Li Xuyang
 * date  2019/9/7 16:12
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 * 思路：栈是先进后出，队列是先进先出
 * 一个stack1占用来接收正常的压栈，一个stack2用来存放stack1的倒序，当执行pop()操作时，弹出的是stack2的栈顶元素，就会有“先进先出的效果”。
 */
public class PushPop05 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    //入栈函数
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
    //将栈1中的内容存入栈2，可以发现内容顺序反了过来
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }


        int out = stack2.pop();

        //再存回栈1，恢复原来的状态,这部很关键
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }

        return out;
    }


    public static void main(String[] args) {


        PushPop05 pushPop05 = new PushPop05();
        pushPop05.push(1);
        pushPop05.push(2);
        pushPop05.push(3);
        pushPop05.push(4);
        pushPop05.push(5);

        for (int i = 0; i < 5; i++) {

            System.out.println(pushPop05.pop());
        }



    }

}
