package com.xuyang.leetcode.programmerInterviewGoldStandard;

/**
 * @author Li Xuyang
 * @date 2020/8/19 21:54
 * 面试题 02.06. 回文链表
 */
public class IsPalindrome0206 {
    //编写一个函数，检查输入的链表是否是回文的。
    //网易互娱，面试算法题
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        //中间结点
        ListNode midNode = findMidNode(head);
        ListNode secondHalfHead = reverseLinked(midNode.next);
        ListNode curr1 = head;
        ListNode curr2 = secondHalfHead;
        boolean palindrome = true;
        while (palindrome && curr2 != null) {
            if (curr1.val != curr2.val) {
                palindrome = false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return palindrome;
    }

    //反转链表
    private ListNode reverseLinked(ListNode head) {
        ListNode cur = head;//用于遍历
        ListNode per = null;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = per;
            per = cur;
            cur = nextNode;
        }

        return per;
    }

    //快慢指针寻找中间结点
    private ListNode findMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
