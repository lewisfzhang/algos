public class Q200 {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] in = process(new String[]{"11110", "11010", "11000", "00000"});
        System.out.println(s.numIslands(in));

        in = process(new String[]{"11000", "11000", "00100", "00011"});
        System.out.println(s.numIslands(in));
    }
    private static char[][] process(String[] arr) {
        int x = arr.length, y = arr[0].length();
        char[][] grid = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                grid[i][j] = arr[i].charAt(j);
            }
        }
        return grid;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length < 1 || grid[0].length < 1) return 0;
        
        int num = 0, x = grid.length, y = grid[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    explore(i, j, x, y, grid);
                }
            }
        }
        return num;
    }
    private void explore(int i, int j, int x, int y, char[][] grid) {
        // set "visited" grids to 0 aka NULL (if grid can be modified)
        // otherwise, created 2d boolean array "visited"
        if (i >= 0 && j >= 0 && i < x && j < y && grid[i][j] == '1') {
            grid[i][j] = 0;
            explore(i + 1, j, x, y, grid);
            explore(i - 1, j, x, y, grid);
            explore(i, j + 1, x, y, grid);
            explore(i, j - 1, x, y, grid);
        }
    }
}
