package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/4/22 17:29
 * 最长回文子串
 */
public class LongestPalindrome0005 {
    /*
    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    示例 1：
    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。

    示例 2：
    输入: "cbbd"
    输出: "bb"
     */
    public String longestPalindrome(String s) {

        if (s.equals("")) {
            return "";
        }
        String origin = s;

        //字符串倒置
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[] arr = new int[length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {

            for (int j = length - 1; j >= 0; j--) {

                if (origin.charAt(i) == reverse.charAt(j)) {

                    if (i == 0 || j == 0) {
                        arr[j] = 1;
                    } else {
                        arr[j] = arr[j - 1] + 1;
                    }

                    //之前二维数组，每次用的是不同的列，所以不用置 0 。
                } else {
                    arr[j] = 0;
                }


                if (arr[j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[j] - 1 == i) {
                        maxLen = arr[j];
                        maxEnd = i;
                    }
                }
            }

        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);

    }


    /*

    方法四：中心扩展算法
事实上，只需使用恒定的空间，我们就可以在 O(n^2) 的时间内解决这个问题。

我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 1 个这样的中心。

你可能会问，为什么会是 2n - 1 个，而不是 n 个中心？
原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如 “abba” 的中心在两个‘b’ 之间）。
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {

            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);

            int len = Math.max(len1,len2);
            if (len>end-start){
                start = i-(len-1)/2;
                end=i+len/2;
            }

        }

        return s.substring(start,end+1);

    }


    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }

        return R - L - 1;

    }
}
