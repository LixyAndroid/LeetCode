package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/27 13:37
 * 两个链表的第一个公共结点
 */
public class FindFirstCommonNode36 {

    //输入两个链表，找出它们的第一个公共结点。
    // （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
    //不错的思路
    /*
    下面的链表例子：
    0-1-2-3-4-5-null
    a-b-4-5-null
    代码的ifelse语句，对于某个指针p1来说，其实就是让它跑了连接好的的链表，长度就变成一样了。
    如果有公共结点，那么指针一起走到末尾的部分，也就一定会重叠。看看下面指针的路径吧。
    p1： 0-1-2-3-4-5-null(此时遇到ifelse)-a-b-4-5-null
    p2: a-b-4-5-null(此时遇到ifelse)0-1-2-3-4-5-null
    因此，两个指针所要遍历的链表就长度一样了！
    如果两个链表存在公共结点，那么p1就是该结点，如果不存在那么p1将会是null。
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;

            //这里保证遍历的链表的长度是相等的，就是两者相加，所以有公共结点的时候就找到了
            if(p1!=p2){
                if(p1==null){
                    p1 = pHead2;
                }
                if(p2 ==null){
                    p2 = pHead1;
                }
            }
        }
        return p1;

    }
}
