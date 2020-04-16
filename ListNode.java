class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    static ListNode ln(int[] arr) {
        ListNode ln = new ListNode(0);
        ListNode pos = ln;
        for (int x : arr) {
            pos.next = new ListNode(x);
            pos = pos.next;
        }
        return ln.next;
    }

    @Override
    public String toString() {
        String s = ""+val;
        ListNode node = next;
        while (node != null) {
            s += "->"+node.val;
            node = node.next;
        }
        return s;
    }
}
