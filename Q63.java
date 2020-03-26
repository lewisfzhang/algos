public class Q63 {
    public static void main(String[] args) {
        int[][] in = new int[][]{{0, 0, 0},
                               {0, 1, 0},
                               {0, 0, 0}};
        assert uniquePathsWithObstacles(in) == 2;

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                paths[i][j] = (obstacleGrid[i][j] == 1) ? 0 : -1;
            }
        }
        paths[0][0] = 1;
        return dp(m - 1, n - 1, paths);
    }

    public static int dp(int i, int j, int[][] paths) {
        if (paths[i][j] != -1) {
            return paths[i][j];
        }

        paths[i][j] = (i == 0) ? 0 : dp(i - 1, j, paths);
        paths[i][j] += (j == 0) ? 0 : dp(i, j - 1, paths);
        return paths[i][j];
    }
}
