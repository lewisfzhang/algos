import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class Q23 {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode[] in = new ListNode[3];
        in[0] = ListNode.ln(new int[]{1, 4, 5});
        in[1] = ListNode.ln(new int[]{1, 3, 4});
        in[2] = ListNode.ln(new int[]{2, 6});
        System.out.println(s.mergeKLists(in));
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>((ListNode l1, ListNode l2) -> l1.val - l2.val);
        for (ListNode node : lists) {
            if (node != null) q.offer(node);
        }

        ListNode node = new ListNode(0), idx = node;
        while (!q.isEmpty()) {
            ListNode ln = q.poll();
            if (ln.next != null) q.offer(ln.next);
            idx.next = ln;
            idx = idx.next;
        }
        return node.next;
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
