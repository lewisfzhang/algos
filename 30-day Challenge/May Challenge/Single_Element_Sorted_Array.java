class Solution {
    public int singleNonDuplicate(int[] nums) { // could use binary search, but this is cleaner
        int res = 0;
        for (int x : nums) res ^= x;
        return res;
    }
}
