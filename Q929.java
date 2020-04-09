import java.util.HashSet;
// 12:30 start, 12:50 finish
public class Q929 {
    public static void main(String[] args) {
        run(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
        run(new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"});
    }

    private static void run(String[] s) {
        System.out.println((new Solution()).numUniqueEmails(s));
    }
}

class Solution {
    /** 1 <= emails[i].length <= 100
    *    1 <= emails.length <= 100
    *    Each emails[i] contains exactly one '@' character.
    *    All local and domain names are non-empty.
    *    Local names do not start with a '+' character.
    */
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String s : emails) {
            StringBuilder sb = new StringBuilder();
            boolean local = true;
            for (int i = 0; i < s.length(); i++) {
                if (local) {
                    if (s.charAt(i) == '+') {
                        while (s.charAt(i) != '@') i++;
                    } else if (s.charAt(i) == '.') i++;
                    if (s.charAt(i) == '@') local = false;
                }
                sb.append(s.charAt(i));
            }
            set.add(sb.toString());
        }
        // System.out.println(set);
        return set.size();
    }
}
