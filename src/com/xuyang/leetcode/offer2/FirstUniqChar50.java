package com.xuyang.leetcode.offer2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Li Xuyang
 * @date 2020/7/26 18:34
 * 第一个只出现一次的字符
 */
public class FirstUniqChar50 {
    //在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //get多次，耗时
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        char res = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                res = s.charAt(i);
                break;
            }
        }
        return res;
    }

    //哈希表
    public char firstUniqChar2(String s) {
        Map<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for (char c : sc) {//这里是有序的，所以拿到的就是第一个
            if (dic.get(c)) return c;
        }

        return ' ';
    }

    //有序哈希表
    public char firstUniqChar3(String s) {
        //慢，这里用LinkedHashMap，保证有序性，速度慢
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
            if (d.getValue()) {
                return d.getKey();
            }
        }
        return ' ';
    }


    public static void main(String[] args) {
        FirstUniqChar50 firstUniqChar50 = new FirstUniqChar50();
        String s = "leetcode";
        String s2 = "";
        char c = firstUniqChar50.firstUniqChar3(s);
        System.out.println(c);
    }
}
