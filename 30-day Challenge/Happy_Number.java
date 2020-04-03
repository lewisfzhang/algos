import java.util.HashSet;

public class Happy_Number {
    public static void main(String[] args) {
        Solution s = new Solution();
        int in = 2;
        System.out.println(s.isHappy2(in));
    }
}

class Solution {
    // with smart cycle detection
    public boolean isHappy2(int n) {
        int slow = n, fast = n;
        do {
            slow = getHappy(slow);
            fast = getHappy(getHappy(fast));
        } while (slow != fast && fast != 1);
        return fast == 1;
    }

    int getHappy(int n) {
        int sum = 0;
        while (n > 0) {
            sum += SQUARES[n % 10];
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        // return isHappy(n, new HashSet<>());
        HashSet<Integer> h = new HashSet<>();
        int tmp, sum;
        while (!h.contains(n) && n != 1) {
            h.add(n);
            tmp = n;
            sum = 0;
            while (tmp > 0) {
                sum += SQUARES[tmp % 10];
                tmp /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    public boolean isHappy(int n, HashSet<Integer> h) {
        if (n == 1) {
            return true;
        } else if (h.contains(n)) {
            return false;
        } else {
            h.add(n);
            return isHappy(sumSquareDigits(n), h);
        }
    }

    private static int[] SQUARES = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
    public int sumSquareDigits(int n) {
        int x = 0;
        while (n > 0) {
            x += SQUARES[n % 10];
            n /= 10;
        }
        return x;
    }
}
