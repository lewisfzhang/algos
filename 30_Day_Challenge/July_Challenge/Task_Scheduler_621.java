import java.util.Arrays;

public class Task_Scheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        // counting total length --> count number of empty slots + tasks.length
        int[] ctn = new int[26];
        for (char c : tasks) {
            ctn[c - 'A']++;
        }
        Arrays.sort(ctn);
        int slotLen = ctn[25]-1;
        int slotsLeft = slotLen*n;
        for (int i=24; i>=0 && slotsLeft > 0 && ctn[i] > 0; i--) {
            slotsLeft -= Math.min(slotLen, ctn[i]);
        }
        return tasks.length + Math.max(0, slotsLeft);
//         int max = 0, numMax = 0;
//         for (char c : tasks) {
//             ctn[c - 'A']++;
//             if (max == ctn[c - 'A']) {
//                 numMax++;
//             } else if (max < ctn[c - 'A']) {
//                 numMax = 1;
//                 max = ctn[c - 'A'];
//             }
//         }
        
//         int numParts = max - 1;
//         int slotLen = n - (numMax - 1);
//         int numSlots = numParts * slotLen;
//         int numTasks = tasks.length - numMax*max;
//         int numEmpty = Math.max(0, numSlots-numTasks);
//         return tasks.length + numEmpty;

    }
}