/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * for-loop solution
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode head = merge(lists[0], lists[1]);

        for (int i = 2; i < lists.length; i++) {
            head = merge(head, lists[i]);
        }
        return head;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode pos = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pos.next = l1;
                l1 = l1.next;
            } else {
                pos.next = l2;
                l2 = l2.next;
            }
            pos = pos.next;
        }

        if (l1 == null) pos.next = l2;
        if (l2 == null) pos.next = l1;
        return head;
    }
}

/**
 * divition solution
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return partion(lists, 0, lists.length - 1);
    }

    public ListNode partion(ListNode[] lists, int start, int end) {
        if (start >= end) return lists[start];

        int mid = (end + start) / 2;
        ListNode l1 = partion(lists, start, mid);
        ListNode l2 = partion(lists, mid + 1, end);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode pos = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pos.next = l1;
                l1 = l1.next;
            } else {
                pos.next = l2;
                l2 = l2.next;
            }
            pos = pos.next;
        }

        if (l1 == null) pos.next = l2;
        if (l2 == null) pos.next = l1;
        return head;
    }
}
