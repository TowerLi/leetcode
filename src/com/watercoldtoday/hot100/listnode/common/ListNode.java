package com.watercoldtoday.hot100.listnode.common;

import java.util.ArrayList;
import java.util.List;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int x, ListNode nxt) {
        val = x;
        next = nxt;
    }
    public ListNode(int x) {
        val = x;
        next = null;
    }


    public static ListNode buildNodeFromArray(int[] arrays) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int num : arrays) {
            ListNode temp = new ListNode(num);
            cur.next = temp;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static int[] buildArrayFromListNode(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
