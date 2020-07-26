package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/7/24 22:07
 * 剑指 Offer 43. 1～n整数中1出现的次数
 */
public class CountDigitOne43 {
    //输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
    //
    //例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

    /*
    1,当 cur = 0时： 此位 1 的出现次数只由高位 high 决定，计算公式为：
                        high×digit
    2,当 cur = 1 时： 此位 1 的出现次数由高位 high 和低位 low 决定，计算公式为：
                        high×digit+low+1
    3,当 cur=2,3,⋯,9 时： 此位 1 的出现次数只由高位 high 决定，计算公式为：
                        (high+1)×digit

     */

    /*
    设计按照 “个位、十位、...” 的顺序计算，则 high / cur / low / digithigh/cur/low/digit 应初始化为：
    high = n // 10
    cur = n % 10
    low = 0
    digit = 1 # 个位

    因此，从个位到最高位的变量递推公式为：
    while high != 0 or cur != 0: # 当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
   low += cur * digit # 将 cur 加入 low ，组成下轮 low
   cur = high % 10 # 下轮 cur 是本轮 high 的最低位
   high //= 10 # 将本轮 high 最低位删除，得到下轮 high
   digit *= 10 # 位因子每轮 × 10
     */
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

    //转换成char
    public int countDigitOne2(int n) {
        int count = 0;
        while (n > 0) {
            String str = String.valueOf(n);
            char[] strChar = str.toCharArray();
            for (int i = 0; i < strChar.length; i++) {
                if (strChar[i] == '1') {
                    count++;
                }
            }
            n--;
        }
    return count;
    }

    public static void main(String[] args) {
        CountDigitOne43 countDigitOne43 = new CountDigitOne43();
        int n = 2043;
        int res = countDigitOne43.countDigitOne2(n);
        System.out.println(res);
    }
}
