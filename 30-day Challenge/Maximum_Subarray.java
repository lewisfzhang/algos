class Maximum_Subarray {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] in = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s.maxSubArray(in));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = nums[i] + ((res > 0) ? res : 0);
            max = Math.max(max, res);
        }
        return max;
    }
}
