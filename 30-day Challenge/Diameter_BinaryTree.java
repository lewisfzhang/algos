public class Diameter_BinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println((new Solution()).diameterOfBinaryTree(root));
    }
}

class Solution {
    private int maxLen;
    public int diameterOfBinaryTree(TreeNode root) {
        maxChild(root);
        return maxLen;
    }

    public int maxChild(TreeNode root) {
        if (root == null) return -1;
        int left = maxChild(root.left), right = maxChild(root.right);
        maxLen = Math.max(maxLen, 2 + left + right);
        return 1 + Math.max(left, right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {val = x;}
    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}
