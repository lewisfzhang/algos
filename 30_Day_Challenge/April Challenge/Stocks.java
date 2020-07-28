public class Stocks {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] in = {7,1,5,3,6,4};
        System.out.println(s.maxProfit2(in));

        in = new int[]{1,2,3,4,5};
        System.out.println(s.maxProfit2(in));

        in = new int[]{7,6,4,3,1};
        System.out.println(s.maxProfit2(in));

    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;
        // inital = buy date
        int sum = 0, initial = prices[0], last = prices[0], curr;
        for (int i = 1; i < prices.length; i++) {
            curr = prices[i];
            if (last > curr) {
                sum += last - initial;
                initial = curr;
            }
            last = curr;
        }
        return (last > initial) ? sum + last - initial : sum;
    }
    public int maxProfit2(int[] prices) {
        int sum = 0, pre = prices[0]; // assume price is positive
        for (int x : prices) {
            sum += (x > pre) ? x - pre : 0;
            pre = x;
        }
        return sum;
    }
}
