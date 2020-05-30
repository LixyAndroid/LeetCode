package com.xuyang.leetcode.questionBank;

import java.util.*;

/**
 * @author Li Xuyang
 * @date 2020/5/30 13:35
 * 柱状图中最大的矩形
 */
public class LargestRectangleArea0084 {

    //给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
    //
    //求在该柱状图中，能够勾勒出来的矩形的最大面积。
    //枚举宽
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;

        //枚举左边界
        for (int left = 0; left < n; left++) {
            int minHeight = Integer.MAX_VALUE;
            //枚举右边界
            for (int right = left; right < n; right++) {
                //  确定高度
                minHeight = Math.min(minHeight, heights[right]);

                //计算面积
                ans = Math.max(ans, (right - left - 1) * minHeight);
            }


        }
        return ans;
    }


    //枚举高
    public int largestRectangleArea2(int[] heights) {

        int n = heights.length;
        int ans = 0;
        for (int mid = 0; mid < n; mid++) {
            //枚举高
            int height = heights[mid];
            int left = mid, right = mid;
            //确定左右边界
            while (left - 1 >= 0 && heights[left - 1] >= height) {
                left--;
            }
            while (right + 1 < n && heights[right + 1] >= height) {
                right++;
            }
            //计算面积,以当前的
            ans = Math.max(ans, (right - left + 1) * height);

        }
        return ans;
    }

    public int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> mono_stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = mono_stack.isEmpty() ? -1 : mono_stack.peek();
            mono_stack.push(i);

        }
        mono_stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = mono_stack.isEmpty() ? n : mono_stack.peek();

            mono_stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }

        return ans;


    }

    /*
    在上述方法中，我们首先从左往右对数组进行遍历，借助单调栈求出了每根柱子的左边界，随后从右往左对数组进行遍历，借助单调栈求出了每根柱子的右边界。那么我们是否可以只遍历一次就求出答案呢？

答案是可以的。在方法一中，我们在对位置 i 进行入栈操作时，确定了它的左边界。从直觉上来说，与之对应的我们在对位置 i 进行出栈操作时可以确定它的右边界！
仔细想一想，这确实是对的。当位置 i 被弹出栈时，说明此时遍历到的位置 i
0的高度小于等于 height[i]，并且在i0与 i 之间没有其他高度小于等于 height[i] 的柱子。这是因为，如果在 i和 i0
​
  之间还有其它位置的高度小于等于 height[i] 的，那么在遍历到那个位置的时候，i 应该已经被弹出栈了。所以位置 i0
  就是位置 i 的右边界。
     */
    public int largestRectangleArea4(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    //栈
    public int largestRectangleArea5(int[] heights) {
        int len = heights.length;
        if (len==0){
            return 0;
        }

        if (len==1){
            return heights[0];
        }

        int area =0;
        int[] newHeights = new int[len+2];
        for (int i = 0; i < len; i++) {
            newHeights[i+1] = heights[i];
        }
        len+=2;
        heights=newHeights;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(0);
        for (int i = 1; i < len; i++) {
            while (heights[stack.peekLast()]>heights[i]){
                int height = heights[stack.removeLast()];
                int width = i - stack.peekLast()-1;
                area = Math.max(area,width*height);
            }
            stack.addLast(i);
        }
        return area;
    }
}
