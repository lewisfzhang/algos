class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x = coordinates[0][0], y = coordinates[0][1];
        int dx = coordinates[1][0] - x, dy =  coordinates[1][1] - y;
        for (int i = 2; i < coordinates.length; i++) {
            if (dx * (y - coordinates[i][1]) != dy * (x - coordinates[i][0]))
                return false;
        }
        return true;
    }
}
