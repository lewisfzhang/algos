public class Solution {
    // Union Find solution
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] group = new int[N];
        for (int i=0; i<N; i++) group[i] = i;
        
        for (int[] arr : dislikes) {
            int a = arr[0]-1, b = arr[1]-1; 
            if (group[a]==a && group[b]==b) {
                group[a] = b;
                group[b] = a;
            } else if (group[a]==a && group[b]!=b) {
                group[a] = group[group[b]];
            } else if (group[b]==b && group[a]!=a) {
                group[b] = group[group[a]];
            } else if (group[a]==group[b]) {
                return false;
            }
        }
        return true;
    }
//     DFS Solution
//     List<Integer>[] graph;
//     int[] group;

//     public boolean possibleBipartition(int N, int[][] dislikes) {
//         graph = new List[N];
//         for (int i=0; i<N; i++) graph[i] = new LinkedList<>();
//         for (int[] arr : dislikes) {
//             int a = arr[0]-1, b = arr[1]-1;
//             graph[a].add(b);
//             graph[b].add(a);
//         }
        
//         group = new int[N];
//         Arrays.fill(group, -1); // -1 = undefined, 0/1 = different side
//         for (int i=0; i<N; i++) {
//             if (group[i]==-1 && !dfs(i, 0))
//                 return false;
//         }
//         return true;
//     }
    
//     private boolean dfs(int i, int side) {
//         if (group[i] == side)
//             return true;
//         else if (group[i] == 1 - side)
//             return false;
        
//         group[i] = side;
//         for (int v : graph[i]) {
//             if (!dfs(v, 1 - side))
//                 return false;
//         }
//         return true;
//     }
}