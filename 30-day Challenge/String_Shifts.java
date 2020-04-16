class String_Shifts {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] shift = {{0, 1}, {1, 2}};
        System.out.println(s.stringShift("abc", shift));

        int[][] shift2 = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};
        System.out.println(s.stringShift("abcdefg", shift2));

        int[][] shift3 = {{1, 4}, {0, 5}, {0, 4}, {1, 1}, {1, 5}};
        System.out.println(s.stringShift("mecsk", shift3));
    }
}

class Solution {
    public String stringShift(String s, int[][] shift) {
        if (s.isEmpty()) return s;
        int x = 0, len = s.length();
        for (int i = 0; i < shift.length; i++) {
            x += (shift[i][0] == 0) ? shift[i][1] : -shift[i][1];
        }
        System.out.println(x);
        while (x < 0) x += len;
        x = x % len;
        System.out.println(x);
        return s.substring(x, len) + s.substring(0, x);
    }
}
