class Solution {
    /**
     * Sliding window technique to iterate through s2
     * Use array to check if two strings are permutations (same count of each char)
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        
        int[] ctn = new int[26]; // lowercase char
        for (int i = 0; i < len1; i++) {
            ctn[s1.charAt(i) - 'a']++;
            ctn[s2.charAt(i) - 'a']--;
        }
        if (allZeros(ctn)) return true;
        
        for (int i = len1; i < len2; i++) {
            ctn[s2.charAt(i) - 'a']--;
            ctn[s2.charAt(i - len1) - 'a']++;
            if (allZeros(ctn)) return true;
        }
        return false;
    }
    
    private boolean allZeros(int[] arr) {
        for (int x : arr) {
            if (x != 0) return false;
        }
        return true;
    }
}