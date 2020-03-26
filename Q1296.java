import java.util.TreeMap;

public class Q1296 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,5,6};
        int k = 4;
        assert isPossibleDivide1(nums, k);

        nums = new int[]{3,2,1,2,3,4,3,4,5,9,10,11};
        k = 3;
        assert isPossibleDivide1(nums, k);

        nums = new int[]{3,3,2,2,1,1};
        k = 3;
        assert isPossibleDivide1(nums, k);

        nums = new int[]{1,2,3,4};
        k = 3;
        assert isPossibleDivide1(nums, k);
    }

    // O(nlogn), first sort the array
    public static boolean isPossibleDivide1(int[] nums, int k) {
        assert nums != null && nums.length > 0 && k > 0;
        if (nums.length % k != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int x : nums) {
            map.compute(x, (key, val) -> (val == null) ? 1 : val + 1);
        }

        int count = k, lastVal = 0;
        while (!map.isEmpty()) {
            if (count == k) {
                count = 0;
                lastVal = map.firstKey();
            } else {
                lastVal += 1;
                if (!map.containsKey(lastVal)) {
                    return false;
                }
            }
            map.compute(lastVal, (key, val) -> (val == 1) ? null : val - 1);
            count++;
        }
        return true;
    }
}
