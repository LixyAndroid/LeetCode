package com.xuyang.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/3/27 15:24
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK37 {
    //方法有很多的
    //1，暴力法

    public int getNumberOfK(int[] array, int k) {

        int cnt = 0;
        if (array == null || array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                cnt += 1;
            }
        }


        return cnt;
    }

    //使用Arrays的库，binarySearch 二分查找
    public int getNumberOfK2(int[] array, int k) {

        int index = Arrays.binarySearch(array, k);
        if (index < 0) return 0;
        int cnt = 1;
        //右边的
        for (int i = index + 1; i < array.length && array[i] == k; i++)
            cnt++;
        //左边的
        for (int i = index - 1; i >= 0 && array[i] == k; i--)
            cnt++;
        return cnt;
    }





    //手写二分查找
    /*
   思路分析：
   1，找到mid值，不要马上返回
   2，向mid索引值的左边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
   3, 向mid索引值的右边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
   4，将ArrayList返回
    */
    public int getNumberOfK3(int[] array, int k) {

        List resIndex = new ArrayList<>();

        resIndex = binarySearch2(array, 0, array.length - 1, k);
        return  resIndex.size();

    }


    public List binarySearch2(int[] arr, int left, int right, int findVal) {

        //当left > right 时说明递归整个数组，但是没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            //向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            //向右递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            //1，找到mid值，不要马上返回
            //  2，向mid索引值的左边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
            //  3, 向mid索引值的右边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
            //    4，将ArrayList返回
            List<Integer> resIndexList = new ArrayList<>();

            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                //否则，就temp放入resIndexList
                resIndexList.add(temp);
                temp -= 1;//temp左移
            }
            resIndexList.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                //否则，就temp放入resIndexList
                resIndexList.add(temp);
                temp += 1;//temp右移
            }
            return resIndexList;
        }

    }


    public static void main(String[] args) {

        GetNumberOfK37 getNumberOfK36 = new GetNumberOfK37();

        int[] array = {0, 0, 0, 1, 2, 3, 4, 4, 5, 5, 5, 5, 6};

        int res1 = getNumberOfK36.getNumberOfK(array, 5);
        int res2 = getNumberOfK36.getNumberOfK2(array, 5);
        int res3 = getNumberOfK36.getNumberOfK3(array, 5);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);

    }
}
