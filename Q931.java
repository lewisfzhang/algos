import java.lang.Math;

public class Q931 {
    public static void main(String[] args) throws Exception {
        int[][] in = new int[][]{{1, 2, 3},
                                 {4, 5, 6},
                                 {7, 8, 9}};
        if (minFallingPathSum(in) != 12) throw new Exception();
    }
    public static int minFallingPathSum(int[][] A) {
        assert A.length > 0 && A[0].length > 0;

        int min, leftJ, rightJ;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                // CLEAN ABSTRACTED VERSION
                A[i][j] += helper(A, i, j);

                // LESS MEMORY VERSION
                // min = Integer.MAX_VALUE;
                // leftJ = Math.max(0, j - 1);
                // rightJ = Math.min(A.length - 1, j + 1);
                // for (int x = leftJ; x <= rightJ; x++) {
                //     min = Math.min(min, A[i - 1][x]);
                // }
                // A[i][j] += min;
            }
        }

        min = Integer.MAX_VALUE;
        for (int x : A[A.length - 1]) {
            min = Math.min(min, x);
        }
        return min;
    }
    public static int helper(int[][] A, int i, int j) {
        int leftJ = Math.max(0, j - 1);
        int rightJ = Math.min(A.length - 1, j + 1);
        int sum = Integer.MAX_VALUE;
        for (int x = leftJ; x <= rightJ; x++) {
            sum = Math.min(sum, A[i - 1][x]);
        }
        return sum;
    }
}
