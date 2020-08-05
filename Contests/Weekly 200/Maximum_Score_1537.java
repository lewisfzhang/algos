import java.util.LinkedList;
import java.util.List;

public class Maximum_Score_1537 {
    // private Long[][] dp; // idx, path
    // private int[][] arr;
    // private HashMap<Integer, Integer>[] map;
    // private static final int MOD = 1000000007; // 10^9 + 7
    public int maxSum(int[] nums1, int[] nums2) {
        // Map<Integer, Integer> vals = new HashMap<>();
        // for (int i=0; i<nums1.length; i++) vals.put(nums1[i], i);
        List<int[]> list = new LinkedList<>();  // map all path crossings (num1_idx, nums2_idx)
        // for (int i=0; i<nums2.length; i++) {
        //     int val = nums2[i];
        //     if (vals.containsKey(val)) list.add(new int[]{vals.get(val), i});
        // }
        int i1 = 0, i2 = 0, len1 = nums1.length, len2 = nums2.length;
        while (i1 < len1) {
            int val = nums1[i1];
            while (i2 < len2 && nums2[i2] < val) i2++;
            if (i2 == len2) break;
            if (nums2[i2] == val) list.add(new int[]{i1, i2});
            i1++;
        }
        list.add(new int[]{len1, len2});
        long score = 0;
        i1 = 0; i2 = 0;
        for (int[] idx : list) {
            int end1 = idx[0], end2 = idx[1];
            long sum1 = 0, sum2 = 0;
            while (i1 < end1) sum1 += nums1[i1++];
            while (i2 < end2) sum2 += nums2[i2++];
            score += Math.max(sum1, sum2);
        }
        return (int) (score % 1000000007); // 10^9 + 7
    }
    //     arr = new int[][]{nums1, nums2};
    //     int len = Math.max(nums1.length, nums2.length);
    //     dp = new Long[2][len];
    //     HashMap<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
    //     map = new HashMap[]{map1, map2};
    //     for (int i=0; i<nums1.length; i++)
    //         map1.put(nums1[i], i);
    //     for (int i=0; i<nums2.length; i++)
    //         map2.put(nums2[i], i);
    //     return (int) (Math.max(dp(0, 0), dp(1, 0)) % MOD);
    // }
    // private long dp(int path, int idx) {
    //     if (idx == arr[path].length) return 0; // end of path
    //     if (dp[path][idx] != null) return dp[path][idx];
    //     int other = 1 - path, curr = arr[path][idx];
    //     long res = curr + dp(path, idx+1);
    //     if (map[other].containsKey(curr))
    //         res = Math.max(res, curr + dp(other, map[other].get(curr)+1));
    //     dp[path][idx] = res;
    //     return res;
    // }
}