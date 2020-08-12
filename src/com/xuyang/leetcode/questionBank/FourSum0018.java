package com.xuyang.leetcode.questionBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/8/12 16:43
 * 四数之和
 */
public class FourSum0018 {
    //给定一个包含n 个整数的数组nums和一个目标值target，
    // 判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
    //答案中不可以包含重复的四元组。
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //当数组为null或者小于4个时候，直接返回
        if (nums == null || nums.length < 4) {
            return result;
        }

        //对数组进行从小到大排序
        Arrays.sort(nums);
        //数组长度
        int length = nums.length;
        //定义4个指针k,i,j,h,k从0开始遍历，i从k+1开始，留下j和h,j指向i+1,h指向数组最大值
        for (int k = 0; k < length - 3; k++) {
            //当k的值与前面的值相等时，忽略
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            //获取当前最小值，如果最小值比目标值大，说明后面越大的值根本没戏
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                break;
            }

            //获取当前最大值，如果最大值比目标值小，说明后面越小的值根本没戏
            int max1 = nums[k] + nums[length - 3] + nums[length - 2] + nums[length - 1];
            if (max1 < target) {
                continue;
            }

            //第二层循环i,初始值指向k+1
            for (int i = k + 1; i < length - 2; i++) {
                //当i的值与前面的值相等的忽略
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }

                //定义指针j指向i+1
                int j = i + 1;
                //定义指针h指向数组末尾
                int h = length - 1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) {
                    break;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }

                //开始j h指针的表演，计算当前和，如果等于目标值，j++，h--去重
                // 当当前和大于目标值时h--，当当前和小于目标值时j++
                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && i < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }

            }


        }
        return result;

    }
}
