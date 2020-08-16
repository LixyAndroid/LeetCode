package com.xuyang.leetcode.offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li Xuyang
 * @date 2020/8/16 17:23
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 */
public class LengthOfLongestSubstring46 {
    //请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> dic = new HashMap<>();
        int res = 0;
        int tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1);//获取索引
            dic.put(s.charAt(j), j);//更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])

        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while (i >= 0 && s.charAt(i) != s.charAt(j)) i--; // 线性查找 i
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "aab";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);

    }
}
