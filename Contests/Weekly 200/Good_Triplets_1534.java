public class Good_Triplets_1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            int a_i = arr[i];
            for (int j=i+1; j<arr.length; j++) {
                int a_j = arr[j];
                if (Math.abs(a_i - a_j) > a) continue;
                for (int k=j+1; k<arr.length; k++) {
                    int a_k = arr[k];
                    if (Math.abs(a_j-a_k) <= b && Math.abs(a_i-a_k) <= c)
                        count++;
                    // if (i!=j && i!=k && j!=k) {
                    //     int x = Math.abs(arr[i]-arr[j]), y = Math.abs(arr[j]-arr[k]), z = Math.abs(arr[i]-arr[k]);
                    //     if (x <= a && y <= b && z <=c) count++;
                    // }
                }
            }
        }
        return count;
    }
}