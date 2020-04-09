import java.util.ArrayList;

public class Q62 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int m1 = 3, n1 = 2;
        System.out.println(s.uniquePaths(m1, n1));

        int m2 = 7, n2 = 3;
        System.out.println(s.uniquePaths(m2, n2));

        System.out.println(s.uniquePaths(10, 10));
        System.out.println(s.uniquePaths(23, 12));
    }
}

class Solution {
    // note DP is faster than computing factorial
    // since it is guarenteed O(mn) complexity
    public int uniquePaths(int m, int n) {
        // long x = factorial(m + n - 2);
        // x /= factorial(m - 1) * factorial(n - 1);
        // return (int) x;
        // paths = new int[m][n];
        // return helper(0, 0, m - 1, n - 1);

        int[][] paths = new int[m][n];
        paths[m-1][n-1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i > 0) paths[i - 1][j] += paths[i][j];
                if (j > 0) paths[i][j - 1] += paths[i][j];
            }
        }
        return paths[0][0];
    }

    // private int helper(int i, int j, int m, int n) {
    //     if (i == m || j == n) return 1;
    //     int right = (paths[i][j] > 0) ? paths[i][j] : helper(i + 1, j, m, n);
    //     int down = (paths[i][j] > 0) ? paths[i][j] : helper(i, j + 1, m, n);
    //     return right + down;
    // }
    //
    // private int[][] paths;
    // private ArrayList<Long> factorials = new ArrayList<>();
    // public Solution() {
    //     factorials.add((long) 1);
    // }
    //
    // private long factorial(int x) {
    //     for (int idx = factorials.size(); idx <= x; idx++) {
    //         factorials.add(idx * factorials.get(idx - 1));
    //     }
    //     return factorials.get(x);
    // }
}
