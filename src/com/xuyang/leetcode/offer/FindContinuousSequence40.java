package com.xuyang.leetcode.offer;

import java.util.ArrayList;

/**
 * @author Li Xuyang
 * @date 2020/3/28 22:02
 *和为S的连续正数序列
 */
public class FindContinuousSequence40 {

    //和为S的连续正数序列
    //穷举法，从1开始

    /*
    小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
    但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
    没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
    输出描述:
    输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

     */
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempList = new ArrayList<>();

        //小于3的时候，不能有序列

        if(sum<3){
            return resList;
        }
        int begin = 1;
        int sumCur = 1;
        int cur = 1;

        while (begin <= sum / 2 + 1) {
            if (sumCur == sum) {
                for (int k = begin; k <= cur; k++) {

                    tempList.add(k);
                }
                resList.add(tempList);

                //这样可以清除
                tempList = new ArrayList<>();


                //相等一轮保存后，减去开头的，开头++，末尾++，赋值
                sumCur = sumCur - begin;
                begin++;
                cur++;
                sumCur+=cur;

            } else  if (sumCur > sum) {
                //大的话，减去开头的
                sumCur = sumCur - begin;
                begin++;
            } else {
                //小的话，加上末尾的
                cur++;
                sumCur += cur;
            }

        }


        return resList;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        resList = findContinuousSequence(4);
        System.out.println(resList);
    }
}
