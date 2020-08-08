package com.xuyang.leetcode.decimalFormatTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Li Xuyang
 * @date 2020/8/8 22:47
 */
public class DecimalFormat {

    //建议使用的使用看api
    /**
     * RoundingMode.DOWN
     * 四舍五入模式，四舍五入到零。不要对数字进行增量
     *在所丢弃的分数之前(即截断)。请注意,这
     *舍入模式不会增加计算值的大小。
     *
     *使用{@link RoundingMode#DOWN}代替。
     */

    /**
     * BigDecimal.ROUND_CEILING,
     * 四舍五入模式，以四舍五入到正无穷。如果
     * 结果为正数，行为为{@code RoundingMode.UP};
     * 如果为负数，则表现为{@code RoundingMode.DOWN}。请注意
     * 舍入模式不会减少计算值。
     */
    //...
    //以后使用这种方式进行格式化数字，但是不能多余补0，需要实在复制需要配合使用，下午美团但保留一位小数的刚好适用
    public static void main(String[] args) {
        //3.14159265358979323846
        double val = 13.14159;
        //保留3位小数，多余的直接删去
        double n1 = new BigDecimal(val).setScale(3, RoundingMode.DOWN).doubleValue();
        System.out.println(n1);
        double val2 = 3.1;
        //小数点后面不足3位，则什么都不做
        double n2 = new BigDecimal(val2).setScale(3, RoundingMode.DOWN).doubleValue();
        System.out.println(n2);
        double n3 = new BigDecimal(val).setScale(3, RoundingMode.FLOOR).doubleValue();
        System.out.println(n3);

        double val3 = 3;
        //保留3位小数，多余的直接删去
        double n4 = new BigDecimal(val3).setScale(2, RoundingMode.DOWN).doubleValue();
        System.out.println(n4);

        System.out.println("---------------------------------");//3.14


        //取一位整数
        System.out.println(new java.text.DecimalFormat("0").format(val));//3
        //取一位整数和两位小数
        System.out.println(new java.text.DecimalFormat("00.0000000").format(val));
        //取三位位整数和三位小数
        System.out.println(new java.text.DecimalFormat("000.000").format(val));

        //建议以后用，但是这个是四舍五入的，但不要四舍五入就不能用了
        System.out.println(new java.text.DecimalFormat(".000").format(val));


    }
}
