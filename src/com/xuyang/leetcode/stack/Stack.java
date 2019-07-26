package com.xuyang.leetcode.stack;

/**
 * @author Li Xuyang
 * date  2019/7/26 16:49
 * <p>
 * 用java 代码写一个堆栈
 *
 *
 * 栈先入后出
 */
public class Stack {

    int[] data;
    int maxSize;
    int top;

    public Stack(int maxSize) {
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

    public boolean push(int data) {
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

    public int pop() throws Exception {

        if (top == -1) {
            throw new Exception("栈已空！");
        }

        return this.data[top--];

    }

    public static void main(String[] args) throws Exception {
        Stack stack = new Stack(1000);

        stack.push(1);
        stack.push(2);
        while (stack.top >=0){
            System.out.println(stack.pop());
        }

    }


}
