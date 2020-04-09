import java.util.HashMap;

public class Q3 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        System.out.println(s.lengthOfLongestSubstring("dvdf"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, lastIdx = 0, idx;
        for (idx = 0; idx < s.length(); idx++) {
            char key = s.charAt(idx);
            if (map.getOrDefault(key, -1) >= lastIdx) {
                max = Math.max(max, idx - lastIdx);
                lastIdx = map.get(key) + 1;
            }
            map.put(key, idx);
        }
        return Math.max(max, idx - lastIdx);
    }
}
