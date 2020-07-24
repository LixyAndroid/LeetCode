package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/7/24 21:48
 * 除数博弈
 */
public class DivisorGame1025 {

    /*
    爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
    最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
    选出任一 x，满足 0 < x < N 且 N % x == 0 。
    用 N - x 替换黑板上的数字 N 。
    如果玩家无法执行这些操作，就会输掉游戏。

    只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
     */
    //方法一：找规律
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    //递推
    public boolean divisorGame2(int N) {
        boolean[] f = new boolean[N + 5];
        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= N; ++i) {
            for (int j = 1; j < i; ++j) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[N];
    }
}
