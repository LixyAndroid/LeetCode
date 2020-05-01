package com.xuyang.leetcode.dynamicProgramming;

import java.util.HashMap;

/**
 * @author Li Xuyang
 * @date 2020/5/1 09:55
 * 连续的子数组和
 */
public class CheckSubarraySum0523 {

    /*
    给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，
    其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
     */


    //方法1：暴力 [Time Limited Exceeded]
    //暴力方法是很显然的。我们考虑所有长度大于等于 2 的子数组，
    // 我们将子数组遍历一遍求和，并判断和是否是给定整数 k 的倍数。
    public boolean checkSubarraySum(int[] nums, int k) {

        for (int start = 0; start <nums.length-1 ; start++) {
            for (int end = start-1; end < nums.length; end++) {

                int sum =0;
                for (int i = 0; i < end; i++) {
                    sum+=nums[i];
                }

                if (sum==k||(k!=0&&sum%k==0)){
                    return true;
                }


            }

        }
        return false;
    }

    /*
    方法 2：优化的暴力 [Accepted]
算法

我们可以在某种程度上优化暴力算法。
如果我们用一个额外的 sum 数组保存数组的累积和，那么 sum[i] 保存着到第 i 个元素位置的前缀和。

因为，就如前面所述，我们考虑每一个子数组并求它的和。
但是与刚刚不同的是，我们不会遍历整个子数组来求和，我们只需要使用数组的前缀和。
因此，求第 i 个数到第 j 个数，我们只需要求出 sum[j]−sum[i]+nums[i] 。

     */
    public boolean checkSubarraySum2(int[] nums, int k) {

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum[i]=sum[i-1]+nums[i];
        }

        for (int start = 0; start < nums.length; start++) {
            for (int end = start+1; end < nums.length; end++) {
                int summ =sum[end]-sum[start]+nums[start];
                if (summ==k||(k!=0&&summ%k==0)){
                    return true;
                }
            }
        }
        return false;
    }

    /*
    方法 3： 使用 HashMap [Accepted]
算法

在这种方法中，我们使用 HashMap 来保存到第 i 个元素为止的累积和，但我们对这个前缀和除以 k取余数。原因如下：

我们遍历一遍给定的数组，记录到当前位置为止的 sum 。一旦我们找到新的 sum 的值（即在 HashMap 中没有这个值），我们就往 HashMap 中插入一条记录 (sum%k, i)。

现在，假设第 i 个位置的 sum 的值为 rem 。如果以i 为左端点的任何子数组的和是 k 的倍数，比方说这个位置为 j ，那么 HashMap 中第 j 个元素保存的值为 (rem+n∗k)%k ，其中 n 是某个大于 0 的整数。我们会发现 (rem + n*k)\%k = rem ，也就是跟第 i 个元素保存到 HashMap 中的值相同。

基于这一观察，我们得出结论：无论何时，只要 sum 的值已经被放入 HashMap 中了，代表着有两个索引 i 和 j ，它们之间元素的和是 k 的整数倍。因此，只要 HashMap 中有相同的 sum ，我们就可以直接返回 True 。


     */
    public boolean checkSubarraySum3(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        for (int i = 0; i < nums.length; i++) {

            sum+=nums[i];
            if (k!=0){
                sum = sum%k;
            }

            if (map.containsKey(sum)){
                if (i-map.get(sum)>1){
                    return true;
                }
            }else {
                map.put(sum,i);
            }
        }
        return false;
    }
}
