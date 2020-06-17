package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/6/17 22:04
 * 最佳观光组合
 */
public class MaxScoreSightseeingPair1014 {

    /*
    给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。

一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。

返回一对观光景点能取得的最高分。
     */
    public int maxScoreSightseeingPair(int[] A) {

        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = A.length - 1; j > 0; j--) {

                if (i - j < 0) {
                    ans = Math.max(ans, A[i] + A[j] + (i - j));
                }
            }

        }
        return ans;

    }

    /*
    我们回过头来看得分公式，我们可以将其拆分成 A[i]+iA[i]+i 和 A[j]-jA[j]−j 两部分，这样对于统计景点 jj 答案的时候，
    由于 A[j]-j 是固定不变的，因此最大化 A[i]+i+A[j]-j的值其实就等价于求 [0,j-1]中 A[i]+iA 的最大值 mx，景点 j 的答案即为 mx+A[j]-j。
    而 mx 的值我们只要从前往后枚举 j 的时候同时维护即可，这样每次枚举景点 j 的时候，
    寻找使得得分最大的 i 就能从 O(n) 降至 O(1) 的时间复杂度，总时间复杂度就能从 O(n^2)降至 O(n)。
     */
    public int maxScoreSightseeingPair2(int[] A) {
        int ans = 0;
        int mx = A[0] + 0;
        for (int j = 1; j < A.length; j++) {
            ans = Math.max(ans, mx + A[j] - j);
            //遍历边维护
            mx = Math.max(mx, A[j] + j);

        }

        return ans;

    }

    public static void main(String[] args) {
        int[] A = {7, 8, 8, 10};
        MaxScoreSightseeingPair1014 maxScoreSightseeingPair1014 = new MaxScoreSightseeingPair1014();
        int res = maxScoreSightseeingPair1014.maxScoreSightseeingPair2(A);
        System.out.println(res);

    }
}
