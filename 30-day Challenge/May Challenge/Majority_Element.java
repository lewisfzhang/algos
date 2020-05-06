class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len2 = nums.length / 2;
        for (int x : nums) {
            map.compute(x, (k, v) -> (v == null) ? 1 : v + 1);
            if (map.get(x) > len2) return x;
        }
        return -1;
    }
}
