class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length(), lenP = p.length();
        List<Integer> list = new LinkedList<>();
        if (lenS < lenP) return list;
        
        int[] ctn = new int[26];
        for (int i=0; i<lenP; i++) {
            ctn[p.charAt(i) - 'a']++;
            ctn[s.charAt(i) - 'a']--;
        }
        if (allZeros(ctn)) list.add(0);
        
        for (int i=lenP; i<lenS; i++) {
            ctn[s.charAt(i) - 'a']--;
            ctn[s.charAt(i - lenP) - 'a']++;
            if (allZeros(ctn)) list.add(i - lenP + 1);
        }
        return list;
    }
    
    private boolean allZeros(int[] arr) {
        for (int x : arr) 
            if (x != 0) return false;
        return true;
    }
}