public class Q328 {
    public static void main(String[] args) throws Exception {
        ListNode in1 = ListNode.LN(1, 2, 3, 4, 5);
        System.out.println(oddEvenList2(in1));

        ListNode in2 = ListNode.LN(2, 1, 3, 5, 6, 4, 7);
        System.out.println(oddEvenList2(in2));

        ListNode in3 = ListNode.LN(1,2,3,4,5,6,7,8);
        System.out.println(oddEvenList2(in3));
    }
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode tmp = head.next;
        boolean isOdd = true;
        while (tmp != null && tmp.next != null) {
            tmp = tmp.next;
            if (isOdd) {
                odd.next = tmp;
                odd = odd.next;
            } else {
                even.next = tmp;
                even = even.next;
            }
            isOdd = !isOdd;
        }
        even.next = null;
        odd.next = evenHead;
        return head;
    }
    public static ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    // ===== HELPER FUNCTIONS =====
    static ListNode LN(Integer... args) {
        ListNode ln = new ListNode(0);
        ListNode tmp = ln;
        for (int x : args) {
            tmp.next = new ListNode(x);
            tmp = tmp.next;
        }
        return ln.next;
    }

    @Override
    public String toString() {
        ListNode tmp = this.next;
        String s = "" + this.val;
        while (tmp != null) {
            s += "->" + tmp.val;
            tmp = tmp.next;
        }
        return s;
    }
}
