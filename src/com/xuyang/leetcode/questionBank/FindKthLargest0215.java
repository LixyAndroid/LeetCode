package com.xuyang.leetcode.questionBank;


import java.util.PriorityQueue;
import java.util.Random;


/**
 * @author Li Xuyang
 * @date 2020/8/25 22:01
 * 数组中的第K个最大元素
 */
public class FindKthLargest0215 {

    //在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums, l, q - 1, index);
        }

    }

    private int randomPartition(int[] nums, int l, int r) {

        int i = random.nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int x = nums[r], i = l - 1;
        for (int j = l; j < r; j++) {

            if (nums[j] <= x) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //基于堆排序
    public int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    //最小值堆
    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> n1-n2);
        for (int num:nums){
            heap.add(num);
            if (heap.size()>k){
                heap.poll();
            }
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        FindKthLargest0215 findKthLargest = new FindKthLargest0215();
        int arr[] = {1, 10, 45, 6, 45, 7, 9, 2, 12};
        int res1 = findKthLargest.findKthLargest(arr, 3);
        System.out.println(res1);
    }
}
