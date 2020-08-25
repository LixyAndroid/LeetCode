package com.xuyang.leetcode.offer3;

import java.util.PriorityQueue;

/**
 * @author Li Xuyang
 * @date 2020/8/25 21:20
 */
public class FindKthLargest {
    //方法1：基于冒泡排序和简单选择排序，时间复杂度o(n*k)
    //我们知道，在冒泡排序和简单选择排序中，最外层的循环每遍历一次，都可以把第i大（或第i小）的数排到数组的最前面，所以我们用这种方法，最外面经过k次遍历之后，就可以找到第k大的数。
    public int findKthLargest(int[] nums, int k) {
        boolean flag = true;
        for (int i = 0; i < k && flag; i++) {
            //经过第i次比较后，可产生第i大的树
            flag = false;
            for (int j = nums.length - 2; j >= i; j--) {
                if (nums[j] < nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = true;
                }
            }

        }
        System.out.println("第" + k + "大的数: " + nums[k - 1]);
        return nums[k - 1];
    }

    //基于选择排序的方法：
    public int findKthLargest2(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            //经过k次交换之后，可以将前k大的树都排到前面
            int max = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[max]) {
                    swap(nums, j, max);
                }
            }

        }
        return nums[k - 1];
    }

    private void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int ele : nums) {
            priorityQueue.add(ele);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int arr[] = {1, 10, 45, 6, 45, 7, 9, 2, 12};
        int res1 = findKthLargest.findKthLargest(arr, 3);
        int res2 = findKthLargest.findKthLargest2(arr, 3);
        int res3 = findKthLargest.findKthLargest3(arr, 3);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);


    }

}
