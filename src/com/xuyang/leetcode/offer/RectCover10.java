package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/9 09:33
 * 矩形覆盖
 */
public class RectCover10 {

    //我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    public static  int rectCover(int target){

        if (target<3){
            return  target;
        }else {
            return  rectCover(target-1)+rectCover(target-2);
        }

    }

    public static  int rectCover2(int target){

        if (target<=2){
            return  target;
        }

        int per1 =1,per2=2;

        for (int i = 2; i <target; i++) {

            int temp = per1 +per2;
            per1 = per2;
            per2 = temp;

        }

        return  per2;


    }


    public static void main(String[] args) {

        System.out.println(rectCover(1));
        System.out.println(rectCover2(1));



    }
}
