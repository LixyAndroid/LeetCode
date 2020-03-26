package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/26 11:42
 *  把数组排成最小的数
 */
public class PrintMinNumber31 {


    //输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    // 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

    /*
    首先因为数组可能非常长，所以要定义一个整数类，使得其大小可以容纳所有的数组元素组成的数不大现实。因此我们直接输出这个数组，让其看起来像一个整数，这样我们就可以把问题转化为：如何给这个数组排序，使其看做一个数字的时候最小。
    第一个想到的可能是按字典序排序，小的在前面。可惜这个是不可行的，比如32的字典序比322小，但是32322比32232大，
    所以在这里自定义一个比较大小的函数，比较两个字符串s1, s2大小的时候，先将它们拼接起来，比较s1+s2,和s2+s1那个大，如果s1+s2大，那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面。
     */
    public static String printMinNumber(int[] numbers){

        if (numbers==null||numbers.length==0){
            return "";
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j <numbers.length ; j++) {
                int sum1 = Integer.parseInt(numbers[i]+""+numbers[j]);
                int sum2 = Integer.parseInt(numbers[j]+""+numbers[i]);
                if (sum1>sum2){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }

            }



        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int number : numbers) {
            stringBuilder.append(number);
        }

        return  stringBuilder.toString();


    }

    public static void main(String[] args) {
        int[] ints = {5,12,321};
        String s = printMinNumber(ints);
        System.out.println(s);

    }
}
