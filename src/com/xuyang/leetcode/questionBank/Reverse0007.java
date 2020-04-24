package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/4/24 17:12
 * 整数反转
 */
public class Reverse0007 {

   /*
  利用 StringBuilder reverse反转，不过要判断异常
    */

    public int reverse(int x) {

        int res=0;

        if (x>0){
            String xString = String.valueOf(x);
            StringBuilder xreversice = new StringBuilder(xString);
            xString = xreversice.reverse().toString();
            try {
                res = Integer.parseInt(xString);
            }catch (NumberFormatException e){

            }

            return res;

        }else {
            x = Math.abs(x);
            String xString = String.valueOf(x);
            StringBuilder xreversice = new StringBuilder(xString);
            xString = xreversice.reverse().toString();
            try {
                res = Integer.parseInt(xString);
            }catch (NumberFormatException e){

            }

            return res*-1;

        }

    }

     /*
    方法：弹出和推入数字 & 溢出前进行检查
思路

我们可以一次构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。

算法

反转整数的方法可以与反转字符串进行类比。

我们想重复“弹出” x 的最后一位数字，并将它“推入”到 rev 的后面。最后，rev 将与 x 相反。

要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法。

//pop operation:
pop = x % 10;
x /= 10;

//push operation:
temp = rev * 10 + pop;
rev = temp;
但是，这种方法很危险，因为当 temp=rev⋅10+pop 时会导致溢出。

幸运的是，事先检查这个语句是否会导致溢出很容易。

为了便于解释，我们假设 rev 是正数。

如果 temp=rev⋅10+pop 导致溢出，那么一定有 rev≥INTMAX/10 。
如果rev>INTMAX/10，那么 temp=rev⋅10+pop 一定会溢出。
如果 rev==INTMAX/10，那么只要 pop>7，temp = temp=rev⋅10+pop 就会溢出。
当rev 为负时可以应用类似的逻辑。
     */

    public int reverse2(int x) {
        int rev = 0;
        while (x!=0){
            int pop =x%10;
            x/=10;
            if (rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>7)){
                return 0;
            }

            if (rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop<-8)){
                return rev;
            }
            rev = rev*10+pop;
        }
        return rev;

    }

    public static void main(String[] args) {
        Reverse0007 reverse0007 = new Reverse0007();

        int res= reverse0007.reverse(1343423423);
        System.out.println(res);
    }
}
