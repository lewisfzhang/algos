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
    // RECURSIVE GOD SOLUTION
    // int i = 0;
    // int[] arr;
    // public TreeNode bstFromPreorder(int[] preorder) {
    //     arr = preorder;
    //     return traverse(Integer.MAX_VALUE);
    // }
    // private TreeNode traverse(int bound) {
    //     if (i == arr.length || arr[i] > bound) return null;
    //     TreeNode root = new TreeNode(arr[i++]);
    //     root.left = traverse(root.val);
    //     root.right = traverse(bound);
    //     return root;
    // }
    
    // THE SOLUTION I WANTED BUT NEVER COULD :((
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int i = 1;
        while (i < preorder.length) {
            int val = preorder[i++];
            TreeNode node = stack.peek();
            if (val < node.val) {
                node.left = new TreeNode(val);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && val > stack.peek().val) {
                    node = stack.pop();
                }
                node.right = new TreeNode(val);
                stack.push(node.right);
            }
        }
        return root;
    }
}