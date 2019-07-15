/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        sb.delete(sb.length() - 1, sb.length());

        return "[" + sb + "]";
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
            return;
        }

        sb.append(node.val).append(",");
        buildString(node.left, sb);
        buildString(node.right, sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if (data.length() == 0) return null;

        String[] items = data.split(",");
        return buildTree(items, new int[1]);
    }

    private TreeNode buildTree(String[] items, int[] index) {
        if (index[0] == items.length) return null;
        String item = items[index[0]];
        index[0]++;
        if ("null".equals(item)) return null;

        TreeNode root = new TreeNode(Integer.parseInt(item));
        root.left = buildTree(items, index);
        root.right = buildTree(items, index);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
