package com.xuyang.leetcode.offer2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Li Xuyang
 * @date 2020/8/15 11:42
 * 剑指 Offer 61. 扑克牌中的顺子
 */
public class IsStraight61 {
    //从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
    // 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
    //排序+遍历
    //最大牌-最小牌小于5的时候，并且在不重复的前提下，构成顺子
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                joker++; //统计大小王数量
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }


        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    public boolean isStraight2(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14; //用于找到最大、最小的牌
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) {
                return false;
            }
            repeat.add(num);

        }
        return max - min < 5;
    }
}
