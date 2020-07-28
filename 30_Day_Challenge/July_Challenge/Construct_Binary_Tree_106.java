// 106. Construct Binary Tree from Inorder and Postorder Traversal
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
import java.util.HashMap;
class Solution {
    private int[] inorder, postorder;
    private HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // assume @NonNull inorder, postorder that are permutations of each other
        this.inorder = inorder;
        this.postorder = postorder;
        map = new HashMap<>();
        for (int i=0; i<inorder.length; i++)
            map.put(inorder[i], i); // map inorder values to their idx
        
        return helper(0, inorder.length-1, 0, postorder.length-1);
    }
    private TreeNode helper(int in_start, int in_end, int post_start, int post_end) { // inclusive bounds
        if (in_end < in_start || post_end < post_start) return null;
        int in_root= map.get(postorder[post_end]);
        TreeNode root = new TreeNode(postorder[post_end]);
        // to find where to split left/right partitions of postorder, you can make use of
        // length of "left" partition for inorder!
        int post_right_start = post_start + (in_root - in_start);
        root.left = helper(in_start, in_root-1, post_start, post_right_start - 1);
        root.right = helper(in_root+1, in_end, post_right_start, post_end-1);
        return root;
    }
}
