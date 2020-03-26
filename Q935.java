import java.util.Arrays;

public class Q935 {
    public static void main(String[] args) {
        assert knightDialer3(1) == 10;
        assert knightDialer3(2) == 20;
        assert knightDialer3(3) == 46;
    }

    final static int mod = 1000000007; // 10^9 + 7
    final static int[][] path = new int[][]{{4, 6},
                                            {6, 8},
                                            {7, 9},
                                            {4, 8},
                                            {0, 3, 9},
                                            {},
                                            {0, 1, 7},
                                            {2, 6},
                                            {1, 3},
                                            {2, 4}};

    // INEFFICIENT --> exponential computation
    // no ways to jump to itself --> no instances of overcounting!
    public static int knightDialer(int N) {
        assert N > 0;
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + recursive(N - 1, i)) % mod;
        }
        return sum;
    }

    public static int recursive(int N, int x) {
        if (N == 0) {
            return 1;
        }
        int sum = 0;
        for (int next : path[x]) {
            sum = (sum + recursive(N - 1, next)) % mod;
        }
        return sum;
    }

    // takes into account subproblems! --> still times out :((
    public static int knightDialer2(int N) {
        int[][][] paths = new int[4][3][N];
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                sum = (sum + recursive(N - 1, i, j, paths)) % mod;
            }
        }
        return sum;
    }

    // PROBLEM: STILL RECURSIVELY CALLS ALL LOWER STEPS N-1, even though computation reduced
    public static int recursive(int N, int i, int j, int[][][] paths) {
        if (i < 0 || i > 3 || j < 0 || j > 2 || (i == 3 && j != 1)) {
            return 0;
        } else if (N == 0) {
            return 1;
        } else if (paths[i][j][N] > 0) {
            return paths[i][j][N];
        }

        long sum = recursive(N - 1, i - 1, j - 2, paths) % mod
                 + recursive(N - 1, i + 1, j - 2, paths) % mod
                 + recursive(N - 1, i - 1, j + 2, paths) % mod
                 + recursive(N - 1, i + 1, j + 2, paths) % mod
                 + recursive(N - 1, i - 2, j - 1, paths) % mod
                 + recursive(N - 1, i + 2, j - 1, paths) % mod
                 + recursive(N - 1, i - 2, j + 1, paths) % mod
                 + recursive(N - 1, i + 2, j + 1, paths) % mod;
        paths[i][j][N] = (int) (sum % mod);
        return paths[i][j][N];
    }

    // ELIMINATES NEED TO CALL LOWER STEPS EXPONENTIALLY
    // computes from bottom to top, NOT top to bottom
    public static int knightDialer3(int N) {
        assert N > 0;

        final int DIGITS = 10;
        int[] dp = new int[DIGITS];
        Arrays.fill(dp,1);
        int[] dp1 = new int[DIGITS];

        while (--N > 0){
            for (int i = 0; i < DIGITS; i++){
                for (int d : path[i]) {
                    dp1[i] = (dp[d] + dp1[i]) % mod;
                }
            }
            dp = dp1;
            dp1 = new int[DIGITS];
        }

        int sum = 0;
        for(int i = 0; i < DIGITS; i++){
            sum = (sum + dp[i]) % mod;
        }

        return sum;
    }
}
