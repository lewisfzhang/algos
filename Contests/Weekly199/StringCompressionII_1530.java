// https://leetcode.com/contest/weekly-contest-199/problems/string-compression-ii/
public class StringCompressionII_1530 {
    private char[] str;
    private Integer[][] mem; // Integer[][][][] mem;
    public int getLengthOfOptimalCompression(String s, int k) {
        str = s.toCharArray();
        mem = new Integer[str.length][k+1];
        return dp2(0, k);
        // mem = new Integer[s.length()][26][s.length()][k+1];
        // return dp(0, (char) 0, 0, k);
    }
    private int dp(int idx, char lastChar, int lastCount, int k) {
        if (k < 0) return Integer.MAX_VALUE; // k check must come before idx check! 
        if (idx == str.length) return 0;

        Integer res = (lastChar == 0) ? null : mem[idx][lastChar - 'a'][lastCount][k];
        if (res != null) return res;

        if (str[idx] == lastChar) {
            int addLen = (lastCount == 1 || lastCount == 9 || lastCount == 99) ? 1 : 0;
            res = addLen + dp(idx+1, lastChar, lastCount+1, k);
        } else {
            int keep = 1 + dp(idx+1, str[idx], 1, k);
            int remove = dp(idx+1, lastChar, lastCount, k-1);
            res = Math.min(keep, remove);
        }

        if (lastChar != 0)
            mem[idx][lastChar - 'a'][lastCount][k] = res;
        return res;
    }
    private int dp2(int idx, int k) { // heuristic: remove all except most common character
        if (k >= str.length - idx) return 0;

        Integer res = mem[idx][k];
        if (res != null) return res;
        else res = Integer.MAX_VALUE;

        int[] ctn = new int[26];  // char frequency count
        int most = 0; // most frequent char
        for (int i=idx; i<str.length; i++) {
            most = Math.max(most, ++ctn[str[i]-'a']);
            int k_rem = k - (i-idx+1-most);
            if (k_rem >= 0) {
                int strLen = (most == 1) ? 1 : (most < 10) ? 2 : (most < 100) ? 3 : 4;
                res = Math.min(res, strLen + dp2(i+1, k_rem));
            }
        }
        mem[idx][k] = res;
        return res;
    }
}