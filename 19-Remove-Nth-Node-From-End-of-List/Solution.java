/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        int i = 1;
        while (fast != null && i < n) {
            fast = fast.next;
            i++;
        }

        if (fast == null) return head;

        ListNode slow = head;
        ListNode temp = null;
        while (fast.next != null) {
            fast = fast.next;
            temp = slow;
            slow = slow.next;
        }

        if (temp == null) return head.next;

        temp.next = slow.next;
        return head;
    }
}
