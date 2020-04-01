import java.util.HashSet;

public class Single_Number {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] in = {2, 2, 1};
        System.out.println(s.singleNumber2(in));

        in = new int[]{4,1,2,1,2};
        System.out.println(s.singleNumber2(in));
    }
}

class Solution {
    // needs extra memory
    public int singleNumber(int[] nums) {
        HashSet<Integer> history = new HashSet<>();
        for (int x : nums) {
            if (history.contains(x)) {
                history.remove(x);
            } else {
                history.add(x);
            }
        }
        return history.iterator().next();
    }

    // based on 2 ideas:
    // a) XOR of a number with itself is 0.
    // b) XOR of a number with 0 is number itself.
    public int singleNumber2(int[] nums) {
        int num = 0;
        for (int x : nums) {
            num ^= x;
        }
        return num;
    }
}
