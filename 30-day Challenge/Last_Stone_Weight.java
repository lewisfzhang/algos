import java.util.PriorityQueue;
import java.util.Collections;
public class Last_Stone_Weight {
    public static void main(String[] args) {
        System.out.println((new Solution()).lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : stones) pq.offer(x);
        while (pq.size() > 1) {
            int y = pq.poll(), x = pq.poll(); // x <= y
            if (x != y) pq.offer(y - x);
        }
        return (pq.isEmpty()) ? 0 : pq.peek();
    }
}
