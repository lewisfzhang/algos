import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Group_Anagrams {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] in = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(s.groupAnagrams(in));
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = new char[26];
            for (char c : s.toCharArray()) ch[c - 'a']++;
            // get count of each char, then use count to construct a new string!
            String key = new String(ch);
            map.computeIfAbsent(key, val -> new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
