import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

class Q480 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.medianSlidingWindow(nums, k)));
    }
}

class Solution {
    PriorityQueue<Long> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Long> right = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        if (len <= 0) {
            return new double[0];
        }
        double[] result = new double[len];

        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                result[i - k] = getMedian();
                remove(nums[i - k]);
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }
        return result;
    }

    public void add(int x) {
        right.add((long) x);
        left.add(right.poll());
        if (right.size() < left.size()) {
            right.add(left.poll());
        }
    }

    public void remove(int x) {
        if (x < getMedian()) {
            left.remove((long) x);
        } else {
            right.remove((long) x);
        }
        if (right.size() < left.size()) {
            right.add(left.poll());
        } else if (right.size() - left.size() > 1) {
            left.add(right.poll());
        }
    }

    public double getMedian() {
        if (right.size() > left.size()) {
            return right.peek();
        } else {
            return (right.peek() + left.peek()) / 2.0;
        }
    }
}
