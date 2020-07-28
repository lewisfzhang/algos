class Solution {
    public int countSquares(int[][] mat) {
        int sum = 0, m = mat.length, n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (mat[i-1][j-1] != 0) {
                    sum += (dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1);
                }
            }
        }
        return sum;
    }
}
