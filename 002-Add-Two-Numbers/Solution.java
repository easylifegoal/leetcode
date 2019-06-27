/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * pay attention to the carry
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l1.next == null) return l2;
        if (l2.val == 0 && l2.next == null) return l1;

        ListNode head = l1;
        ListNode pre = null;
        int h = 0;
        int num = 0;
        while (l1 != null && l2 != null) {
            num = l1.val + l2.val + h;
            if (num < 10) {
                h = 0;
                l1.val = num;
            } else {
                h = 1;
                l1.val = num - 10;
            }
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null && h == 1) {
            ListNode node = new ListNode(h);
            pre.next = node;
            h = 0;
            return head;
        }

        if (l1 == null) pre.next = l2;
        ListNode pos = pre.next;
        while (h == 1) {
            if(pos == null) {
                pos = new ListNode(0);
                pre.next = pos;
            }
            num = pos.val + h;
            h = 0;
            if (num > 9) {
                h = 1;
                num = num - 10;
            }
            pos.val = num;
            pre = pos;
            pos = pos.next;
        }
        return head;
    }
}
