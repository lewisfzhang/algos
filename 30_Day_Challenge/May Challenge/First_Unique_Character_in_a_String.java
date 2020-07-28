class Solution {
    public int firstUniqChar(String s) {
        // if (s.length() == 0) return -1;
        // HashMap<Character, Integer> map = new HashMap<>();
        // int idx = 0;
        // for (char c : s.toCharArray()) {
        //     map.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
        //     if (s.charAt(idx) == c) {
        //         while (map.getOrDefault(c, 0) > 1) {
                    // if (++idx < s.length()) c = s.charAt(idx);
                    // else return -1;
        //         }
        //     }
        // }
        // return idx;

        if (s.length() == 0) return -1;
        int[] count = new int[256];
        int idx = 0;
        for (char c : s.toCharArray()) {
            count[c]++;
            if (s.charAt(idx) == c) {
                while (count[c] > 1) {
                    if (++idx < s.length()) c = s.charAt(idx);
                    else return -1;
                }
            }
        }
        return idx;
    }
}
