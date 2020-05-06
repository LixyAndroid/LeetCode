package com.xuyang.leetcode.dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Li Xuyang
 * @date 2020/5/6 10:18
 * 最低票价
 */
public class MincostTickets0983 {


    /*
    在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。

火车票有三种不同的销售方式：

一张为期一天的通行证售价为 costs[0] 美元；
一张为期七天的通行证售价为 costs[1] 美元；
一张为期三十天的通行证售价为 costs[2] 美元。
通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。

返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
     */


    /*
    方法一：记忆化搜索（日期变量型）
思路和算法

我们用 dp(i) 来表示从第 i 天开始到一年的结束，我们需要花的钱。考虑到一张通行证可以让我们在「接下来」的若干天进行旅行，所以我们「从后往前」倒着进行动态规划。

对于一年中的任意一天：

如果这一天不是必须出行的日期，那我们可以贪心地选择不买。这是因为如果今天不用出行，那么也不必购买通行证，并且通行证越晚买越好。所以有 dp(i)=dp(i+1)；

如果这一天是必须出行的日期，我们可以选择买 1，7 或 30 天的通行证。若我们购买了 j 天的通行证，那么接下来的 j - 1 天，我们都不再需要购买通行证，只需要考虑第 i + j 天及以后即可。因此，我们有

dp(i)=min{cost(j)+dp(i+j)},j∈{1,7,30}

其中cost(j) 表示 j 天通行证的价格。为什么我们只需要考虑第 i+j 天及以后呢？这里和第一条的贪心思路是一样的，如果我们需要购买通行证，那么一定越晚买越好，在握着一张有效的通行证的时候购买其它的通行证显然是不划算的。

由于我们是倒着进行动态规划的，因此我们可以使用记忆化搜索，减少代码的编写难度。我们使用一个长度为 366 的数组（因为天数是 [1, 365]，而数组的下标是从 0 开始的）存储所有的动态规划结果，这样所有的 dp(i) 只会被计算一次（和普通的动态规划相同），时间复杂度不会增大。

     */
    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;
    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        dayset = new HashSet<>();
        for (int d:days){
            dayset.add(d);
        }
        return  dp(1);
    }

    private int dp(int i) {

        if (i>365){
            return 0;
        }
        if (memo[i]!=null){
            return memo[i];
        }
        if (dayset.contains(i)){
            memo[i] = Math.min(Math.min(dp(i+1)+costs[0],dp(i+7)+costs[1]),dp(i+30)+costs[2]);
        }else {
            memo[i] = dp(i+1);
        }
        return memo[i];


    }



    /*
    记忆化搜索（窗口变量型）
     */
    int[] days2,costs2;
    Integer[] memo2;
    int[] durations = new int[]{1,7,30};
    public int mincostTickets2(int[] days, int[] costs) {

        this.days2 = days;
        this.costs2 =costs;
        memo2 = new Integer[days2.length];
        return dp2(0);
    }

    private int dp2(int i) {
        if (i>=days2.length){
            return 0;
        }
        if (memo2[i]!=null){
            return memo2[i];
        }
        memo2[i] = Integer.MAX_VALUE;
        int j=i;
        for (int k = 0; k < 3; k++) {

            while (j<days2.length&&days2[j]<days2[i]+durations[k]){
                j++;
            }
            memo2[i] = Math.min(memo2[i],dp2(j)+costs2[k]);

        }
        return memo2[i];
    }
}
