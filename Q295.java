import java.util.PriorityQueue;

public class Q295 {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}

class MedianFinder {
    private PriorityQueue<Long> left, right;
    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>(); // max heap
        right = new PriorityQueue<>(); // min heap
    }

    public void addNum(int num) {
        right.add((long) num);
        left.add(-right.poll());
        if (right.size() < left.size()) {
            right.add(-left.poll());
        }
    }

    public double findMedian() {
        if (right.size() > left.size()) {
            return right.peek();
        } else {
            return (right.peek() - left.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
