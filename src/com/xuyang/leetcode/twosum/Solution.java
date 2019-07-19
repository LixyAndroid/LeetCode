package com.xuyang.leetcode.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mloong
 * date  2019/7/18 12:40
 */
public class Solution {

    //一般暴力法


//    public static int[] twoSum(int[] nums, int target) {
//
//
//        for (int i = 0; i < nums.length; i++) {
//
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    return new int[]{i, j};
//                }
//            }
//
//        }
//        //非法参数
//        throw new IllegalArgumentException("No two sum solution");
//
//    }


    /*
    方法二：两遍哈希表
        为了对运行时间复杂度进行优化，我们需要一种更有效的方法来检查数组中是否存在目标元素。
        如果存在，我们需要找出它的索引。保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表。

        通过以空间换取速度的方式，我们可以将查找时间从 O(n)O(n) 降低到 O(1)O(1)。
        哈希表正是为此目的而构建的，它支持以 近似 恒定的时间进行快速查找。我用“近似”来描述，是因为一旦出现冲突，查找用时可能会退化到 O(n)O(n)。但只要你仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)O(1)。

        一个简单的实现使用了两次迭代。在第一次迭代中，我们将每个元素的值和它的索引添加到表中。
        然后，在第二次迭代中，我们将检查每个元素所对应的目标元素（target - nums[i]target−nums[i]）是否存在于表中。注意，该目标元素不能是 nums[i]nums[i] 本身！



        public V get(Object key)返回到指定键所映射的值，或null如果此映射包含该键的映射。
        更正式地，如果该映射包含从键k到值v ，使得(key==null ? k==null : key.equals(k)) ，则该方法返回v ; 否则返回null 。 （最多可以有一个这样的映射。）

        返回值null并不一定表示该映射不包含该键的映射; 地图也可能明确地将密钥映射到null 。 可以使用containsKey操作来区分这两种情况。

        Specified by:
        get在界面 Map<K,V>
        重写：
        get在类别 AbstractMap<K,V>
        参数
        key - 要返回其关联值的键
        结果
        指定键映射到的值，如果此映射不包含键的映射， null
     */
//    public static int[] twoSum(int[] nums, int target) {
//
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement) && map.get(complement) != i) {
//                return new int[] { i, map.get(complement) };
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//
//
//    }

    /*
            方法三：一遍哈希表
            事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
            如果它存在，那我们已经找到了对应解，并立即将其返回。

                public V put(K key,V value)
                将指定的值与此映射中的指定键相关联。 如果地图先前包含了该键的映射，则替换旧值。
                Specified by:
                put在界面 Map<K,V>
                重写：
                put在类别 AbstractMap<K,V>
                参数
                key - 指定值与之关联的键
                value - 与指定键相关联的值
                结果
                前一个值与key相关联 ，或null如果没有key的映射。 （A null返回也可以指示以前关联的地图null与key。 ）

     */


    public static int[] twoSum(int[] nums, int target) {


        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {

                return new int[]{map.get(complement), i};

            }
            map.put(nums[i], i);
        }

        //否则就抛出非法参数异常，不要用全局变量
        throw new IllegalArgumentException("No two sum solution");

    }

    //我的方法,测试没错就是执行不了，很奇怪  , 疑似全局变量的问题？
    public static int[] twoSumByxuyang(int[] nums, int target) {

        int[] index = {0,0};

        int j = 0;

        for (int i = 0; i <nums.length ; i++) {

            if (i != j){

                if (target == nums[i]+nums[j]){

                    index[0] = j;
                    index[1] = i;
                }
                j++;
            }

        }

        return index;

    }


    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 18;

        int[] index = twoSumByxuyang(nums, target);

        for (int i = 0; i < index.length; i++) {

            System.out.println(index[i]);
        }


    }


}
