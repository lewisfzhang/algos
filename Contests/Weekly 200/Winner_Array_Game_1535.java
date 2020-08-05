public class Winner_Array_Game_1535 {
    public int getWinner(int[] arr, int k) {
        if (k < arr.length) {
            // if (k == 1) return Math.max(arr[0], arr[1]);
            int streak = 0, curr = arr[0];
            for (int i=1; i<arr.length; i++) {
                if (curr > arr[i]) {
                    streak++;
                } else {
                    curr = arr[i];
                    streak = 1;
                }
                if (streak == k) return curr;
            }
            // LinkedList<Integer> list = new LinkedList<>();
            // for (int x : arr) list.add(x);
            // int streak = 0;
            // while (streak < k) {
            //     int first = list.removeFirst(), second = list.removeFirst();
            //     if (first > second) {
            //         list.addFirst(first);
            //         list.addLast(second);
            //         streak++;
            //     } else {
            //         list.addFirst(second);
            //         list.addLast(first);
            //         streak = 1;
            //     }
            // }
            // return list.getFirst();
        }
        int max = Integer.MIN_VALUE;
        for (int x : arr)
            max = Math.max(max, x);
        return max;
    }
}