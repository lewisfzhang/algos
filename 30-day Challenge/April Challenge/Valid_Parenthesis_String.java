public class Valid_Parenthesis_String {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkValidString("()"));
        System.out.println(s.checkValidString("(*)"));
        System.out.println(s.checkValidString("(*))"));

    }
}

class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0; // low and hi bounds on unpaired left parenthesis
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                if (low > 0) low--;
                high--;
            } else {
                if (low > 0) low--;
                high++;
            }
            if (high < 0) return false;
        }
        return low == 0;

        // boolean numLeft = 0;
        // int numStar = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if (c == '(') numLeft++;
        //     else if (c == ')') {
        //         if (numLeft > 0) numLeft--;
        //         else {
        //             if (numStar > 0) numStar--;
        //             else return false;
        //         }
        //     }
        //     else numStar++;
        // }
        // return numLeft == 0;
    }
}
