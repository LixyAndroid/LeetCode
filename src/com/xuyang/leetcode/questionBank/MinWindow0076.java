package com.xuyang.leetcode.questionBank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Li Xuyang
 * @date 2020/5/24 16:57
 * 最小覆盖子串
 */
public class MinWindow0076 {

    //给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
    /*
    本问题要求我们返回字符串 s 中包含字符串 t 的全部字符的最小窗口。
    我们称包含 t 的全部字母的窗口为「可行」窗口。

我们可以用滑动窗口的思想解决这个问题，在滑动窗口类型的问题中都会有两个指针。
一个用于「延伸」现有窗口的 r 指针，和一个用于「收缩」窗口的 l 指针。在任意时刻，只有一个指针运动，而另一个保持静止。
我们在 s 上滑动窗口，通过移动 r 指针不断扩张窗口。当窗口包含 t 全部所需的字符后，如果能收缩，我们就收缩窗口直到得到最小窗口。

     */

    //我们可以用滑动窗口的思想解决这个问题
    Map<Character,Integer> ori = new HashMap<>();
    Map<Character,Integer> cnt = new HashMap<>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            //getOrDefault就是当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
            ori.put(c,ori.getOrDefault(c,0)+1);
        }
        int l = 0,r=-1;
        //ansL左指针，ansR右指针
        int len =Integer.MAX_VALUE,ansL=-1,ansR=-1;
        int sLen =s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL==-1?"":s.substring(ansL,ansR);

    }

    //是否包括
    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC", T = "ABC";
        MinWindow0076 minWindow0076 = new MinWindow0076();
        String string = minWindow0076.minWindow(S,T);
        System.out.println(string);
    }

}
