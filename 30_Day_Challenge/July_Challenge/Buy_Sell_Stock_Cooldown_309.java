public class Buy_Sell_Stock_Cooldown_309 {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = Integer.MIN_VALUE, rest = 0;
        for (int i=0; i<prices.length; i++) {
            int lastSold = sell;
            sell = Math.max(buy - prices[i], lastSold);  
            buy = Math.max(buy, rest);
            rest = lastSold + prices[i];
            // lastSold = Integer.MIN_VALUE on first interation so sell = Math.max(-prices[i], min_val)
            // AND rest < buy = 0 on next iteration
        }
        return Math.max(buy, rest); // either sell on last day or do nothing
    }
}