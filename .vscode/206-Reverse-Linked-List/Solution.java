/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode pre = null;
        ListNode temp;
        while(head != null) {
            temp = pre;
            pre = head;
            head = head.next;
            pre.next = temp;
        }
        return pre;
    }
}
