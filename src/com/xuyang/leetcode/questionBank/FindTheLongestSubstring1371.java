package com.xuyang.leetcode.questionBank;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Li Xuyang
 * @date 2020/5/20 13:15
 * 每个元音包含偶数次的最长子字符串
 */
public class FindTheLongestSubstring1371 {

    //给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，
    // 即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
    //^按位异或
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        FindTheLongestSubstring1371 findTheLongestSubstring1371 = new FindTheLongestSubstring1371();
        int res = findTheLongestSubstring1371.findTheLongestSubstring(s);
        System.out.println(res);
    }
}
