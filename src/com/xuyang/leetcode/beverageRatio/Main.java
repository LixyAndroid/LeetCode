package com.xuyang.leetcode.beverageRatio;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Li Xuyang
 * @date 2020/4/18 17:02
 */
public class Main {


    /*

    输入第一行，两个正整数n和V，
    表示原料种类数和容器容积。(1<=n<=1000，1<=V<=1000000) 输入第二行包含n个数a1,a2,a3,...an，表示n种原料的配比。
    输入第三行包含n个数b1,b2,b3...bn，表示小M拥有的各种原料数。 （数字间以空格隔开）
     */
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int v = in.nextInt();
        int sum =0;
        double[] a = new  double[n];
        double[] b = new  double[n];
        for (int i = 0; i < n; i++) {
            a[i]= in.nextDouble();
            sum+=a[i];

        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextDouble();
        }

        //定义最大重量
        double weightMax = b[0]/a[0]*sum;
        for (int i = 0; i < n; i++) {
            double maxV = b[i]/a[i]*sum;

            //因为某种材料过少，已经不能满足当地一个全部用量的时候 的总重了
            if (maxV<weightMax){
                weightMax = maxV;
            }

        }

        if (weightMax>=v){
            keepFour(v);
        }else {
            keepFour(weightMax);
        }

    }



    public static  void keepFour(double d1){
        DecimalFormat df=new DecimalFormat("#0.0000");
        System.out.println(df.format(d1));
    }
}
