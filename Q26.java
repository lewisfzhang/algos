import java.util.Arrays;
public class Q26 {
    public static void main(String[] args) throws Exception {
        int[] in = {1,1,2};
        System.out.println(removeDuplicates(in));
        System.out.println(Arrays.toString(in));

        in = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(in));
        System.out.println(Arrays.toString(in));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int lastNum = nums[0], realIdx = 1;
        for (int currIdx = 1; currIdx < nums.length; currIdx++) {
            if (nums[currIdx] != lastNum) {
                lastNum = nums[currIdx];
                nums[realIdx] = nums[currIdx];
                realIdx++;
            }
        }
        return realIdx;
    }
}
