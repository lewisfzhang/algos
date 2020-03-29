import java.util.PriorityQueue;

class Q502 {
    public static void main(String[] args) {
        int k = 2, W = 0;
        int[] profit = {1, 2, 3}, capital = {0, 1, 1};
        Solution s = new Solution();
        System.out.println(s.findMaximizedCapital(k, W, profit, capital));
    }
}

class Solution {
    PriorityQueue<int[]> c = new PriorityQueue<>((x, y) -> x[1] - y[1]); // min heap
    PriorityQueue<int[]> p = new PriorityQueue<>((x, y) -> y[0] - x[0]); // max heap
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        assert Profits.length == Capital.length;
        for (int i = 0; i < Capital.length; i++) {
            c.add(new int[]{Profits[i], Capital[i]});
        }

        while (k-- > 0) {
            while (!c.isEmpty() && c.peek()[1] <= W) {
                p.add(c.poll());
            }
            if (p.isEmpty()) {
                break;
            }
            W += p.poll()[0];
        }
        return W;
    }
}
