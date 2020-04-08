public class Middle_Node {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode in = ListNode.ln(new int[]{1,2,3,4,5});
        System.out.println(s.middleNode(in).val);

        in = ListNode.ln(new int[]{1,2,3,4,5,6});
        System.out.println(s.middleNode(in).val);
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            head = head.next;
        }
        return head;
    }
}

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
}
