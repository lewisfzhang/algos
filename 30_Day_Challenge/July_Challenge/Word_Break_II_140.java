public class Word_Break_II_140 {
    private Set<String> dict;
    private String s;
    private List<String>[] mem;
    private int minLen, maxLen; // length of words in dict
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty() || wordDict.isEmpty()) return new LinkedList<>();
        dict = new HashSet<>();
        minLen = s.length(); maxLen = 1;
        for (String word : wordDict) {
            if (word.length() <= s.length()) {
                minLen = Math.min(minLen, word.length());
                maxLen = Math.max(maxLen, word.length());
                dict.add(word);
            }
        }
        this.s = s;
        mem = new List[s.length()+1];
        mem[s.length()] = Arrays.asList("");
        return dp(0);
    }
    private List<String> dp(int start) { 
        if (start > s.length()) return new LinkedList<>();
        else if (mem[start] != null) return mem[start];
        List<String> result = new LinkedList<>();
        for (int i=minLen; i<=Math.min(maxLen, s.length()-start); i++) {
            String word = s.substring(start, start+i);
            if (dict.contains(word)) {
                for (String subword : dp(start+i)) {
                    if (subword.isEmpty()) result.add(word);
                    else result.add((new StringBuilder(word)).append(' ').append(subword).toString());
                }
            }
        }
        mem[start] = result;
        return result;
    }
}