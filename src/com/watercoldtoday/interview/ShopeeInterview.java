package com.watercoldtoday.interview;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int v) {
        val = v;
    }
    ListNode(int v, ListNode n) {
        val = v;
        next  = n;
    }
}

public class ShopeeInterview {

    public static void main(String[] args) {
        ShopeeInterview test1 = new ShopeeInterview();
        List<Integer> list = new ArrayList<>();
        ListNode pre = new ListNode(-1);
        ListNode head = new ListNode(1);
        pre.next = head;
        for (int i = 2; i <= 5; ++i) {
            head.next = new ListNode(i);
            head = head.next;
        }
        ListNode rNode = test1.reverseNode(pre.next, 2, 4);
        while (rNode != null) {
            System.out.print(rNode.val+"->");
            if (rNode.next != null) {
                System.out.print("->");
            }
            rNode = rNode.next;
        }
    }

    public ListNode reverseNode(ListNode head,int left, int right) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode pp = new ListNode(-1);
        pp.next = head;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i <= left - 1; ++i) {
            pre.next = new ListNode(list.get(i));
            pre = pre.next;
        }
        for (int i = right - 1; i >= left - 1; --i) {
            pre.next = new ListNode(list.get(i));
            pre = pre.next;
        }
        for (int i = right; i < list.size(); ++i) {
            pre.next = new ListNode(list.get(i));
            pre = pre.next;
        }
        return pre.next;
    }
}
