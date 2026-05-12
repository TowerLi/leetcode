package com.watercoldtoday.hot100.listnode;

import com.watercoldtoday.hot100.listnode.common.ListNode;

import java.util.Arrays;

public class ReverseListNode {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }


    public static void main(String[] args) {
        int[] head = {1,2,3,4,5};
        ReverseListNode reverseListNode = new ReverseListNode();
        ListNode ans = reverseListNode.reverseList(ListNode.buildNodeFromArray(head));
        System.out.println(Arrays.toString(ListNode.buildArrayFromListNode(ans)));
    }
}
