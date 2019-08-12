class LRUCache {
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void delete(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void add(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    HashMap<Integer, Node> map;
    int maxSize;
    Node head, tail;

    public LRUCache(int capacity) {
        maxSize = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        delete(node);
        add(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            delete(node);
            add(node);
            node.value = value;
        } else {
            if (map.size() == maxSize) {
                Node last = tail.prev;
                if (last == head) return;
                map.remove(last.key);
                delete(tail.prev);
            }
            node = new Node(key, value);
            map.put(key, node);
            add(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
