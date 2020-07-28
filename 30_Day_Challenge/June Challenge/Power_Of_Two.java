class Solution {
    public boolean isPowerOfTwo(int n) {
        // if (n < 1) return false;
        // while (n != 1) {
        //     if ((n & 1) != 0) return false;
        //     n >>= 1;
        // }
        // return true;
        return n > 0 && (n & (n-1)) == 0;
    }
}