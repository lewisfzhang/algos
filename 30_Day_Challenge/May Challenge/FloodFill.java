class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc], rLen = image.length, cLen = image[0].length;
        if (oldColor != newColor) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{sr, sc});
            while (!q.isEmpty()) {
                int[] pos = q.poll();
                int r = pos[0], c = pos[1];
                if (r >= 0 && c >= 0 && r < rLen && c < cLen && image[r][c] == oldColor) {
                    image[r][c] = newColor;
                    q.add(new int[]{r - 1, c});
                    q.add(new int[]{r + 1, c});
                    q.add(new int[]{r, c - 1});
                    q.add(new int[]{r, c + 1});
                }
            }
        }
        return image;
    }
}
