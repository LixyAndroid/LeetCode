package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/26 16:50
 * 丑数
 */
public class GetUglyNumber_Solution33 {

    //把只包含质因子2、3和5的数称作丑数（Ugly Number）。
    // 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

    /*
    这道题目自己是有思路的，丑数能够分解成2^x3^y5^z,
    所以只需要把得到的丑数不断地乘以2、3、5之后并放入他们应该放置的位置即可，
    而此题的难点就在于如何有序的放在合适的位置。
    1乘以 （2、3、5）=2、3、5；2乘以（2、3、5）=4、6、10；3乘以（2、3、5）=6,9,15；5乘以（2、3、5）=10、15、25；
    从这里我们可以看到如果不加策略地添加丑数是会有重复并且无序，
    而在2x，3y，5z中，如果x=y=z那么最小丑数一定是乘以2的，但关键是有可能存在x》y》z的情况，
    所以我们要维持三个指针来记录当前乘以2、乘以3、乘以5的最小值，然后当其被选为新的最小值后，要把相应的指针+1；
    因为这个指针会逐渐遍历整个数组，因此最终数组中的每一个值都会被乘以2、乘以3、乘以5，也就是实现了我们最开始的想法，只不过不是同时成乘以2、3、5，而是在需要的时候乘以2、3、5.
     */
    public static int getUglyNumber_Solution(int index) {

        if (index <= 0) {
            return 0;
        }

        //用一个index长度的数组
        int[] result = new int[index];
        //初始化三个指向三个潜在成为最小丑数的位置
        int p2 = 0, p3 = 0, p5 = 0;
        //给第一个位置赋值1
        result[0] = 1;

        for (int i = 1; i < index; i++) {

            result[i] = Math.min(result[p2] * 2, Math.min(result[p3] * 3, result[p5] * 5));
            //保证3个if都能取到
            if (result[i] == result[p2] * 2) {
                p2++;
            }

            //保证3个if都能取到
            if (result[i] == result[p3] * 3) {
                p3++;
            }
            //保证3个if都能取到
            if (result[i] == result[p5] * 5) {
                p5++;
            }

        }

        return result[index - 1];

    }


    public static void main(String[] args) {
        int res = getUglyNumber_Solution(1500);

        System.out.println(res);
    }
}
