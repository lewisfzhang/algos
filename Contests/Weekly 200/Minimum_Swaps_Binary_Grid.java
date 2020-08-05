public class Minimum_Swaps_Binary_Grid {
    public int minSwaps(int[][] grid) {
        int N = grid.length;
        int[] zeros = new int[N];  // number of consecutive rows in each row from the right
        for (int i=0; i<N; i++) {
            int[] row = grid[i];
            int j = N-1;
            while (j >= 0) {
                if (row[j] == 1) break;
                j--;
            }
            zeros[i] = N-j-1;
        }
        int swaps = 0;
        for (int i=0; i<N; i++) {
            int minZeros = N-i-1;
            if (zeros[i] < minZeros) {
                int j=i+1;
                while (j<N) {
                    if (zeros[j] >= minZeros) {
                        int tmp = zeros[j];
                        for (int idx=j; idx>i; idx--) {
                            // int tmp = zeros[idx];
                            zeros[idx] = zeros[idx-1];
                            // zeros[idx-1] = tmp;
                            swaps++;
                        }
                        zeros[i] = tmp;
                        break;
                    }
                    j++;
                }
                if (j==N) return -1; // swap not found
            }
        }
        return swaps;
    }
}