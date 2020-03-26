package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/26 17:34
 * 第一个只出现一次的字符
 */
public class FirstNotRepeatingChar33 {

    //在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
    // 如果没有则返回 -1（需要区分大小写）.
    /*
    刚开始还以为有什么特殊的解法，没想到当年也是按照hash的思想来做的，先统计出现的次数，然后在返回相应的index
     */
    public static int firstNotRepeatingChar(String str){

        if (str ==null||str.length()==0){
            return  -1;
        }

        int[] count = new int[256];

        //用一个类似hash的东西存储字符出现的次数，很方便
        for (int i = 0; i < str.length() ;i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {

            if (count[str.charAt(i)]==1){
                return  i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "google";
        System.out.println(firstNotRepeatingChar(str));
    }
}
