package com.xuyang.leetcode.offer2;


import java.util.Stack;

/**
 * @author Li Xuyang
 * @date 2020/8/1 14:50
 * 剑指 Offer 31. 栈的压入、弹出序列
 */
public class ValidateStackSequences31 {
    //输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
    // 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            //这样看是不是可以出栈
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        //这样看是不是全部可以弹出来，若全部可以弹出来，则说明符合条件，否则不是
        return stack.isEmpty();
    }
}
