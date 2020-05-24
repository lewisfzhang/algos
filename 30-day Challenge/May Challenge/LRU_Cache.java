class LRUCache {
    int capacity;
    HashMap<Integer, Node> data = new HashMap<>();
    Node head = new Node(0, 0), tail = new Node(0, 0); // never touched
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!data.containsKey(key)) return -1;
        Node n = data.get(key);
        remove(n);
        insert(n);
        return n.val;
    }
    
    public void put(int key, int val) {
        if (data.containsKey(key)) remove(data.get(key));
        else if (data.size() == capacity) remove(tail.prev);
        insert(new Node(key, val));
    }
    
    private void remove(Node n) {
        data.remove(n.key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.prev = null; n.next = null; // garbage collection
    }
    
    private void insert(Node n) {
        data.put(n.key, n);
        head.next.prev = n;
        n.next = head.next;
        n.prev = head;
        head.next = n;
    }
    
    private class Node {
        int key, val;
        Node prev, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */