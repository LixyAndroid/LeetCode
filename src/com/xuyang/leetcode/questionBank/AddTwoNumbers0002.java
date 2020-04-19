package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/4/19 15:08
 * 两数相加
 */
public class AddTwoNumbers0002 {
    /*
        给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    示例：
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 =   807

     */


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    /*
        a. 两条链表相加，返回的结果要求是链表，每次插值的时候都要在链表的尾端添加。
        需要一个返回结果的链表res，需要一个指针，每次添加后都指向最后一个节点。
        b. 如果有进数(两数想和大于十进1)，下次相加时一起加上。
        c. 两条链表长度可能不相等，因此结束循环后，需要判断是否有未遍历完的链表，有则单独遍历，没有则进入下一步。
        d. 当两条链表都遍历结束，还需要判断进数是否为0，为0什么也不做，不为0在运行结果的链表尾部添加值为1的节点。
        c. 最后可以直接返回res链表

        */

        ListNode res = new ListNode(0);

        //就相当于一个指针一样
        ListNode resTemp  = res;
        int nextSum = 0;

        //标识相加进1
        int  flag = 0;

        while(l1!=null&&l2!=null){

            int p;

            if(flag==0){
                p = l1.val+l2.val;
                res.val = p%10;
                nextSum = p/10;
                flag++;

            }else{
                p = l1.val+l2.val+nextSum;
                resTemp.next = new ListNode(p%10);
                resTemp = resTemp.next;
                nextSum = p/10;
            }
            l1 = l1.next;
            l2 =l2.next;
        }

        while(l1!=null){
            int p = l1.val+nextSum;
            resTemp.next = new ListNode(p%10);
            resTemp = resTemp.next;
            nextSum = p/10;
            l1=l1.next;
        }

        while(l2!=null){
            int p = l2.val+nextSum;
            resTemp.next = new ListNode(p%10);
            resTemp = resTemp.next;
            nextSum = p/10;
            l2=l2.next;
        }
        if(nextSum!=0){
            resTemp.next = new ListNode(nextSum);
        }



        return res;
    }

    /*

    就像你在纸上计算两个数字的和那样，我们首先从最低有效位也就是列表 l1 和 l2 的表头开始相加。
    由于每位数字都应当处于 0…9 的范围内，我们计算两个数字的和时可能会出现 “溢出”。例如，5 + 7 = 12。
    在这种情况下，我们会将当前位的数值设置为 2，并将进位 carry=1 带入下一次迭代。
    进位 carry 必定是 0 或 1，这是因为两个数字相加（考虑到进位）可能出现的最大和为 9 + 9 + 1 = 19。

        伪代码如下：

        将当前结点初始化为返回列表的哑结点。
        将进位 carry 初始化为 0。
        将 p 和 q 分别初始化为列表 l1 和 l2 的头部。
        遍历列表 l1 和 l2 直至到达它们的尾端。
        将 x 设为结点 p的值。如果 p 已经到达 l1 的末尾，则将其值设置为 0。
        将 y 设为结点 q 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0。
        设定 sum = x + y + carry。
        更新进位的值，carry = sum / 10。
        创建一个数值为 (sum mod 10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
        同时，将 p 和 q 前进到下一个结点。
        检查 carry = 1 是否成立，如果成立，则向返回列表追加一个含有数字 1 的新结点。
        返回哑结点的下一个结点。
        请注意，我们使用哑结点来简化代码。如果没有哑结点，则必须编写额外的条件语句来初始化表头的值。
     */

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        //进位
        int carry = 0;
        //这样一个while循环可以搞定
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            //可以用除以10 来表示进位，sum小于10  进位就是0
            carry = sum / 10;
            //对10取余就是需要添加的数
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
