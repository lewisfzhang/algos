// 10:29, finish 10:50
public class Backspace_String_Compare {
    public static void main(String[] args) {
        run("ab#c", "ad#c");
        run("ab##", "c#d#");
        run("a##c", "#a#c");
        run("a#c", "b");
    }
    public static void run(String S, String T) {
        Solution s = new Solution();
        System.out.println(s.backspaceCompare(S, T));
    }
}

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int s_idx = S.length() - 1, t_idx = T.length() - 1;
        while (s_idx >= 0 || t_idx >= 0) {
            int s_back = 0, t_back = 0;
            char s_ch = 0, t_ch = 0;
            while (s_idx >= 0) {
                char ch = S.charAt(s_idx--);
                s_back += (ch == '#') ? 1 : -1;
                if (s_back < 0) {
                    s_ch = ch;
                    break;
                }
            }
            while (t_idx >= 0) {
                char ch = T.charAt(t_idx--);
                t_back += (ch == '#') ? 1 : -1;
                if (t_back < 0) {
                    t_ch = ch;
                    break;
                }
            }
            if (s_ch != t_ch) return false;
        }
        return true;
    }
}
