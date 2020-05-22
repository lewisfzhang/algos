class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() < 3) return s;

        int[] ctn = new int[256];
        for (char c : s.toCharArray()) ctn[c]++;

        PriorityQueue<Character> pq = new PriorityQueue<>((x, y) -> ctn[y] - ctn[x]);
        for (char i = 0; i < 256; i++)
            if (ctn[i] > 0) pq.offer(i);

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < ctn[c]; i++) sb.append(c);
        }

        return sb.toString();
    }
}
