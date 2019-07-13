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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return traversal(root, k).val;
    }

    TreeNode traversal(TreeNode node, int k) {
        if (node == null)
            return null;

        TreeNode left = traversal(node.left, k);
        if (left != null)
            return left;
        count++;
        if (count == k)
            return node;
        return traversal(node.right, k);
    }
}
