package com.xuyang.leetcode.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/4/2 16:50
 */
public class LastRemaining_Solution45 {

    /*
      每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
      其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
      每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
      并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)

      如果没有小朋友，请返回-1
     */


    /*
    思路：
    java中直接使用一个list来模拟，并使用一个索引cur类指向删除的位置，
    当cur的值为list的size，就让cur到头位置。
     */
    public static int lastRemaining(int n, int m) {

        if (n<1||m<1){
            return -1;
        }

        List<Integer> list = new LinkedList<>();
        //构建list
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int cur = -1;

        while (list.size()>1){

            for (int i = 0; i < m; i++) {
                cur++;

                if (cur==list.size()){
                    cur = 0;
                }
            }
            list.remove(cur);
            //cur--的原因，因为新的list中cur指向了下一个元素，
            // 为了保证移动m个准确性，所以cur向前移动一位
            cur--;
        }

        return list.get(0);

    }

    public static void main(String[] args) {

        int n=20;
        int m = 5;
        int res = lastRemaining(20,5);
        System.out.println(res);
    }
}
