/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return findDepth(root, 0);
    }

    int findDepth(TreeNode root, int depth) {
        if (root == null)
            return depth;

        int right = findDepth(root.right, depth + 1);
        int left = findDepth(root.left, depth + 1);
        return Math.max(right, left);
    }
}
