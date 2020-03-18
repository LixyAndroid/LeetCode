package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/18 23:03
 * 二叉搜索树的后序遍历序列
 */
public class VerifySquenceOfBST22 {

    /*
   二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
   若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
   若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
   后序遍历为左右根
   */
    public static boolean verifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length ==0){
            return false;
        }
        return helpVerify(sequence,0,sequence.length-1);
    }

    public static  boolean helpVerify(int [] sequence,int start,int root) {
        if(start>root)return true;

        int key = sequence[root];
        int i;

        //找到左右结点的分界点
        for(i=start;i<root;i++){
            if(sequence[i]>key){
                break;
            }
        }

        //在右子树中判断是否含有小于root的值，如果有返回false
        for(int j =i; j<root; j++){
            if(sequence[j]<key){
                return false;
            }
        }

        return helpVerify(sequence,0,i-1)&&helpVerify(sequence,i,root-1);



    }


    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。
     *
     * @param sequence 某二叉搜索树的后序遍历的结果
     * @return true：该数组是某二叉搜索树的后序遍历的结果。false：不是
     */
    public static boolean verifySquenceOfBST2(int[] sequence) {

        // 输入的数组不能为空，并且有数据
        if (sequence == null || sequence.length <= 0) {
            return false;
        }

        // 有数据，就调用辅助方法
        return helpVerify2(sequence, 0, sequence.length - 1);
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 【此方法与上一个方法不同，未进行空值判断，对于数组度为0的情况返回的true也于上题不同，
     * 此方法只是上面一个方法的辅助实现，对于数数组为null和数组长度为0的情况，执行结果并非相同】
     * 【也就是说此方法只有数组中有数据的情况下才与上面的方法返回同样的结点，
     * verifySequenceOfBST(sequence) ===
     * verifySequenceOfBST(sequence, 0, sequence.length - 1)
     * 当sequence中有数据才成立
     * 】
     *
     * @param sequence 某二叉搜索树的后序遍历的结果
     * @param start    处理的开始位置
     * @param end      处理的结束位置
     * @return true：该数组是某二叉搜索树的后序遍历的结果。false：不是
     */
    public static boolean helpVerify2(int[] sequence, int start, int end) {

        // 如果对应要处理的数据只有一个或者已经没有数据要处理（start>end）就返回true
        if (start >= end) {
            return true;
        }

        // 从左向右找第一个不大于根结点（sequence[end]）的元素的位置
        int index = start;
        while (index < end - 1 && sequence[index] < sequence[end]) {
            index++;
        }

        // 执行到此处[end, index-1]的元素都是小于根结点的（sequence[end]）
        // [end, index-1]可以看作是根结点的左子树

        // right用于记录第一个不小于根结点的元素的位置

        int right = index;

        // 接下来要保证[index, end-1]的所有元素都是大于根根点的【A】
        // 因为[index, end-1]只有成为根结点的右子树
        // 从第一个不小于根结点的元素开始，找第一个不大于根结点的元素
        while (index < end - 1 && sequence[index] > sequence[end]) {
            index++;
        }

        // 如果【A】条件满足，那么一定有index=end-1，
        // 如果不满足那说明根结点的右子树[index, end-1]中有小于等于根结点的元素，
        // 不符合二叉搜索树的定义，返回false
        if (index != end - 1) {
            return false;
        }

        // 执行到此处说明直到目前为止，还是合法的
        // [start, index-1]为根结点左子树的位置
        // [index, end-1]为根结点右子树的位置
        index = right;
        return helpVerify2(sequence, start, index - 1) && helpVerify2(sequence, index, end - 1);
    }


    public static void main(String[] args) {
        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + verifySquenceOfBST(data));
        System.out.println("true2: " + verifySquenceOfBST2(data));

        //           5
        //          / \
        //         4   7
        //            /
        //           6
        int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + verifySquenceOfBST(data2));
        System.out.println("true2: " + verifySquenceOfBST2(data2));

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + verifySquenceOfBST(data3));

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + verifySquenceOfBST(data4));

        // 树中只有1个结点
        int[] data5 = {5};
        System.out.println("true: " + verifySquenceOfBST(data5));

        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + verifySquenceOfBST(data6));

        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + verifySquenceOfBST(data7));
    }


}
