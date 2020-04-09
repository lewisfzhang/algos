public class Q72 {
    public static void main(String[] args) {
        run("horse", "ros");
        run("intention", "execution");
    }

    private static void run(String s1, String s2) {
        System.out.println((new Solution()).minDistance(s1, s2));
    }
}

class Solution {
    // dp = shortest distance between word1[0, i) and word2[0, j)
    // can use 1D array instead of 2D since we only care about previous row
    // however, runtime is still O(mn) for building up the strings
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[] dp = new int[l2 + 1];
        for (int j = 1; j <= l2; j++) dp[j] = j; // number of deletes to get empty string word1[0,0)
        for (int i = 1; i <= l1; i++) {
            int prev = i; // dp[0], assume worst case of i replaces for Math.min
            for (int j = 1; j <= l2; j++) {
                boolean eq = word1.charAt(i - 1) == word2.charAt(j - 1);
                int cur = eq ? dp[j - 1] : Math.min(dp[j - 1], Math.min(prev, dp[j])) + 1;
                dp[j - 1] = prev;
                prev = cur; // 2-stage buffer
            }
            dp[l2] = prev;
        }
        return dp[l2];
    }
}
