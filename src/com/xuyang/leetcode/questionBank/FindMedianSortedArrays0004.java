package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/4/22 11:59
 * 寻找两个有序数组的中位数
 */
public class FindMedianSortedArrays0004 {

    /*
    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    你可以假设 nums1 和 nums2 不会同时为空。

    示例 1:
    nums1 = [1, 3]
    nums2 = [2]

    则中位数是 2.0
    示例 2:
    nums1 = [1, 2]
    nums2 = [3, 4]

    则中位数是 (2 + 3)/2 = 2.5
     */

    //错误
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        int m = nums1.length;
//        int n = nums2.length;
//
//        int len = m + n;
//        int left = -1, right = -1;
//        //下标
//        int aStart = 0, bStart = 0;
//
//        //len/2次,相当于排序了，取出最中间的数
//        for (int i = 0; i < len / 2; i++) {
//            //right值赋给left
//            left = right;
//
//            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
//
//                right = nums1[aStart++];
//            } else {
//                right = nums2[bStart];
//            }
//
//        }
//        if ((len & 1) == 0) {//长度为奇数
//            return (left + right) / 2.0;
//        } else {//长度为偶数
//            return right;
//        }
//
//    }

    //二分法
    //中位数：将一个集合划分为两个长度相等的子集，其中一个子集中的元素总是大于另一个子集中的元素。
    public double findMedianSortedArrays2(int[] A, int[] B) {
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
                if ((m + n) % 2 == 1) {//奇数
                    return maxLeft;
                }


                //偶数
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

        int[] num1 = {1,3};
        int[] num2 = {2};
        FindMedianSortedArrays0004 findMedianSortedArrays0004 = new FindMedianSortedArrays0004();
        double res =findMedianSortedArrays0004.findMedianSortedArrays2(num1,num2);
        System.out.println(res);
    }


}
