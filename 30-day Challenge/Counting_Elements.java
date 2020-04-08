import java.util.HashSet;

public class Counting_Elements {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1, 2, 3};
        System.out.println(s.countElements(arr));

        arr = new int[]{1,1,3,3,5,5,7,7};
        System.out.println(s.countElements(arr));

        arr = new int[]{1,3,2,3,5,0};
        System.out.println(s.countElements(arr));

        arr = new int[]{1,1,2,2};
        System.out.println(s.countElements(arr));
    }
}

class Solution {
    public int countElements(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x - 1);
        }
        int count = 0;
        for (int x : arr) {
            count += (set.contains(x)) ? 1 : 0;
        }
        return count;
    }
}
