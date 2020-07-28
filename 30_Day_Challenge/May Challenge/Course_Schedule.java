class Solution {
    // topo sort (BFS)
    public boolean canFinish(int numCourses, int[][] prereq) {
        List<Integer>[] edges = new LinkedList[numCourses];
        for (int i=0; i<numCourses; i++)
            edges[i] = new LinkedList<>();
        
        int[] indegree = new int[numCourses];
        for (int[] arr : prereq) {
            int parent = arr[1], child = arr[0];
            indegree[child]++;
            edges[parent].add(child);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int x=0; x<numCourses; x++) {
            if (indegree[x] == 0)
                queue.add(x);
        }
        
        int numNodes = 0;
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            numNodes++;
            for (int child : edges[parent]) {
                if (--indegree[child] == 0)
                    queue.offer(child);
            }
        }
        
        return numNodes == numCourses;
    }
}