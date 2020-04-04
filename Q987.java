import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Queue;

public class Q987 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, List<Point>> map = new HashMap<>();
        Queue<Point> queue = new LinkedList<>();
        int min = 0, max = 0;

        queue.offer(new Point(root, 0, 0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            min = Math.min(min, p.x);
            max = Math.max(max, p.x);

            List<Point> l = map.computeIfAbsent(p.x, val -> new ArrayList<>());
            int idx = l.size() - 1;
            while (idx >= 0 && l.get(idx).y == p.y && l.get(idx).node.val > p.node.val) {
                idx--;
            }
            l.add(idx + 1, p);

            if (p.node.left != null) queue.offer(new Point(p.node.left, p.x - 1, p.y + 1));
            if (p.node.right != null) queue.offer(new Point(p.node.right, p.x + 1, p.y + 1));
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            List<Point> pointList = map.get(i);
            if (pointList != null) {
                List<Integer> ll = new LinkedList<>();
                for (Point point : pointList) {
                    ll.add(point.node.val);
                }
                list.add(ll);
            }
        }
        return list;
    }

    private static class Point {
        int x, y;
        TreeNode node;
        Point(TreeNode t, int x, int y) {
            this.x = x;
            this.y = y;
            this.node = t;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}
