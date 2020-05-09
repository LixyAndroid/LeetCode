package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/5/9 12:25
 * x 的平方根
 */
public class MySqrt0069 {


    /*
    实现 int sqrt(int x) 函数。

    计算并返回 x 的平方根，其中 x 是非负整数。

    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

     */
    //二分查找

    /*
    由于 xx 平方根的整数部分ans 是满足 k^2≤x 的最大 k 值，因此我们可以对 k 进行二分查找，从而得到答案。

二分查找的下界为 0，上界可以粗略地设定为 x。在二分查找的每一步中，我们只需要比较中间元素 mid 的平方与 x 的大小关系，并通过比较的结果调整上下界的范围。
由于我们所有的运算都是整数运算，不会存在误差，因此在得到最终的答案 ans 后，也就不需要再去尝试 ans+1 了。

     */
    public int mySqrt(int x) {

        int l=0,r=x,ans=-1;

        while (l<=r){

            //中间值
            int mid = l+(r-l)/2;

            //主要是上下界赋值的问题
            if ((long)mid*mid<=x){
                ans = mid;
                l = mid+1;
            }else {
                r = mid-1;
            }


        }
        return ans;
    }


    public int mySqrt2(int x) {

        int res = (int) Math.sqrt(x);
        return res;
    }


    //
    public int mySqrt3(int x) {

        if (x==0){
            return 0;
        }


        int ans = (int) Math.exp(0.5*Math.log(x));
        return (long)(ans+1)*(ans+1)<=x?ans+1:ans;
    }
    public int mySqrt4(int x) {
        if (x==0){
            return 0;
        }

        double C =x,x0=x;
        while (true){
            double xi = 0.5*(x0+C/x0);
            if (Math.abs(x0-xi)<1e-7){
                break;
            }
            x0=xi;
        }
        return (int) x0;
    }
    public static void main(String[] args) {
        MySqrt0069 mySqrt0069 = new MySqrt0069();
        int res = mySqrt0069.mySqrt4(Integer.MAX_VALUE);
        System.out.println(res);
    }
}
