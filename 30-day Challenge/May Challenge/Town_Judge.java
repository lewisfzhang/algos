class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] trust_cnt = new int[N+1]; // add other's trust, subtract own trust
        for (int[] arr : trust) {
            int p1 = arr[0], p2 = arr[1];
            trust_cnt[p1] -= p2;
            trust_cnt[p2] += p1;
        }
        int total = N*(N+1)/2;
        for (int i = 1; i <= N; i++) {
            if (trust_cnt[i] + i == total) return i;
        }
        return -1;
    }
}
