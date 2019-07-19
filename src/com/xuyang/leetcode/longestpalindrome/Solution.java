package com.xuyang.leetcode.longestpalindrome;



/**
 * @author Mloong
 * date  2019/7/19 11:35
 *          最长回文子串
 *          复习：Scanner sc = new Scanner(System.in);
 *              System.out.println("请输入你的姓名：");
 *               String name = sc.nextLine();  但此处不用，直接传递然后返回
 *
 *    回文是一个正读和反读都相同的字符串，例如，\textrm{“aba”}“aba” 是回文，而 \textrm{“abc”}“abc” 不是。
 */
public class Solution {



    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            //取最长的
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        //一个参数时，返回一个新字符串，它是此字符串的一个子字符串。该子字符串始于指定索引处的字符，一直到此字符串末尾。
        //substring方法，为返回一个新字符串，它是此字符串的一个子字符串。该子字符串从指定的 beginIndex 处开始， endIndex:到指定的 endIndex-1处结束。
        return s.substring(start, end + 1);

    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        //判断左侧索引大于0，而右侧小于字符串长度的并且左侧字符等于右侧字符
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        //返回字符串的长度，以便比较最长的
        return R - L - 1;
    }

    public static void main(String[] args) {
        String s = "abcbacdabacabadeacdac";
        String result = longestPalindrome(s);

        System.out.println(result);

    }



}
