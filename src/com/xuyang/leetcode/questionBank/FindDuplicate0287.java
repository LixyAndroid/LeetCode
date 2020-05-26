package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/5/26 21:49
 * 寻找重复数
 */
public class FindDuplicate0287 {

    //给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
    // 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。


    //需要一个数组cnt[i]表示，nums中的数小于等于i有多少个
    /*
如果测试用例的数组中 target 出现了两次，其余的数各出现了一次，这个时候肯定满足上文提及的性质，
因为小于 target 的数 i 满足 cnt[i]=i，大于等于 target 的数 j 满足 cnt[j]=j+1。

如果测试用例的数组中 target 出现了三次及以上，那么必然有一些数不在 nums[] 数组中了，
这个时候相当于我们用 target 去替换了这些数，我们考虑替换的时候对 cnt[] 数组的影响。如果替换的数 i 小于 target ，那么 [i,target−1] 的 cnt 值均减一，其他不变，满足条件。
如果替换的数 j 大于等于 target，那么 [target,j−1] 的 cnt 值均加一，其他不变，亦满足条件。

     */
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i]<=mid){
                    cnt++;
                }
            }

            if (cnt<=mid){
                l = mid+1;
            }else {
                r = mid-1;
                ans = mid;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {1,5,2,3,6,3,4};
        FindDuplicate0287 findDuplicate0287 = new FindDuplicate0287();
        int res = findDuplicate0287.findDuplicate(nums);
        System.out.println(res);
    }
}
