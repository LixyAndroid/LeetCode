package com.xuyang.leetcode.questionBank;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/8/12 16:30
 */
public class ThreeSumClosest00162 {
    public static int[] threeSumClosest(int[] nums, int target) {

        /*
         查看Arrays.sort源码！
            Java1.8的快排是一种双轴快排，顾名思义：双轴快排是基于两个轴来进行比较，跟普通的选择一个点来作为轴点的快排是有很大的区别的，
            双轴排序利用了区间相邻的特性，对原本的快排进行了效率上的提高，很大程度上是利用了数学的一些特性。。。。。嗯。。。反正很高深的样子

            算法步骤
            1.对于很小的数组（长度小于27），会使用插入排序。
            2.选择两个点P1,P2作为轴心，比如我们可以使用第一个元素和最后一个元素。
            3.P1必须比P2要小，否则将这两个元素交换，现在将整个数组分为四部分：
            （1）第一部分：比P1小的元素。
            （2）第二部分：比P1大但是比P2小的元素。
            （3）第三部分：比P2大的元素。
            （4）第四部分：尚未比较的部分。
            在开始比较前，除了轴点，其余元素几乎都在第四部分，直到比较完之后第四部分没有元素。
            4.从第四部分选出一个元素a[K]，与两个轴心比较，然后放到第一二三部分中的一个。
            5.移动L，K，G指向。
            6.重复 4 5 步，直到第四部分没有元素。
            7.将P1与第一部分的最后一个元素交换。将P2与第三部分的第一个元素交换。
            8.递归的将第一二三部分排序。

         */
        Arrays.sort(nums);
        //初始定义最接近的值，为前3个数的和
        int res[] = new int[3];
        res[0] = nums[0];
        res[1] = nums[1];
        res[2] = nums[2];

        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            //又是双指针
            int start = i + 1, end = nums.length - 1;
            // start < end，保证遍历一遍
            while (start < end) {
                //定义和
                int sum = nums[start] + nums[end] + nums[i];
                //用绝对值进行比较，条件成立为找到了更接近的值，将sum赋值给ans
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                    res[0] = nums[start];
                    res[1] = nums[end];
                    res[2] = nums[i];
                }

                if (sum > target) { //关键就在于这里，因为已经排序了，若3数之和大于target 则前移即现在值大了，需要减小
                    end--;
                } else if (sum < target) {   //关键就在于这里，因为已经排序了，若3数之和小于target 则前移即现在值小了，需要增大
                    start++;
                } else {
                    res[0] = nums[start];
                    res[1] = nums[end];
                    res[2] = nums[i];
                    return res; //返回
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4,10,8,6};
        int[] res = threeSumClosest(nums,4);
        System.out.println(Arrays.toString(res));

    }
}
