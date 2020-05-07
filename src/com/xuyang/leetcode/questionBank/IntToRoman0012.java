package com.xuyang.leetcode.questionBank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/5/7 11:08
 * 整数转罗马数字
 */
public class IntToRoman0012 {



    //说明：
    //
    //这道题能想到用贪心算法，是来源于生活中的经验，使用贪心算法有一定取巧的因素：
    //
    //这个问题直觉是贪心去做大概不会有问题；
    //想举出反例推翻贪心算法，但是举不出来；
    //真的用贪心算法去验证，可以通过测评。
    //如果证明不出来贪心算法的有效性，我个人觉得在绝大多数情况下是没有关系的。有贪心选择的直觉，举不出反例，能编码实现还能过测评，就很棒了。

    /*

    罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

示例 1:

输入: 3
输出: "III"
示例 2:

输入: 4
输出: "IV"
示例 3:

输入: 9
输出: "IX"
示例 4:

输入: 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.
示例 5:

输入: 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.

     */
    public String intToRoman(int num) {

        //把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        //并且按照阿拉伯数字的大小降序排列，这就贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index<13){

            //特别注意：这里是等号
            while (num>=nums[index]){
                stringBuilder.append(romans[index]);
                num-=nums[index];
            }
            index++;
        }

        return stringBuilder.toString();

    }
}
