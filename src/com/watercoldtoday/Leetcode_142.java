package com.watercoldtoday;

import java.util.List;

/**
 *  142. 环形链表 II
 *  https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class Leetcode_142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //快慢指针法
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode intersect = getIntersect(head);
        if (intersect == null) return null;

        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        // 2(F + a) = F + N(a+b) + a;
        // 2F + 2a = F + 2a + b + (N-1) (a+b);
        // F = b + (N-1) (a+b);
        // F为起点到达入口点的长度，N为ptr2跑第几圈与ptr1相遇
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    public ListNode getIntersect(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //遇到了环
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
