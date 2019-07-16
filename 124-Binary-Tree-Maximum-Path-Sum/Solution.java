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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        return Math.max(findMax(root), max);
    }

    int findMax(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, findMax(root.left));
        int right = Math.max(0, findMax(root.right));
        int mid = root.val;
        max = Math.max(max, left + right + mid);

        return Math.max(left, right) + mid;
    }
}
