package com.xuyang.leetcode.questionBank;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li Xuyang
 * @date 2020/5/27 23:16
 * 和可被 K 整除的子数组
 */
public class SubarraysDivByK0974 {

    //给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。

    //复杂度过高
    public int subarraysDivByK(int[] A, int K) {

        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
           sum = A[i];
           if (sum%K==0){
               cnt++;
           }
           int index = i+1;
           while (index<A.length){
               sum+=A[index];
               if (sum%K==0){
                   cnt++;
               }
               index++;
           }
        }
        return cnt;
    }

    public int subarraysDivByK2(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }



    public int subarraysDivByK3(int[] A, int K) {

        Map<Integer,Integer> record = new HashMap<>();
        record.put(0,1);
        int sum = 0;
        for (int elem:A) {
            sum+=elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int moduls = (sum%K+K)%K;
            record.put(moduls,record.getOrDefault(moduls,0)+1);
        }
        int ans = 0;
        for (Map.Entry<Integer,Integer> entry:record.entrySet()) {
            ans+=entry.getValue()*(entry.getValue()-1)/2;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {4,5,0,-2,-3,1};
        SubarraysDivByK0974 subarraysDivByK0974 = new SubarraysDivByK0974();
        int res = subarraysDivByK0974.subarraysDivByK2(A,5);
        System.out.println(res);
    }
}
