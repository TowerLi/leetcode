package com.watercoldtoday;



public class Day20200426 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x ) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int abcd = 0;
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1,l2,l3};

        ListNode ans = mergeKLists(lists);
        System.out.println(ans);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans,lists[i]);
        }
        return ans;
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null ) return a == null ? b : a;
        ListNode head = null,tail = head,aPtr = a,bPtr = b;
        while (aPtr != null || bPtr != null) {
            if (aPtr.val <= bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr == null) ? bPtr : aPtr;
        return head.next;
    }

    public ListNode merge2Lists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }

        if (a.val <= b.val)  {
            a.next = merge2Lists(a.next, b);
            return  a;
        } else {
            b.next = merge2Lists(a, b.next);
            return b;
        }
    }
}
