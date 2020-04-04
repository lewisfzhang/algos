import java.util.HashMap;
public class Q560 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] in = {1, 1, 1};
        int k = 2;
        System.out.println(s.subarraySum(in, k));
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, result = 0;

        for (int x : nums) {
            sum += x;
            result += map.getOrDefault(sum - k, 0);
            map.compute(sum, (key, val) -> (val == null) ? 1 : val + 1);
        }
        return result;
    }
}
