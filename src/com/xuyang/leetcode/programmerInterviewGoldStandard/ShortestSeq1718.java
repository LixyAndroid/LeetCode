package com.xuyang.leetcode.programmerInterviewGoldStandard;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Li Xuyang
 * @date 2020/8/23 00:12
 * 面试题 17.18. 最短超串
 */
public class ShortestSeq1718 {
    /*
假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
     */
    public int[] shortestSeq(int[] big, int[] small) {
        if (small.length > big.length)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        int count = small.length;
        int[] ans = {0, big.length};

        for (int i : small)
            map.put(i, -1);

        for (int i = 0; i < big.length; i++) {
            if (map.containsKey(big[i])) {
                if (map.get(big[i]) == -1)
                    count--;
                map.put(big[i], i);
            }
            if (count <= 0) {
                Collection<Integer> c = map.values();
                Object[] obj = c.toArray();
                int minNum = getMin(obj);
                if (i - minNum + 1 < ans[1] - ans[0] + 1) {
                    ans[0] = minNum;
                    ans[1] = i;
                }
            }
        }
        if (count > 0)
            return new int[0];
        return ans;
    }

    int getMin(Object[] obj) {
        int minNum = Integer.MAX_VALUE;
        for (Object i : obj) {
            minNum = Math.min((int) i, minNum);
        }
        return minNum;
    }
}
