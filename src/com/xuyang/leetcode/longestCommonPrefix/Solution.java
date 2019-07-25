package com.xuyang.leetcode.longestCommonPrefix;

/**
 * @author Li Xuyang
 * date  2019/7/24 13:54
 * 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 * String类的substring()方法 秒啊！
 */
public class Solution {


//    /**
//     * @param strs
//     * @return
//     * @author Li Xuyang
//     * 可以完美判断3个字符串的最大前缀
//     */
//    public static String longestCommonPrefix(String[] strs) {
//
//
//        if (strs.length == 0) return "";
//
//        List<String> strings = new ArrayList<>();
//
//        int[] len = new int[strs.length];
//
//        for (int i = 0; i < strs.length; i++) {
//
//            len[i] = strs[i].length();
//
//        }
//
//
//        //先排序
//        Arrays.sort(len);
//
//
//        //添加前缀
//
//        if (strs.length == 1) {
//
//            for (int j = 0; j < len[0]; j++) {
//                strings.add(String.valueOf(strs[0].charAt(j)));
//            }
//
//        } else if (strs.length == 2) {
//
//            for (int i = 0; i < strs.length - 1; i++) {
//
//                for (int j = 0; j < len[0]; j++) {
//
//                    if (strs[i].charAt(0) == strs[i + 1].charAt(0)) {
//
//                        if (strs[i].charAt(j) == strs[i + 1].charAt(j)) {
//
//                            strings.add(String.valueOf(strs[i].charAt(j)));
//
//                        }
//
//                    }
//
//
//                }
//
//            }
//
//        } else {
//            for (int j = 0; j < len[0]; j++) {
//
//                for (int i = 0; i < strs.length - 2; i++) {
//
//                    if (strs[i].charAt(j) == strs[i + 1].charAt(j)) {
//
//                        if (strs[i + 1].charAt(j) == strs[i + 2].charAt(j)) {
//
//                            strings.add(String.valueOf(strs[0].charAt(j)));
//
//                        }
//
//                    }
//                }
//
//
//            }
//        }
//
//        String result = "";
//        for (int i = 0; i < strings.size(); i++) {
//
//            result = result + strings.get(i);
//
//        }
//
//        return result;
//
//    }


//    /*
//    首先，我们将描述一种查找一组字符串的最长公共前缀 LCP(S1....Sn)的简单方法
//
//    我们将会用到这样的结论： LCP(S1....Sn) = LCP（LCP(LCP(S1,S2),S3),...Sn）
//     */
//
//    public static String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) return "";
//        String prefix = strs[0];
//        for (int i = 1; i < strs.length; i++)
//            while (strs[i].indexOf(prefix) != 0) {
//                prefix = prefix.substring(0, prefix.length() - 1);
//                if (prefix.isEmpty()) return "";
//            }
//        return prefix;
//    }


    /*

    算法二：水平扫描
    算法

想象数组的末尾有一个非常短的字符串，使用上述方法依旧会进行 S​S​ 次比较。优化这类情况的一种方法就是水平扫描。
我们从前往后枚举字符串的每一列，先比较每个字符串相同列上的字符（即不同字符串相同下标的字符）然后再进行对下一列的比较。

     */

    //好思想，肯定是从0索引到不重复的索引 所以用 String[]  的 substring，返回指定索引就好了
    //好方法！
    public static String longestCommonPrefix(String[] strs) {
        //strs 为空或者长度为0返回空
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length() ; i++){
            //定义需要的比较的字符 c
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j ++) {

                //i等于其中一个字符串的长度，就返回 或者找到了与前面有不同的字符
                if (i == strs[j].length() || strs[j].charAt(i) != c)

                    return strs[0].substring(0, i);
            }
        }
        //返回
        return strs[0];
    }




    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        String[] strs1 = {"a"};
        String[] strs2 = {"flow", "flower"};

        String[] strs4 = {"aca", "cba"};

        String[] strs5 = {"a", "b"};
        String result = longestCommonPrefix(strs);

        System.out.println(result);
    }

}
