package com.xuyang.leetcode.questionBank;

import java.util.LinkedList;

/**
 * @author Li Xuyang
 * @date 2020/8/26 17:48
 * 跳跃游戏 III
 */
public class CanReach1306 {
    //这里有一个非负整数数组arr，你最开始位于该数组的起始下标start处。当你位于下标i处时，你可以跳到i + arr[i] 或者 i - arr[i]。
    //
    //请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
    //
    //注意，不管是什么情况下，你都无法跳到数组之外。
    /*
    方法2：BFS
        准备一个bool类型的数组visited表示当前的下标有无被访问过
        准备一个queue，转这个queue
            取到这一轮的总的size大小，进行for loop
            弹出当前的curPos,如果arr[curPos]== 0说明找到了，返回true
            分别渠道左右两边去找，curPos的位置不越界并且leftPos和rightPos未被访问过
            访问后要设置下visited的属性，并且将位置放置于queue中
     */
    public boolean canReach(int[] arr, int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        int n = arr.length;
        boolean[] visited = new boolean[n];
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curPos = queue.removeFirst();
                int curValue = arr[curPos];
                if (curValue == 0) {
                    return true;
                }
                int leftPos = curPos - curValue;
                if (leftPos >= 0 && !visited[leftPos]) {
                    visited[leftPos] = true;
                    queue.addFirst(leftPos);
                }
                int rightPos = curPos + curValue;
                if (rightPos < n && !visited[rightPos]) {
                    visited[rightPos] = true;
                    queue.addFirst(rightPos);
                }

            }

        }
        return false;

    }
}
