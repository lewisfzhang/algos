class Solution {
    public int[] countBits(int num) {
        int N = num+1;
        int[] out = new int[N];
        for (int i = 1; i < N; i++) {
            if ((i & 1) == 0) { // even
                out[i] = out[i >> 1];
            } else { // odd
                out[i] = out[i-1] + 1;
            }
        }
        return out;
    }
}