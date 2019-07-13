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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversal(ans, root);

        return ans;
    }

    void traversal(List<Integer> list, TreeNode node) {
        if (node == null)
            return;
        //add node
        traversal(list, node.left);
        list.add(node.val);
        traversal(list, node.right);
    }
}
