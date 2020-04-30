package com.xuyang.leetcode.questionBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/4/30 19:44
 * 至少有 1 位重复的数字
 */
public class NumDupDigitsAtMostN1012 {


    //dfs数位dp
    private int[] tempNumDupDigitsAtMostN;
    private int[][] tempNumDupDigitsAtMostNDp;

    //给定正整数 N，返回小于等于 N 且具有至少 1 位重复数字的正整数。
    public int numDupDigitsAtMostN(int N) {

        tempNumDupDigitsAtMostN = new int[10];
        int temp = N + 1;
        int pos = 0;
        while (N != 0) {
            tempNumDupDigitsAtMostN[pos++] = N % 10;
            N /= 10;
        }
        tempNumDupDigitsAtMostNDp = new int[1 << 10][pos];
        for (int i = 0; i < tempNumDupDigitsAtMostNDp.length; i++) {
            Arrays.fill(tempNumDupDigitsAtMostNDp[i], -1);
        }

        return temp - dfs(pos - 1, 0, true);
    }

    private int dfs(int pos, int mask, boolean limit) {
        if (pos == -1) {
            return 1;
        }

        if (!limit && tempNumDupDigitsAtMostNDp[mask][pos] != -1) {

            return tempNumDupDigitsAtMostNDp[mask][pos];
        }

        int up = limit ? tempNumDupDigitsAtMostN[pos] : 9;

        int tmp = 0;

        for (int i = 0; i < up; i++) {
            if (((1 << i) & mask) == 0) {
                if (i == 0 && mask == 0) {
                    tmp += dfs(pos - 1, mask, false);
                } else {
                    tmp += dfs(pos - 1, mask | (1 << i), limit && tempNumDupDigitsAtMostN[pos] == i);
                }
            }
        }

        if (!limit) {
            tempNumDupDigitsAtMostNDp[mask][pos] = tmp;
        }

        return tmp;

    }


    /*
    本题的思路是将其转换为数位DP，利用排列组合完成解题

    题目需要求数字N有多少个重复的数字，可以将其转换为求数字N有多少个不重复的数字，因为求不重复的数字可以更好地使用排列组合来求解

    现在我们的重心来到要怎么将这个数字分解成可以按一定规律计算其所有不重复数位的排列组合

    总体的思路是：设剩下的位置为i，剩下的数字为j，则不重复数字是在每一位依次填入与前几位不同的数字，即选取剩下的j个数字填入剩下的i个位置，即有A(j, i)种可能，最后将其累加就是不重复数字个数

    实际遍历中，我们只需要剩下的位置i这个变量，设数字N的位数为k，则剩下的数字j=10-(k-i)

    对于以上思路，我们还可以分为以下两种情况，第一种是高位带0，第二种是高位不带0

    我们知道数学中0这个数字比较特别，高位数为0即等于没有高位数，比如0096就是数字96，这个数字尽管两个0重复了，但是这两个0属于高位，所以0096这个数字不是重复数字，即第一种情况允许高位的0可以重复

    使用第一种情况求位数小于k的不重复数字的个数：因为最高位总是为0，因此一开始剩下的数字j总是为9个（1-9），然后剩下的低位可选的数字总共有A(10-1,i)

    使用第二种情况求位数为k的不重复数字的个数：一开始剩下的数字j受数字N每位上的数字影响，设N的当前位的数字为n，则j<=n，然后剩下的低位可选的数字总共有A(10-(k-i),i)

    我们具体来看一个例子，比如3562这个数字

    使用第一种情况将其分解，将其排列组合可以选择的数字列出来
    4th 3th 2th 1th total
     0   0   0  1-9 9xA(9,0)
     0   0  1-9 0-9 9xA(9,1)
     0  1-9 0-9 0-9 9xA(9,2)

    使用第二种情况将其分解：
    4th 3th 2th 1th total
    1-2 0-9 0-9 0-9 2xA(9,3)
     3  0-4 0-9 0-9 5xA(8,2)
     3   5  0-5 0-9 6xA(7,1)
     3   5   6  0-1 2xA(6,0)
     3   5   6   2  1
    注：total为理想的总数，最后还需要将重复的数字剔除，比如第二种情况的第二行中，如果遍历到了33xx，则后面的xx不需要再计算，因为高位的33已经使这个数字变为了重复数字，循环可以直接break掉

    比较特殊的情况还有第二种情况的第一行，注意高位是从1开始，因为0的情况在第一种情况的最后一行已经考虑；还有第二种情况的最后一行，如果前三个高位的数字不重复，并且最后要填入的2也与前面数字不重复，则数字N本身也是一个不重复数字

    因此，我们可以得到如下代码

     */
    public int numDupDigitsAtMostN2(int N) {
        return N - dp(N);
    }

    /**
     * 找到不重复的数字
     *
     * @param n
     * @return
     */
    public int dp(int n) {
        int total = 0;
        int[] used = new int[10];
        //1、找到位数
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }
        int k = digits.size();//位数K

        //2、首位为0的情况
        for (int i = k - 1; i >= 1; i--) {
            total += 9 * A(9, i-1);//首位为0，第一个可选的为9项目，剩下的就是在第一位以外的9个数字中任选i-1个填充，题目说小于10^9，不需要考虑大于9位
        }

        //3、首位不为0的情况
        //倒序，从头找，
        for (int i=k-1;i>=0;i--){
            int num = digits.get(i);//获得特定位的数
            //对于选中的num位，以后的数字都要小于它，
            // 比如4325选中了4，那么这个位置的数字必然小于等于4，那么有0123可选，但是由于首位不能为0，因此若为首位可选项少一个
            for (int j=(i==k-1?1:0);j<num;j++){
                //此时j表示用来判断是否要使用的数字,如果被使用过，则不考虑这个数字（这个被使用是说前面的数字，针对i的那个）
                if (used[j] != 0){
                    continue;
                }
                //这个比较微妙，我们注意到外层有一个j的循环，其实这个是对于i这个位置的值，可以选择那些，然后下面的A其实是对再下一位的选择
                //比如4325，当前i==2，表示选中了3，那么对于3这个位置，j可以选择012，那么可以知道j循环会进行3次
                //然后对于25这两个后面的位置，10-(4-2)=8,A(8,2),刚好，因为前面2个位置被选择了，只剩下8个数字，选2个排序
                //本来i==2这个位置，应该是A(9,3)，但是由于要小于num，则使用j来加多次的A(8,2)即可，这个很微妙
                total+=A(10-(k-i),i);
            }
            used[num]++;
            if (used[num] >1){
                //表示前面的数字有重复，比如3325，执行完后33确认，那么比3300大比3325小的数字不用再考虑了（因为我们是倒序的，i从最高位开始）
                break;
            }

            //如果到了最后一位并且不重复，不会进入j的那个循环
            if (i==0){
                total = total+1;
            }
        }
        return total;
    }
    public int fact(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public int A(int m, int n) {
        return fact(m) / fact(m - n);
    }

}
