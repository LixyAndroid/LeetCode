package com.xuyang.leetcode.programmerInterviewGoldStandard;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Li Xuyang
 * @date 2020/6/28 21:58
 * 判定字符是否唯一
 */
public class IsUnique0101 {
    //实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
    //使用set
    public boolean isUnique(String astr) {
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            if (!characters.add(astr.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsUnique0101 isUnique0101 = new IsUnique0101();
        boolean res = isUnique0101.isUnique("leetcode");
        System.out.println(res);
    }

}
