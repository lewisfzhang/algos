import java.util.Stack;
public class Min_Stack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // --> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());     // --> Returns 0.
        System.out.println(minStack.getMin());  // --> Returns -2.
    }
}

class MinStack {

    // private Stack<Integer> stack;
    // private int min;
    private Node head;

    /** initialize your data structure here. */
    public MinStack() {
        // stack = new Stack<>();
        // min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        // stack.push(min); // previous min
        // min = Math.min(min, x);
        // stack.push(x);
        head = (head == null) ? new Node(x, x, null) :
                                new Node(x, Math.min(head.min, x), head);
    }

    public void pop() {
        // stack.pop();
        // min = stack.pop();
        head = head.next;
    }

    public int top() {
        // return stack.peek();
        return head.x;
    }

    public int getMin() {
        // return min;
        return head.min;
    }

    private class Node {
        int x, min;
        Node next;
        Node(int x, int min, Node next) {
            this.x = x;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
