package com.xuyang.leetcode.offer2;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


/**
 * @author Li Xuyang
 * @date 2020/8/3 22:52
 * 剑指 Offer 38. 字符串的排列
 */
public class Permutation38 {
    //回溯法
    //输入一个字符串，打印出该字符串中字符的所有排列。
    //你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
    List<String> res = new LinkedList<>();
    char[] c ;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);

        return res.toArray(new String[res.size()]);

    }

    private void dfs(int x) {
        //递归终止
        if (x == c.length-1){
            res.add(String.valueOf(c));//添加排序方案
            return;
        }
        HashSet<Character>set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])){//重复，因此剪枝
                continue;
            }

            set.add(c[i]);
            // 交换，将 c[i] 固定在第 x 位
            swap(i,x);
            // 开启固定第 x + 1 位字符
            dfs(x+1);
            // 恢复交换
            swap(i,x);
        }

    }

    private void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;

    }

    public static void main(String[] args) {
        Permutation38 permutation38 = new Permutation38();
        String s = "abc";
        String[] res = permutation38.permutation(s);
        System.out.println(Arrays.toString(res));
    }
}
