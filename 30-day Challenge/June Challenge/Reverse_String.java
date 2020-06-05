class Solution {
    public void reverseString(char[] s) {
        // can make use of 2 pointers!!! (one left, one right) --> take advantage of incrementing by 1 behavior!
        // for (int i=0; i<s.length/2; i++) {
        //     int idx = s.length-i-1;
        //     char tmp = s[i];
        //     s[i] = s[idx];
        //     s[idx] = tmp;
        // }
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}