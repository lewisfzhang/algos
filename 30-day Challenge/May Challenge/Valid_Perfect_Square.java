class Solution {
    public boolean isPerfectSquare(int num) {
        int lo = 1, hi = num;
        // while (hi*hi <= num) {
        //     lo = hi;
        //     hi *= 2;
        // }
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long mid2 = mid * mid;
            if (mid2 < num) {
                lo = (int) mid + 1;
            } else if (mid2 > num) {
                hi = (int) mid - 1;
            } else return true;
        }
        return false;
    }
}
