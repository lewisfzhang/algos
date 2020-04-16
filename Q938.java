import java.util.Stack;
public class Q938 {
    public static void main(String[] args) {
        Solution s = new Solution();
    }
}

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        Stack<TreeNode> q = new Stack<>();
        q.push(root);
        while (!q.isEmpty()) {
            TreeNode node = q.pop();
            if (node.val >= L && node.val <= R) {
                sum += node.val;
                if (node.left != null) q.push(node.left);
                if (node.right != null) q.push(node.right);
            } else if (node.val >= L && node.left != null) {
                q.push(node.left);
            } else if (node.val <= R && node.right != null) {
                q.push(node.right);
            }
        }
        return sum;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
    static TreeNode tn() {
        return null;
    }
}
