package com.xuyang.leetcode.longestpalindrome;


/**
 * @author Mloong
 * date  2019/7/19 11:35
 * 最长回文子串
 * 复习：Scanner sc = new Scanner(System.in);
 * System.out.println("请输入你的姓名：");
 * String name = sc.nextLine();  但此处不用，直接传递然后返回
 *
 * 回文是一个正读和反读都相同的字符串，例如，\textrm{“aba”}“aba” 是回文，而 \textrm{“abc”}“abc” 不是。
 * 寻找最长回文串的思路都是找到最长的区间，substring方法可以求出从起始索引到终止索引区间的字符串
 */
public class Solution {



    /*


            中心扩展算法
    事实上，只需使用恒定的空间，我们就可以在 O(n^2)的时间内解决这个问题。

    我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 12n−1 个这样的中心。

    你可能会问，为什么会是 2n - 12n−1 个，而不是 nn 个中心？
    原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如 \textrm{“abba”}“abba” 的中心在两个 \textrm{‘b’}‘b’ 之间）。


     */

//    public static String longestPalindrome(String s) {
//
//        if (s == null || s.length() < 1) return "";
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            //取最长的
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//
//        //一个参数时，返回一个新字符串，它是此字符串的一个子字符串。该子字符串始于指定索引处的字符，一直到此字符串末尾。
//        //substring方法，为返回一个新字符串，它是此字符串的一个子字符串。该子字符串从指定的 beginIndex 处开始， endIndex:到指定的 endIndex-1处结束。
//        return s.substring(start, end + 1);
//
//    }
//
//    private static int expandAroundCenter(String s, int left, int right) {
//        int L = left, R = right;
//        //判断左侧索引大于0，而右侧小于字符串长度的并且左侧字符等于右侧字符
//        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//            L--;
//            R++;
//        }
//        //返回字符串的长度，以便比较最长的
//        return R - L - 1;
//    }


//    // 暴力解法  太暴力 时间复杂度时间复杂度：两层 for 循环 O(n²），for 循环里边判断是否为回文 O(n），所以时间复杂度为 O(n³）。
//    public static String longestPalindrome(String s) {
//        String ans = "";
//        int max = 0;
//        int len = s.length();
//        for (int i = 0; i < len; i++)
//            for (int j = i + 1; j <= len; j++) {
//                String test = s.substring(i, j);
//                //若回文，且长度大于当前最长的，则替换
//                if (isPalindromic(test) && test.length() > max) {
//                    ans = s.substring(i, j);
//                    max = Math.max(max, ans.length());
//                }
//            }
//        return ans;
//    }
//
//    //判断是否回文
//    private static boolean isPalindromic(String s) {
//        int len = s.length();
//        for (int i = 0; i < len / 2; i++) {
//            if (s.charAt(i) != s.charAt(len - i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }




    /*

    最长公共子串 优化版
     */


    private static String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        String origin = s;

        //字符串倒置
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[] arr = new int[length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
            for (int j = length - 1; j >= 0; j--) {
                /**************************************************/
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
                /**************************************************/
                if (arr[j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[j] - 1 == i) {
                        maxLen = arr[j];
                        maxEnd = i;
                    }

                }
            }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }


    public static void main(String[] args) {
        String s = "abcbacdabacabadeacdac";
        String result = longestPalindrome(s);

        System.out.println(result);

    }


}
