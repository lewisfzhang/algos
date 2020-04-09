public class Q852 {
    public static void main(String[] args) {
        run(new int[]{0,1,0});
        run(new int[]{0,2,1,0});
    }
    private static void run(int[] A) {
        Solution s = new Solution();
        System.out.println(s.peakIndexInMountainArray(A));
    }
}

class Solution {
    // note, the bounds work because peak cannot be at end points
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] < A[mid + 1]) lo = mid + 1;
            else if (A[mid] < A[mid - 1]) hi = mid - 1;
            else return mid;
        }
        return -1;
    }
}
