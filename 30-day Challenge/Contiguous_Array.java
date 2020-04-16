import java.util.HashMap;
public class Contiguous_Array {
    public static void main(String[] args) {
        System.out.println((new Solution()).findMaxLength(new int[]{0, 1}));
        System.out.println((new Solution()).findMaxLength(new int[]{0, 1, 0}));
    }
}

class Solution {
    public int findMaxLength(int[] nums) {
        // if (nums.length < 1) return 0;
        // int max = 0, lastIdx = 0;
        // for (int i = 1; i < nums.length; i+=2) {
        //     max = Math.max(max, i - lastIdx + 1);
        //     if (nums[i-1] == nums[i]) {
        //         lastIdx = i;
        //     }
        // }
        // return max;

        // map to problem of finding longest subarray of sum 0
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i]==0) nums[i]=-1;
        // }
        HashMap<Integer, Integer> map = new HashMap<>(); // (sum, idx)
        map.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}
