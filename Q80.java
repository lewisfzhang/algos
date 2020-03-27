import java.util.Arrays;
public class Q80 {
    public static void main(String[] args) throws Exception {
        int[] in = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(in));
        System.out.println(Arrays.toString(in));

        in = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(in));
        System.out.println(Arrays.toString(in));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int realIdx = 1, count = 1, lastNum = nums[0];
        for (int currIdx = 1; currIdx < nums.length; currIdx++) {
            if (nums[currIdx] == lastNum) {
                if (count < 2) {
                    nums[realIdx] = nums[currIdx];
                    count++;
                    realIdx++;
                }
            } else {
                lastNum = nums[currIdx];
                count = 1;
                nums[realIdx] = nums[currIdx];
                realIdx++;
            }
        }
        return realIdx;
    }
}
