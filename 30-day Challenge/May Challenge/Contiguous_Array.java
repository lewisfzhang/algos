class Solution {
    // based on the intuition that if two subarrays have same sum, then elements in between sum to 0 (equal number of 0 and 1)!!!
    public int findMaxLength(int[] nums) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += 2*nums[i] - 1;
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}