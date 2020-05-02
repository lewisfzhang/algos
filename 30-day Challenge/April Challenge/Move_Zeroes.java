import java.util.Arrays;
public class Move_Zeroes {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] in = {0,1,0,3,12};
        s.moveZeroes(in);
        System.out.println(Arrays.toString(in));
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != nonZeroIdx) {
                    nums[nonZeroIdx] = nums[i];
                    nums[i] = 0;
                }
                nonZeroIdx++;
            }
        }
    }
}
