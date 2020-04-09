public class Q162 {
    public static void main(String[] args) {
        run(new int[]{1, 2, 3, 1});
        run(new int[]{1,2,1,3,5,6,4});
    }
    private static void run(int[] nums) {
        Solution s = new Solution();
        System.out.println(s.findPeakElement(nums));
    }
}

class Solution {
    // use invariants, see https://leetcode.com/problems/find-peak-element/discuss/50239/Java-solution-and-explanation-using-invariants
    // note: logarithmic complexity, NUMS[i] =/= NUMS[i+1]!!!
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (hi - lo > 1) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1]) lo = mid + 1;
            else hi = mid; // else condition is just >, not >=!
        }
        // reduces to 2 element array, except with array length is originally 1
        return (lo == hi || nums[lo] > nums[lo + 1]) ? lo : hi;
    }
}
