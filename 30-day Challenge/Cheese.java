import java.util.Queue;
import java.util.LinkedList;

public class Cheese {
    public static void main(String[] args) {
        int[][] in = {{1, 0, 1, 1, 1, 0, 0, 1},
                      {1, 0, 0, 0, 1, 1, 1, 1},
                      {1, 0, 0, 0, 0, 0, 0, 0},
                      {1, 0, 1, 0, 9, 0, 1, 1},
                      {1, 1, 1, 0, 1, 0, 0, 1},
                      {1, 0, 1, 0, 1, 1, 0, 1},
                      {1, 0, 0, 0, 0, 1, 0, 1},
                      {1, 1, 1, 1, 1, 1, 1, 1}};
        System.out.println(findCheese(in));
    }
    private static int[][] direction = {{1,0}, {0,1}, {0,-1}, {-1, 0}};
    private static int findCheese(int[][] maze) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = maze[pos[0]][pos[1]];
            maze[pos[0]][pos[1]] = 0; // dp, visit each point only once!
            if (x == 9) return 1;
            else if (x == 0) continue;
            for (int[] dir : direction) {
                int nx = pos[0] + dir[0];
                int ny = pos[1] + dir[1];

                if (nx < 0 || ny < 0 || nx >= maze.length || ny >= maze[0].length || maze[nx][ny] == 0)
                    continue;

                q.offer(new int[]{nx, ny});
            }
        }
        return 0;
    }
}
