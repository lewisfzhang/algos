import java.util.Queue;
import java.util.LinkedList;

public class Q994 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = new int[][]{{2, 1, 1},
                                    {1, 1, 0},
                                    {0, 1, 1}};
        System.out.println(s.orangesRotting(input));

        input = new int[][]{{2, 1, 1},
                            {0, 1, 1},
                            {1, 0, 1}};
        System.out.println(s.orangesRotting(input));
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }

        int time = 0;
        int[][] direction = {{1,0}, {0,1}, {0,-1}, {-1, 0}};
        while (!q.isEmpty()) {
            time++;
            int size = q.size();
            for (int x = 0; x < size; x++) {
                int[] pos = q.poll();
                for (int[] dir : direction) {
                    int nx = dir[0] + pos[0];
                    int ny = dir[1] + pos[1];

                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || grid[nx][ny] != 1)
                        continue;

                    grid[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return (time == 0) ? time : time - 1;
    }
}
