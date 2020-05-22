/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution { 
    int val, n;

    public int kthSmallest(TreeNode root, int k) {
        n = k;
        iterator(root);
        return val;
    }

    public void iterator(TreeNode root) {
        if (root == null) return;

        if (root.left != null) iterator(root.left);

        if (--n == 0) {
            val = root.val;
            return;
        }

        if (root.right != null) iterator(root.right);
    }
}
