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

    //二分法
    //中位数：将一个集合划分为两个长度相等的子集，其中一个子集中的元素总是大于另一个子集中的元素。
    public double findMedianSortedArrays(int[] A, int[] B) {
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

    //思路一，先对两个有序数组进行合并，再对合并完的数组求中位数

    /*
        合并,
        新建一个以两个集合长度之和为长度的新数组，从两数组最左边开始比起，把小的放入新集合，并用变量标记后一位置
     */

    public static int[] merge(int[] num1, int[] num2) {
        //变量用于存储两个集合应该被比较的索引（存入新集合就加一）
        int a = 0;
        int b = 0;
        //定义num3为合并的数组，长度为两者加起来
        int[] num3 = new int[num1.length + num2.length];

        for (int i = 0; i < num3.length; i++) {
            if (a < num1.length && b < num2.length) { //两数组都未遍历完，相互比较后加入

                //num1中的数大于num2数字，放入num2的，然后b++
                if (num1[a] > num2[b]) {
                    num3[i] = num2[b];
                    b++;
                } else {  //num2中的数大于num1数字，放入num1的，然后a++
                    num3[i] = num1[a];
                    a++;
                }
            } else if (a < num1.length) {   //num2已经遍历完，无需比较，直接将剩余num1加入
                num3[i] = num1[a];
                a++;
            } else if (b < num2.length) {    //num1已经遍历完，无需比较，直接将剩余num2加入
                num3[i] = num2[b];
                b++;
            }
        }
        return num3;
    }
    /*
            对有序数组求中位数
            值得注意的是，int 和double 类型数的转换，直接return的话，是int类型的，除不尽的都舍弃了
            还有就是，长度和索引的关系，索引从0开始，长度是几就是几
     */


    private static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int[] nums = merge(nums1, nums2);

        int s = nums.length;
        if (s % 2 == 0) {
            return (nums[s / 2 - 1] + nums[s / 2]) / 2.0;

        } else return nums[(nums.length - 1) / 2] * 1.0;


    }


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
    private static double findMedianSortedArrays3(int[] A, int[] B) {
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


    /*

    针对第一种思路，其实，我们不需要将两个数组真的合并，我们只需要找到中位数在哪里就可以了。

    开始的思路是写一个循环，然后里边判断是否到了中位数的位置，到了就返回结果，但这里对偶数和奇数的分类会很麻烦。
    当其中一个数组遍历完后，出了 for 循环对边界的判断也会分几种情况。总体来说，虽然复杂度不影响，但代码会看起来很乱。

    首先是怎么将奇数和偶数的情况合并一下。

    用 len 表示合并后数组的长度，如果是奇数，我们需要知道第 （len+1）/2 个数就可以了，如果遍历的话需要遍历 int(len/2 ) + 1 次。
    如果是偶数，我们需要知道第 len/2和 len/2+1 个数，也是需要遍历 len/2+1 次。所以遍历的话，奇数和偶数都是 len/2+1 次。

    返回中位数的话，奇数需要最后一次遍历的结果就可以了，偶数需要最后一次和上一次遍历的结果。
    所以我们用两个变量 left 和 right，right 保存当前循环的结果，在每次循环前将 right 的值赋给 left。这样在最后一次循环的时候，left 将得到 right 的值，也就是上一次循环的结果，接下来 right 更新为最后一次的结果。

    循环中该怎么写，什么时候 A 数组后移，什么时候 B 数组后移。
    用 aStart 和 bStart 分别表示当前指向 A 数组和 B 数组的位置。如果 aStart 还没有到最后并且此时 A 位置的数字小于 B 位置的数组，那么就可以后移了。也就是aStart＜m&&A[aStart]< B[bStart]。

    但如果 B 数组此刻已经没有数字了，继续取数字 B[ bStart ]，则会越界，所以判断下 bStart 是否大于数组长度了，这样 || 后边的就不会执行了，也就不会导致错误了，所以增加为 aStart＜m&&(bStart)>= n||A[aStart]<B[bStart])。

     */

    public static double findMedianSortedArrays4(int[] A, int[] B) {
        //m ,n是 A，B数组的长度
        int m = A.length;
        int n = B.length;

        int len = m + n;
        int left = -1, right = -1;

        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;

            //这个判断是关键
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    public static void main(String[] args) {

        int[] num1 = {1, 3};
        int[] num2 = {2};
        FindMedianSortedArrays0004 findMedianSortedArrays0004 = new FindMedianSortedArrays0004();
        double res = findMedianSortedArrays0004.findMedianSortedArrays2(num1, num2);
        System.out.println(res);
    }


}
