package com.xuyang.leetcode.findMedianSortedArrays;


/**
 * @author Mloong
 * date  2019/7/22 20:12
 * <p>
 * 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 可以假设 nums1 和 nums2 不会同时为空。
 */
public class Solution {

    //思路一，先对两个有序数组进行合并，再对合并完的数组求中位数

    /*
        合并,
        新建一个以两个集合长度之和为长度的新数组，从两数组最左边开始比起，把小的放入新集合，并用变量标记后一位置
     */

//    public static int[] merge(int[] num1, int[] num2) {
//        //变量用于存储两个集合应该被比较的索引（存入新集合就加一）
//        int a = 0;
//        int b = 0;
//        //定义num3为合并的数组，长度为两者加起来
//        int[] num3 = new int[num1.length + num2.length];
//
//        for (int i = 0; i < num3.length; i++) {
//            if (a < num1.length && b < num2.length) { //两数组都未遍历完，相互比较后加入
//
//                //num1中的数大于num2数字，放入num2的，然后b++
//                if (num1[a] > num2[b]) {
//                    num3[i] = num2[b];
//                    b++;
//                } else {  //num2中的数大于num1数字，放入num1的，然后a++
//                    num3[i] = num1[a];
//                    a++;
//                }
//            } else if (a < num1.length) {   //num2已经遍历完，无需比较，直接将剩余num1加入
//                num3[i] = num1[a];
//                a++;
//            } else if (b < num2.length) {    //num1已经遍历完，无需比较，直接将剩余num2加入
//                num3[i] = num2[b];
//                b++;
//            }
//        }
//        return num3;
//    }
    /*
            对有序数组求中位数
            值得注意的是，int 和double 类型数的转换，直接return的话，是int类型的，除不尽的都舍弃了
            还有就是，长度和索引的关系，索引从0开始，长度是几就是几
     */


//    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        int[] nums = merge(nums1, nums2);
//
//        int s = nums.length;
//        if (s % 2 == 0) {
//            return (nums[s / 2 - 1] + nums[s / 2]) / 2.0;
//
//        } else return nums[(nums.length - 1) / 2] * 1.0;
//
//
//    }


    //思路二： 递归法 官方解法

    /*
     在统计中，中位数被用来：

        将一个集合划分为两个长度相等的子集，其中一个子集中的元素总是大于另一个子集中的元素。

    时间复杂度
    时间复杂度：O(log(min(m,n)))，
    首先，查找的区间是 [0, m]。 而该区间的长度在每次循环之后都会减少为原来的一半。
    所以，我们只需要执行 log(m) 次循环。由于我们在每次循环中进行常量次数的操作，
    所以时间复杂度为 O(log(m))。 由于m≤n，
    所以时间复杂度是O(log(min(m,n)))。

     */
    private static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 4, 6, 9};
        int[] nums2 = new int[]{0, 2, 5, 10, 21};

        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println(median);

    }


}
