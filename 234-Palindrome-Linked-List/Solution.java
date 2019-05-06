/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;

        //reverse
        ListNode slow = head;
        ListNode fast = head;
        ListNode tail = null;
        while (fast != null && fast.next != null) {
            tail = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        tail.next = null;

        ListNode pre = null;
        ListNode temp;
        while (slow != null) {
            temp = slow;
            slow = slow.next;
            temp.next = pre;
            pre = temp;
        }

        //compare
        while (head != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }

        return true;
    }
}
