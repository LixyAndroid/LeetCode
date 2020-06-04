package com.xuyang.leetcode.questionBank;


import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/6/4 23:03
 * 除自身以外数组的乘积
 */
public class ProductExceptSelf0238 {

    //给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

    //时间复杂度过高，超时
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i!=j){
                    res[i] *= nums[j];

                }
            }

        }
        return  res;
    }
    /*
    左边乘积*右边乘积
     */

    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new  int[length];

        int[] answer = new  int[length];

        //L[i]为索引i左侧的所有元素乘积
        //0索引，左侧没有元素，所以L[0] =1;
        L[0]=1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i-1]*L[i-1];
        }

        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;

    }

    public int[] productExceptSelf3(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }

        public static void main(String[] args) {
        ProductExceptSelf0238 productExceptSelf0238 = new ProductExceptSelf0238();
        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf0238.productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }
}
