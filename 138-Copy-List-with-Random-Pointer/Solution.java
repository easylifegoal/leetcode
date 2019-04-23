/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node pos = head;
        while (pos != null) {
            Node temp = new Node(pos.val, pos.next, null);
            pos.next = temp;
            pos = temp.next;
        }

        pos = head;
        while (pos != null) {
            if (pos.random != null) pos.next.random = pos.random.next;
            pos = pos.next.next;
        }

        pos = head;
        Node res = pos.next;
        Node pos2 = null;
        while (pos != null) {
            pos2 = pos.next;
            pos.next = pos2.next;
            pos = pos.next;
            if (pos == null) {
                pos2.next = null;
            } else {
                pos2.next = pos.next;
            }
        }

        return res;
    }
}
