package com.xuyang.leetcode.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Li Xuyang
 * date  2019/7/23 22:20
 *
 *
 * 三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 去重是这题的难点
 *
 */
public class Solution {


//    /**
//     * 暴力法，而且还没满足要求，不能重复
//     * @param nums
//     * @return
//     */
//
//    public static List<List<Integer>> threeSum(int[] nums) {
//
//        List<List<Integer>> Sum = new ArrayList<>();
//
//
//        for (int i = 0; i < nums.length; i++) {
//
//            for (int j = i + 1; j < nums.length; j++) {
//
//                for (int k = j + 1; k < nums.length; k++) {
//                    List<Integer> result = new ArrayList();
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//
//                        result.add(nums[i]);
//                        result.add(nums[j]);
//                        result.add(nums[k]);
//                        Sum.add(result);
//                    }
//
//
//                }
//
//            }
//
//
//        }
//
//        return Sum;
//
//    }


    //先排序，在进行计算，减少了时间复杂度，是个好方法

    /**
     * 转换为双指针思想：
     * <p>
     * 排序;
     * 确定a，寻找 a + b + c = 0;
     * 双指针即为 b, c;
     * 注意手动去重；因为确定三数和为0，那么a>0即可提前结束；
     *
     * @param nums
     * @return
     */

//    public static List<List<Integer>> threeSum(int[] nums) {
//
//        //定义返回的值 result
//        List<List<Integer>> result = new ArrayList<>();
//
//        if (nums.length == 0) {
//            return result;
//        }
//
//
//        //Java的Arrays类中有一个sort()方法，
//        // 该方法是Arrays类的静态方法，在需要对数组进行排序时，非常的好用。
//        //默认为增序，减序需要处理
//        Arrays.sort(nums);
//
//        //遍历增序后的数组
//        for (int i = 0; i < nums.length; i++) {
//
//            if (nums[i] > 0) {
//                break;
//            }
//
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//
//            int m = i + 1, n = nums.length - 1;
//
//
//            //m<n 确保按照顺序来
//            while (m < n) {
//
//                if (n < nums.length - 1 && nums[n] == nums[n + 1] || nums[i] + nums[m] + nums[n] > 0) {
//                    n--;  //此处说明第n位置上数太大,没有可以满足的,所以需要--,但是 nums[n] == nums[n + 1] 还不是很懂? 下同 就是不要重复的,两个排序完重复的
//                } else if (m > i + 1 && nums[m] == nums[m - 1] || nums[i] + nums[m] + nums[n] < 0) {
//                    m++; //此处说明第m位置上数太大,没有可以满足的,所以需要++
//                } else {
//                    //这里和我的很相似，但是他判断了重复的问题，且减少了时间复杂度，说明方法没错
//                    List<Integer> list = new ArrayList<>();
//                    list.add(nums[i]);
//                    list.add(nums[m++]);
//                    list.add(nums[n--]);
//                    result.add(list);
//                }
//            }
//        }
//        return result;
//    }


    public static List<List<Integer>> threeSum(int[] nums) {
        //先排序
        Arrays.sort(nums);
        //定义返回的结果
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {//nums[i] != nums[i-1] 去重
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0) {
                        //满足条件就添加
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;//去重
                        l++;
                        r--;
                    } else if (sum > 0) {
                        while (l < r && nums[r] == nums[r - 1]) r--;//去重
                        r--;
                    } else {
                        while (l < r && nums[l] == nums[l + 1]) l++;//去重
                        l++;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> Sum = threeSum(nums);

        System.out.println(Sum);

    }

}
