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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
        int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        TreeNode node = new TreeNode(preorder[preStart]);

        int n = 0;
        int index = inStart;
        while (preorder[preStart] != inorder[index]) {
            n++;
            index++;
        }

        node.left = build(preorder, preStart + 1, preStart + n,
                          inorder, inStart, inStart + n - 1);
        node.right = build(preorder, preStart + n + 1, preEnd,
                          inorder, inStart + n + 1, inEnd);

        return node;
    }
}

class Solution {
    int preIndex;
    int inIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, null);
    }

    TreeNode buildTree(int[] preorder, int[] inorder, TreeNode LastNode) {
        //判断是否遍历完或者是否有左右子树
        if (preIndex == preorder.length || (LastNode != null && LastNode.val == inorder[inIndex]))
            return null;

        TreeNode node = new TreeNode(preorder[preIndex]);
        preIndex++;
        node.left = buildTree(preorder, inorder, node);
        inIndex++;
        node.right = buildTree(preorder, inorder, LastNode);

        return node;
    }
}
